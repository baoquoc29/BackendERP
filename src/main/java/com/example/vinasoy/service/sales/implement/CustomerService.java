package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.controller.sales.PageResponse;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.sales.ICustomerRepository;
import com.example.vinasoy.service.sales.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public String generateOrderCode() {
        String maxOrderCode = customerRepository.findMaxCustomerCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "CUST-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(5));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "CUST-" + newCodeNumber;
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream().map(
                        customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsByFullNameAndPhoneNumberAndEmail(
                customerDTO.getFullName(), customerDTO.getPhoneNumber(), customerDTO.getEmail()))
            throw new AppException(ErrorCode.EXITS);

        customerDTO.setCustomerId(this.generateOrderCode());
        // convert DTO to entity
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        Customer newCustomer =  customerRepository.save(customer);

        // convert entity to DTO
        return modelMapper.map(newCustomer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) {
        if(!customerRepository.existsById(customerId))
            throw new AppException(ErrorCode.NOT_FOUND_ID);

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        customer.setFullName(customerDTO.getFullName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());

        Customer updateCustomer = customerRepository.save(customer);

        return modelMapper.map(updateCustomer, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String customerId) {
        if(!customerRepository.existsById(customerId)) {
            throw new AppException(ErrorCode.NOT_FOUND_ID);
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO findCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public PageResponse<?> findAllPaginationWithSortByMultipleColumns(final Integer pageSize, final Integer pageNo, final String... sorts) {
        List<Sort.Order> orders = new ArrayList<>();

        for (String sortBy: sorts) {
            //firstName:asc|desc
            Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?)");
            Matcher matcher = pattern.matcher(sortBy);
            if (matcher.find()) {
                if (matcher.group(3).equalsIgnoreCase("asc")) {
                    orders.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
                } else {
                    orders.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
                }
            }
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(orders));

        Page<Customer> customers = customerRepository.findAll(pageable);

        List<CustomerDTO> carsResponse = customers.stream()
                .map(customer -> {
                   return modelMapper.map(customer, CustomerDTO.class);
                }).collect(Collectors.toList());

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(customers.getTotalPages())
                .totalElements(customers.getTotalElements())
                .items(carsResponse)
                .build();
    }

    public PageResponse<?> searchCustomers(Integer pageSize, Integer pageNo, String customerId, String fullName,
                                                  String email, String phoneNumber, String address, String... sort) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(createSortOrder(sort)));

        Specification<Customer> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (customerId != null && !customerId.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("customerId")),
                        "%" + escapeSpecialCharacters(customerId.toLowerCase().trim()) + "%"));
            }
            if (fullName != null && !fullName.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("fullName")),
                        "%" + escapeSpecialCharacters(fullName.toLowerCase().trim()) + "%"));
            }
            if (email != null && !email.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("email")),
                        "%" + escapeSpecialCharacters(email.toLowerCase().trim()) + "%"));
            }
            if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
                predicates.add(cb.like(root.get("phoneNumber"),
                        "%" + escapeSpecialCharacters(phoneNumber.trim()) + "%"));
            }
            if (address != null && !address.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("address")),
                        "%" + escapeSpecialCharacters(address.toLowerCase().trim()) + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Customer> customerPage = customerRepository.findAll(spec, pageable);

        return PageResponse.builder()
                .pageNo(customerPage.getNumber())
                .pageSize(customerPage.getSize())
                .totalPage(customerPage.getTotalPages())
                .totalElements(customerPage.getTotalElements())
                .items(customerPage.getContent())  // Chuyển đổi thành ArrayList
                .build();
    }

    private String escapeSpecialCharacters(String str) {
        return str.replaceAll("([%_\\\\])", "\\\\$1");
    }


    private Sort.Order[] createSortOrder(String[] sort) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }
        return orders.toArray(new Sort.Order[0]);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }
}

package com.example.vinasoy.service.employeeServiceImplement;
import com.example.vinasoy.dto.employee.socialinsuranceDTO.SocialinsuranceDTO;
import com.example.vinasoy.entity.employee.Socialinsurance;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.SocialinsuranceRepository;
import com.example.vinasoy.service.employees.SocialinsuranceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SocialinsuranceServiceImpl implements SocialinsuranceService {

    private final SocialinsuranceRepository socialinsuranceRepository;
    private final ModelMapper modelMapper;

    @Override
    public SocialinsuranceDTO createSocialinsurance(SocialinsuranceDTO socialinsuranceDTO) {
        String newSocialinsuranceId = generateSocialinsuranceId();
        socialinsuranceDTO.setSocialInsuranceID(newSocialinsuranceId);
        Socialinsurance socialinsurance = modelMapper.map(socialinsuranceDTO, Socialinsurance.class);
        Socialinsurance savedSocialinsurance = socialinsuranceRepository.save(socialinsurance);
        return modelMapper.map(savedSocialinsurance, SocialinsuranceDTO.class);
    }

    @Override
    public List<SocialinsuranceDTO> getAllSocialinsurances() {
        return socialinsuranceRepository.findAll().stream()
                .map(socialinsurance -> modelMapper.map(socialinsurance, SocialinsuranceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SocialinsuranceDTO getSocialinsuranceById(String id) {
        Socialinsurance socialinsurance = socialinsuranceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        return modelMapper.map(socialinsurance, SocialinsuranceDTO.class);
    }

    @Override
    public SocialinsuranceDTO updateSocialinsurance(SocialinsuranceDTO socialinsuranceDTO) {
        Socialinsurance socialinsurance = socialinsuranceRepository.findById(socialinsuranceDTO.getSocialInsuranceID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(socialinsuranceDTO, socialinsurance);
        Socialinsurance updatedSocialinsurance = socialinsuranceRepository.save(socialinsurance);
        return modelMapper.map(updatedSocialinsurance, SocialinsuranceDTO.class);
    }

    @Override
    public void deleteSocialinsurance(String id) {
        socialinsuranceRepository.deleteById(id);
    }

    private String generateSocialinsuranceId() {
        return socialinsuranceRepository.findAll()
                .stream()
                .map(Socialinsurance::getSocialInsuranceID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("BHXH-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("BHXH-0001"); // Nếu không có dữ liệu, bắt đầu từ SI-0001
    }
}

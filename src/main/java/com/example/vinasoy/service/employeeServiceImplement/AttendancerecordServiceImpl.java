package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.AttendancerecordDTO;
import com.example.vinasoy.entity.employee.Attendancerecord;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.repository.employees.AttendancerecordRepository;
import com.example.vinasoy.service.employees.AttendancerecordService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AttendancerecordServiceImpl implements AttendancerecordService {

    private final AttendancerecordRepository attendancerecordRepository;
    private final ModelMapper modelMapper;

    @Override
    public AttendancerecordDTO createAttendancerecord(AttendancerecordDTO attendancerecordDTO) {

        String newAttendancerecordId = generateAttendancerecordId();
        attendancerecordDTO.setAttendanceRecordId(newAttendancerecordId);

        Attendancerecord attendancerecord = modelMapper.map(attendancerecordDTO, Attendancerecord.class);
        Attendancerecord savedAttendancerecord = attendancerecordRepository.save(attendancerecord);
        return modelMapper.map(savedAttendancerecord, AttendancerecordDTO.class);
    }

    @Override
    public List<AttendancerecordDTO> getAllAttendancerecords() {
        return attendancerecordRepository.findAll().stream()
                .map(attendancerecord -> modelMapper.map(attendancerecord, AttendancerecordDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AttendancerecordDTO getAttendancerecordById(String id) {
        Attendancerecord attendancerecord = attendancerecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));
        return modelMapper.map(attendancerecord, AttendancerecordDTO.class);
    }

    @Override
    public AttendancerecordDTO updateAttendancerecord(AttendancerecordDTO attendancerecordDTO) {
        Attendancerecord attendancerecord = attendancerecordRepository.findById(attendancerecordDTO.getAttendanceRecordId())
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));
        modelMapper.map(attendancerecordDTO, attendancerecord);
        Attendancerecord updatedAttendancerecord = attendancerecordRepository.save(attendancerecord);
        return modelMapper.map(updatedAttendancerecord, AttendancerecordDTO.class);
    }

    @Override
    public void deleteAttendancerecord(String id) {
        attendancerecordRepository.deleteById(id);
    }

    private String generateAttendancerecordId() {
        return attendancerecordRepository.findAll()
                .stream()
                .map(Attendancerecord::getAttendanceRecordID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("ARD<-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("ARD-0001"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }


}

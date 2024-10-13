package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.AttendancerecordDTO;

import java.util.List;

public interface AttendancerecordService {
    public AttendancerecordDTO createAttendancerecord(AttendancerecordDTO attendancerecordDTO);
    public List<AttendancerecordDTO> getAllAttendancerecords();
    public AttendancerecordDTO getAttendancerecordById(String id);
    public AttendancerecordDTO updateAttendancerecord(AttendancerecordDTO attendancerecordDTO);
    public void deleteAttendancerecord(String id);
}

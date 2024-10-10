package com.example.vinasoy.controller.employeeController;

import com.example.vinasoy.dto.employee.AttendancerecordDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.AttendancerecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendancerecords")
public class AttendanceRecordController {

    private final AttendancerecordService attendancerecordService;

    public AttendanceRecordController(AttendancerecordService attendancerecordService) {
        this.attendancerecordService = attendancerecordService;
    }

    @PostMapping
    public ResponseEntity<?> createAttendanceRecord(@RequestBody AttendancerecordDTO attendancerecordDTO) {
        AttendancerecordDTO createdAttendancerecord = attendancerecordService.createAttendancerecord(attendancerecordDTO);
        ApiResponse<AttendancerecordDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdAttendancerecord);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllAttendanceRecords() {
        List<AttendancerecordDTO> attendancerecords = attendancerecordService.getAllAttendancerecords();
        ApiResponse<List<AttendancerecordDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(attendancerecords);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendanceRecordById(@PathVariable String id) {
        AttendancerecordDTO attendancerecordDTO = attendancerecordService.getAttendancerecordById(id);
        ApiResponse<AttendancerecordDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(attendancerecordDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updateAttendanceRecord(@RequestBody AttendancerecordDTO attendancerecordDTO) {
        AttendancerecordDTO updatedAttendancerecord = attendancerecordService.updateAttendancerecord(attendancerecordDTO);
        ApiResponse<AttendancerecordDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedAttendancerecord);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendanceRecord(@PathVariable String id) {
        attendancerecordService.deleteAttendancerecord(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Attendance record deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}

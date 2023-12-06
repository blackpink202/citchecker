package com.group1.citchecker.Controller;

import com.group1.citchecker.Entity.AttendanceEntity;
import com.group1.citchecker.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/getAllAttendance")
    public List<AttendanceEntity> getAllAttendances() {
        return attendanceService.getAllAttendance();
    }
    @PutMapping("/updateAttendance/{id}")
    public AttendanceEntity updateStudent(@PathVariable int id, @RequestBody AttendanceEntity newAttendanceDetails) {
        return attendanceService.updateAttendance(id, newAttendanceDetails);
    }

    // Delete student record
    @DeleteMapping("/deleteAttendance/{id}")
    public String deleteStudent(@PathVariable int id) {
        return attendanceService.deleteAttendance(id);
    }

    @GetMapping("/{id}")
    public AttendanceEntity getAttendanceById(@PathVariable int id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping("/mark")
    public ResponseEntity<String> markAttendance(@RequestBody AttendanceEntity attendance) {
    	 try {
             attendanceService.markAttendance(attendance);
             return new ResponseEntity<>("Attendance marked successfully!", HttpStatus.OK);
         } catch (Exception e) {
             return new ResponseEntity<>("Error marking attendance: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    // You can add more endpoints as needed, e.g., endpoints to get attendance by class, student, or date.
}
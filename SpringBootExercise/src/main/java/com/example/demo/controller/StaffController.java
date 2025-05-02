package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAll() {
        return staffService.getAllStaffs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Long id) {
        Staff staff = staffService.getStaffById(id);
        return staff != null ? ResponseEntity.ok(staff) :
               ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Staff> create(@RequestBody Staff staff) {
        Staff created = staffService.createStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> update(@PathVariable Long id, @RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.updateStaff(id, staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
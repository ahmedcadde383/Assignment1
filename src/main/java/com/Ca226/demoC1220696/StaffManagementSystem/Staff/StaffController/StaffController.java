package com.Ca226.demoC1220696.StaffManagementSystem.Staff.StaffController;


import com.Ca226.demoC1220696.StaffManagementSystem.Staff.Staff.Staff;
import com.Ca226.demoC1220696.StaffManagementSystem.Staff.StaffService.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Staff")
@AllArgsConstructor
public class   StaffController {

    private final StaffService staffService;



    @GetMapping()
    public Collection<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }


    @PostMapping()
    public void addStaff(@RequestBody Staff newStaff) {
        staffService.createStaff(newStaff);
    }




    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PutMapping("/{id}")
    public Staff updateStaffById(@PathVariable Long id, @RequestBody Staff newStaff) {
        return staffService.UpdateStaff(id, newStaff);
    }


    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }

}
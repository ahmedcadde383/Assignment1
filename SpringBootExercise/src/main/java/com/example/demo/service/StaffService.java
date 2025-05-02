package com.example.demo.service;

import com.example.demo.model.Staff;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {

    private final Map<Long, Staff> staffMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Staff> getAllStaffs() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        Long id = idGenerator.incrementAndGet();
        staff.setId(id);
        staffMap.put(id, staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    public void deleteStaff(Long id) {
        staffMap.remove(id);
    }
}
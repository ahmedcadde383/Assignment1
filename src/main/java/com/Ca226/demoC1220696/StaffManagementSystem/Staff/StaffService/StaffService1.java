package com.Ca226.demoC1220696.StaffManagementSystem.Staff.StaffService;

import com.Ca226.demoC1220696.StaffManagementSystem.Staff.Staff.Staff;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class StaffService1 {
    public Map<Long, Staff> staffs=new ConcurrentHashMap<>();
    public AtomicLong autoId=new AtomicLong();


    public Collection<Staff> getAllStaffs(){
        return staffs.values();
    }

    public Staff getStaffById(Long Id){
        return staffs.get(Id);
    }

    public Staff createStaff(Staff newStaff){
        Long staffId=newStaff.getId() !=null
                ?newStaff.getId()
                :autoId.incrementAndGet();
        newStaff.setId(staffId);
        staffs.put(staffId,newStaff);
        return newStaff;
    }

    public Staff updateStaff(Long Id, Staff newStaff){
        if(staffs.containsKey(Id)){
            Staff oldStaff=getStaffById(Id);
            oldStaff.setName(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());
            staffs.put(Id, oldStaff);
            return oldStaff;
        }
        else
            return null;
    }
    public void deleteStaff(Long Id){
        staffs.remove(Id);
    }
}

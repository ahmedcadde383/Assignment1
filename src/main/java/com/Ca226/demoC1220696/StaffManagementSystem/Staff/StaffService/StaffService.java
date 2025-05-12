package com.Ca226.demoC1220696.StaffManagementSystem.Staff.StaffService;

import com.Ca226.demoC1220696.StaffManagementSystem.Staff.Staff.Staff;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class  StaffService {
    private Map<Long, Staff> Staffs=new ConcurrentHashMap<>();
    private AtomicLong autoid=new AtomicLong();

    public  Collection<Staff> getAllStaffs(){
        return Staffs.values();
    }
    public Staff getStaffById(Long Id){
        return Staffs.get(Id);
    }



    public Staff createStaff(Staff NewStaff){
        Long staffId=NewStaff.getId() !=null
                ? NewStaff.getId()
                :autoid.incrementAndGet();
        NewStaff.setId(staffId);
        Staffs.put(staffId,NewStaff);
        return  NewStaff;
    }



    public Staff updateStaff(Long Id,Staff newStaff){
        if(Staffs.containsKey(Id)){
            Staff oldStaff=getStaffById(Id);
            oldStaff.setName(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());
            Staffs.put(Id,oldStaff);
            return oldStaff;
        }
        else
            return null;
    }


    public void deleteStaff(Long id){
         Staffs.remove(id);
    }


}

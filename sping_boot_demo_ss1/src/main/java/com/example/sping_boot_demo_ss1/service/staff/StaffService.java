package com.example.sping_boot_demo_ss1.service.staff;

import com.example.sping_boot_demo_ss1.model.Staff;
import com.example.sping_boot_demo_ss1.repository.staff.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffService implements IStaffService{

    @Autowired
    private IStaffRepository iStaffRepository;


    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return iStaffRepository.findAll(pageable);
    }

    @Override
    public Staff getOneStaff(int id) {
        return iStaffRepository.findAll()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveStaff(Staff staff) {
        iStaffRepository.save(staff);

    }

    @Override
    public void removeStaff(Staff staff) {
       iStaffRepository.delete(staff);
    }

    @Override
    public Page<Staff> findByName(Pageable pageable, String name) {
        return iStaffRepository.findByName(pageable,name);
    }
}

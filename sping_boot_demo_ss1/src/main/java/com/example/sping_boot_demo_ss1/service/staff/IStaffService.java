package com.example.sping_boot_demo_ss1.service.staff;


import com.example.sping_boot_demo_ss1.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStaffService {

    Page<Staff> findAll(Pageable pageable);

    Staff getOneStaff(int id);

    void saveStaff(Staff staff);

    void removeStaff(Staff staff);

    Page<Staff> findByName(Pageable pageable,String name);

}

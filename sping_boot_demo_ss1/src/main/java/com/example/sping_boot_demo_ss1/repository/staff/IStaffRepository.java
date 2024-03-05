package com.example.sping_boot_demo_ss1.repository.staff;


import com.example.sping_boot_demo_ss1.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IStaffRepository extends JpaRepository<Staff,Long> {
    Page<Staff> findAll(Pageable pageable);

    Page<Staff> findByName(Pageable pageable,String name);

}

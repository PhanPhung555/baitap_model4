package com.example.sping_boot_demo_ss1.repository.job;

import com.example.sping_boot_demo_ss1.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job,Long> {
}

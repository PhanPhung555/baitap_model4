package com.example.sping_boot_demo_ss1.service.job;

import com.example.sping_boot_demo_ss1.model.Job;

import java.util.List;

public interface IJobService {

    List<Job> getAllJob();

    Job getJobById(Long job);
}

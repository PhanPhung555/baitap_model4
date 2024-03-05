package com.example.sping_boot_demo_ss1.service.job;

import com.example.sping_boot_demo_ss1.model.Job;
import com.example.sping_boot_demo_ss1.repository.job.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService{

    @Autowired
    private IJobRepository iJobRepository;

    @Override
    public List<Job> getAllJob() {
        return iJobRepository.findAll();
    }

    @Override
    public Job getJobById(Long job) {
        return iJobRepository.getReferenceById(job);
    }
}

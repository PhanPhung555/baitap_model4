package com.example.sping_boot_demo_ss1.controller;

import com.example.sping_boot_demo_ss1.dto.StaffDTO;
import com.example.sping_boot_demo_ss1.model.Job;
import com.example.sping_boot_demo_ss1.model.Staff;
import com.example.sping_boot_demo_ss1.model.Upload;
import com.example.sping_boot_demo_ss1.service.job.IJobService;
import com.example.sping_boot_demo_ss1.service.staff.IStaffService;
import com.example.sping_boot_demo_ss1.service.uploadFile.UploadFileService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RequestMapping("/home")
@Controller
public class StaffController {

    @Autowired
    private IStaffService iStaffService;

    @Autowired
    private IJobService iJobService;

    @Autowired
    private UploadFileService uploadFileService;


    @PostMapping("/uploadFile")
    public String uploadFileImg(Upload upload) throws Exception{
        uploadFileService.upload(upload.getImgStaff());
        return "redirect:/home/list";
    }

    @GetMapping("/searchStaff")
    public ModelAndView searchStaff(@RequestParam(name = "nameStaff") String nameStaff,
                                    @RequestParam(defaultValue = "0",required = false) int page,
                                    Model model){
        Pageable pageable = PageRequest.of(page,4);
        if(nameStaff.equals(""))
            return new ModelAndView("/home","listStaff",iStaffService.findAll(pageable));

        model.addAttribute("namestaffSearch",nameStaff);
        return new ModelAndView("/home","listStaff",iStaffService.findByName(pageable,nameStaff));
    }
    @PostMapping("/createStaff")
    public String createStaff(@Valid @ModelAttribute("staffDTO") StaffDTO staffDTO,
                              BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors())
            return "/create";

      uploadFileService.upload(staffDTO.getPathImage());
//        Chuyển đổi 1 đối tượng dto thành đối tượng chính để lưu vào database
        Staff staff = new Staff();
        Job job1 = iJobService.getJobById(staffDTO.getJob());
        String path = uploadFileService.getPathImage(staffDTO.getPathImage());

        BeanUtils.copyProperties(staffDTO,staff);
        staff.setPathImage(path);
        staff.setJob(job1);
        iStaffService.saveStaff(staff);
        return "redirect:/home/list";
    }

    @GetMapping("/list")
    public ModelAndView getAllStaff(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,4);
        return new ModelAndView("/home","listStaff",iStaffService.findAll(pageable));
    }

    @PostMapping("/updateStaff")
    public String updateStaff(@Valid @ModelAttribute("staffDTO") StaffDTO staffDTO
            ,BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/update";

        Staff staff = new Staff();
        Job job = iJobService.getJobById(staffDTO.getJob());
        BeanUtils.copyProperties(staffDTO,staff);

         staff.setJob(job);
        iStaffService.saveStaff(staff);
        return "redirect:/home/list";
    }

    @GetMapping("/{id}/removeStaff")
    public String removeStaff(@PathVariable int id){
        iStaffService.removeStaff(iStaffService.getOneStaff(id));
        return "redirect:/home/list";
    }

    @GetMapping("/{id}/nextPageUpdate")
    public String nextPageUpdate(@PathVariable int id, Model model){
        model.addAttribute("staffDTO",new StaffDTO());
        model.addAttribute("staffDTO",iStaffService.getOneStaff(id));
        return "/update";
    }

    @GetMapping("/nextPageCreate")
    public ModelAndView nextPageCreate(){
        return new ModelAndView("/create","staffDTO",new StaffDTO());
    }

    @ModelAttribute("listJob")
    public List<Job> getAllJob(){
        return iJobService.getAllJob();
    }
}

package com.example.demo_case_model4.controller.account;

import com.example.demo_case_model4.common.EncryptPasswordUtils;
import com.example.demo_case_model4.dto.login.UserDTO;
import com.example.demo_case_model4.model.login.Role;
import com.example.demo_case_model4.model.login.User;
import com.example.demo_case_model4.service.role.IRoleService;
import com.example.demo_case_model4.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserService iUserService;

    @ModelAttribute("nameAccount")
    public String getNameAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/nextPageAddAccount")
    public ModelAndView nextPageAddAccount(){
        return new ModelAndView("/account/addAccount","UserDTO",new UserDTO());
    }

    @GetMapping("/nextPageGetAllAccount")
    public ModelAndView nextPageGetAllAccount(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,4);
        return new ModelAndView("/account/listAccount","listAccount",iUserService.findAll(pageable));
    }
    @ModelAttribute("listRole")
    public List<Role> getAllRole(){
        return iRoleService.getAllRole();
    }

    @PostMapping("/addAccount")
    public String addAcount(@Valid @ModelAttribute("UserDTO") UserDTO userDTO,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return "/account/addAccount";
        }
        else {
            User user = new User();
            List<Role> list = new ArrayList<>();
            for (Long idRole : userDTO.getRoles()){
                list.add(iRoleService.getRoleFindByIdRole(idRole));
            }
            BeanUtils.copyProperties(userDTO,user);
            user.setUsername(userDTO.getUsername());
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils(userDTO.getPassword()));
            user.setRoles(list);
            iUserService.saveAndUpdateUser(user);
            return "redirect:/user/";
        }
    }
}

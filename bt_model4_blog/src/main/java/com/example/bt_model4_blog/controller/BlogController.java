package com.example.bt_model4_blog.controller;

import com.example.bt_model4_blog.model.Blog;
import com.example.bt_model4_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ModelAndView getAllBlog(){
        return new ModelAndView("/homeBlog","listBlog",iBlogService.getAllBlogSubString());
    }
    @GetMapping("/nextPageBlogAdd")
    public ModelAndView nextPageBlogAdd(){
        return new ModelAndView("/addBlog","Blog",new Blog());
    }
    @GetMapping("/{idBlog}/nextPageBlogUpdate")
    public ModelAndView nextPageBlogUpdate(@PathVariable("idBlog") Long idBlog){
        System.out.println(iBlogService.getOneBlog(idBlog));
        return new ModelAndView("/updateBlog","Blog",iBlogService.getOneBlog(idBlog));
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("Blog") Blog blog){
        iBlogService.saveAndUpdateBlog(blog);
        return "redirect:/blog/list";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute("Blog") Blog blog){
        iBlogService.saveAndUpdateBlog(blog);
        return "redirect:/blog/nextPageBlogAdd";
    }
    @GetMapping("/remove")
    public String removeBlog(@RequestParam("idBlogHidden") Long idBlogHidden){
        iBlogService.removeBlog(iBlogService.getOneBlog(idBlogHidden));
        return "redirect:/blog/list";
    }


}

package com.example.bt_model4_blog_advanced.controller;

import com.example.bt_model4_blog_advanced.model.Blog;
import com.example.bt_model4_blog_advanced.model.Category;
import com.example.bt_model4_blog_advanced.service.blog.IBlogService;
import com.example.bt_model4_blog_advanced.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ModelAndView getAllBlog(@RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 4);
        return new ModelAndView("/homeBlog", "listBlog", iBlogService.findAll(pageable));
    }

    @GetMapping("/nextPageBlogAdd")
    public ModelAndView nextPageAddBlog() {
        return new ModelAndView("/addBlog", "Blog", new Blog());
    }

    @GetMapping("/{idBlog}/nextPageBlogUpdate")
    public ModelAndView nextPageBlogUpdate(@PathVariable("idBlog") Long idBlog) {
        return new ModelAndView("/updateBlog", "Blog", iBlogService.getOneBlog(idBlog));
    }

    @PostMapping("/addAndUpdate")
    public String addAndUpate(@ModelAttribute("Blog") Blog blog) {
        iBlogService.saveAndUpdateBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/sortBlog")
    public ModelAndView getListOnSort() {
        return new ModelAndView("/homeBlog", "listBlog", iBlogService.getAllBlogPostsSortedByCreatedAt());
    }

    @GetMapping("/remove")
    public String removeBlog(@RequestParam("idBlogHidden") Long idBlogHidden) {
        iBlogService.removeBlog(iBlogService.getOneBlog(idBlogHidden));
        return "redirect:/blog/list";
    }

    @GetMapping("/searchBlog")
    public ModelAndView searchBlog(@RequestParam("nameBlog") String nameBlog,
                                   @RequestParam("dateBlog") Long dateBlog,
                                   @RequestParam("contentBlog") Long contentBlog,
                                   @RequestParam(defaultValue = "0", required = false) int page,
                                   Model model) {
        Pageable pageable = PageRequest.of(page, 4);
        // Pageable pageable = dateBlog == 1 ? PageRequest.of(page, 2) : PageRequest.of(page, 5);


        if (nameBlog.equals(""))
            return new ModelAndView("/homeBlog", "listBlog", iBlogService.findAll(pageable));
        model.addAttribute("nameBlogs" , nameBlog);
        return new ModelAndView("/homeBlog", "listBlog",
                iBlogService.findByTitleAndCategory(pageable, nameBlog, contentBlog));
    }

    @ModelAttribute("listCategory")
    public List<Category> getAllCategory() {
        return iCategoryService.getAllCategory();
    }
}

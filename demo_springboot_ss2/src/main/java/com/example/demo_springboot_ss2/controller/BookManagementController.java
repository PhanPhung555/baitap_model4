package com.example.demo_springboot_ss2.controller;

import com.example.demo_springboot_ss2.dto.BookDTO;
import com.example.demo_springboot_ss2.dto.UserDTO;
import com.example.demo_springboot_ss2.model.Book;
import com.example.demo_springboot_ss2.model.User;
import com.example.demo_springboot_ss2.service.book.IBookService;
import com.example.demo_springboot_ss2.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/home")
@Controller
public class BookManagementController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/listbook")
    public ModelAndView getAllBook() {
        return new ModelAndView("home", "listBook", iBookService.getAllBook());

    }

    @GetMapping("/{idbook}/nextPageOderBook")
    public ModelAndView nextPageOderBook(@PathVariable Long idbook, Model model) {
        Book book = iBookService.getBookId(idbook);
        model.addAttribute("bookid", book.getIdBook());
        model.addAttribute("bookname", book.getNameBook());
        model.addAttribute("bookNumber", book.getNumberBook());
        return new ModelAndView("/create", "UserDTO", new UserDTO());
    }

    @GetMapping("/{idbook}/crudBook")
    public String crudBook(@PathVariable Long idbook,Model model){
        model.addAttribute("BookDTO",new BookDTO());
        model.addAttribute("BookDTO",iBookService.getBookId(idbook));
        return "/updatebook";

    }
    @PostMapping("/updateBook")
    public String updateBook(@Valid @ModelAttribute("BookDTO") BookDTO bookDTO,
                             BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors())
            return "/updatebook";

        Book book = new Book();
        BeanUtils.copyProperties(bookDTO,book);
        iBookService.saveAndUpdate(book);
        return "redirect:/home/listbook";
    }

    @GetMapping("/listUserBook")
    public ModelAndView getListUserBook() {
        return new ModelAndView("/homeUser", "listUser", iUserService.getAllUser());
    }
    @GetMapping("/nextPageAddBook")
    public ModelAndView nextPageAddBook(){
        return new ModelAndView("/addbook","BookDTO", new BookDTO());
    }
    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("BookDTO") BookDTO bookDTO,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/addBook";
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO,book);
        iBookService.saveAndUpdate(book);
        return "redirect:/home/listbook";
    }
    @PostMapping("/borrowBook")
    public String borrowBook(@Valid @ModelAttribute("UserDTO") UserDTO userDTO,
                             BindingResult bindingResult,
                             Model model) throws Exception {
        Book book = iBookService.getBookId(userDTO.getBook());

        if (bindingResult.hasErrors()) {
            model.addAttribute("bookid", book.getIdBook());
            model.addAttribute("bookname",book.getNameBook() );
            model.addAttribute("bookNumber", book.getNumberBook());
            return "/create";
        }

        User user = new User();

        BeanUtils.copyProperties(userDTO, user);
        user.setBook(book);
        iBookService.updatenumberBook(userDTO.getBook(), Long.valueOf(userDTO.getQuantityBook()));
        iUserService.saveUser(user);
        return "redirect:/home/listbook";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("idUserHidden") Long idUserHidden){
       User user =  iUserService.getUserById(idUserHidden);
       Book book = user.getBook();
       iBookService.updateIncreasenumberBook(book.getIdBook(), Long.valueOf(user.getNumberBook()));
       iUserService.returnBook(user);
        return "/homeUser";
    }

}

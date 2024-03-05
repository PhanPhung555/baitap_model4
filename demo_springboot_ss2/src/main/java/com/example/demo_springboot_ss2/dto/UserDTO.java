package com.example.demo_springboot_ss2.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class UserDTO implements Validator {

    @NotBlank(message = "name not null")
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày mượn nhỏ hơn ngày trả")
    private Date borrowed_day;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @FutureOrPresent(message = "Ngày trả lớn hơn ngày mượn")
    private Date pay_day;

    private Long book;

    private Integer quantityBook;

    public UserDTO(String name, Date borrowed_day, Date pay_day, Long book, Integer quantityBook) {
        this.name = name;
        this.borrowed_day = borrowed_day;
        this.pay_day = pay_day;
        this.book = book;
        this.quantityBook = quantityBook;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorrowed_day() {
        return borrowed_day;
    }

    public void setBorrowed_day(Date borrowed_day) {
        this.borrowed_day = borrowed_day;
    }

    public Date getPay_day() {
        return pay_day;
    }

    public void setPay_day(Date pay_day) {
        this.pay_day = pay_day;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Integer getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(Integer quantityBook) {
        this.quantityBook = quantityBook;
    }

    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}

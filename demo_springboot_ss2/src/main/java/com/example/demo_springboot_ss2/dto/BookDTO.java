package com.example.demo_springboot_ss2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDTO implements Validator {

    private Long idBook;
    @NotNull(message = "Tên Sách Ko được để trống")
    private String nameBook;
    @Min(value = 1)
    private Integer numberBook;
    @NotNull(message = "Tên Sách Ko được để trống")
    private String author;
    @NotNull(message = "Tên Sách Ko được để trống")
    private String introduce;

    public BookDTO(String nameBook, Integer numberBook, String author, String introduce) {
        this.nameBook = nameBook;
        this.numberBook = numberBook;
        this.author = author;
        this.introduce = introduce;
    }

    public BookDTO(Long idBook, String nameBook, Integer numberBook, String author, String introduce) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.numberBook = numberBook;
        this.author = author;
        this.introduce = introduce;
    }

    public BookDTO() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(Integer numberBook) {
        this.numberBook = numberBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    /**
     * Validate the given {@code target} object which must be of a
     * {@link Class} for which the {@link #supports(Class)} method
     * typically has returned (or would return) {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors, typically as part of a larger
     * binding process which this validator is meant to participate in.
     * Binding errors have typically been pre-registered with the
     * {@link Errors errors} instance before this invocation already.
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     * @see ValidationUtils
     */
    @Override
    public void validate(Object target, Errors errors) {

    }
}

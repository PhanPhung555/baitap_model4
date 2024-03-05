package com.example.sping_boot_demo_ss1.dto;


import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class StaffDTO implements Validator {

    private Long id;

    @NotBlank(message = "Name is not null")
    @Size(min = 5, max = 45,message = "tên ko được qua dài , giới hạn 5 , tối đa 45")
    private String name;

    @Pattern(regexp = "^(090|093|089)\\d{7}$", message = "Số điện thoại của MobiFone không hợp lệ.")
    @Pattern(regexp = "^03[2-9]\\d{7}$", message = "Số điện thoại của Viettel không hợp lệ.")
    @Pattern(regexp = "^08[1-5]\\d{7}$", message = "Số điện thoại của Vinafone không hợp lệ.")
    private int numberPhone;

    private Double salary;

    @Min(18)
    private Long age;

    @Email
    private String email;

    private Long job;

    private MultipartFile pathImage;

    public StaffDTO(String name, int numberPhone, Double salary, Long job, MultipartFile pathImage) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.job = job;
        this.pathImage = pathImage;
    }

    public StaffDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getJob() {
        return job;
    }

    public void setJob(Long job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getPathImage() {
        return pathImage;
    }

    public void setPathImage(MultipartFile pathImage) {
        this.pathImage = pathImage;
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
        StaffDTO staffDTO = (StaffDTO) target;
        String numberPhone = String.valueOf(staffDTO.getNumberPhone());
        if(numberPhone.isEmpty()) errors.rejectValue("numberPhone","","NumberPhone is not Empty");
    }
}

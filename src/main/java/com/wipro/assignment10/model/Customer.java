package com.wipro.assignment10.model;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Customer {

    @NotBlank(message = "{name.required}")
    @Size(min = 2, max = 30, message = "{name.size}")
    private String name;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotNull(message = "{age.required}")
    @Min(value = 1, message = "{age.invalid}")
    private Integer age;

    @NotBlank(message = "{gender.required}")
    private String gender;

    @NotNull(message = "{dob.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotBlank(message = "{phone.required}")
    @Pattern(regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}(\\sx\\d{1,4})?)$", message = "{phone.invalid}")
    private String phone;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


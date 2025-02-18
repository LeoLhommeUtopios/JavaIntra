package org.example.demospringwebfluxexception.entity;


import jakarta.validation.constraints.*;

public class Personne {
//    @NotBlank(message = "Name cannot be null")
    private String name;
//    @Min(value = 1,message = "age musty be 1")
//    @Max(value = 120,message = "age must be lower then 120")
    private int age;
//    @Email
    private String email;
}

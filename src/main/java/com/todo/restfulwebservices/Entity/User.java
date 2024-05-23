package com.todo.restfulwebservices.Entity;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    @Size(min = 2,message = "Name should at least have 2 Character")
    private String name;
    @Past(message = "Birth Date should be in past!")
    private LocalDate birthDate;
}

package com.example.microdemo.Entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String name;
    private LocalDate birthDate;
}

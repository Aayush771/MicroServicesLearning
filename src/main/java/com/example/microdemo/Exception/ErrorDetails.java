package com.example.microdemo.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetails {

    private LocalDate timestamp;
    private String massage;
    private String details;
}

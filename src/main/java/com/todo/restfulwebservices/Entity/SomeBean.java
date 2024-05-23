package com.todo.restfulwebservices.Entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    private String field2;
    private String field3;
}

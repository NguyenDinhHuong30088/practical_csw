package com.example.practicalcswrestful.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employees {
    private int id;
    private String name;
    private Double salary;
}

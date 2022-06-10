package com.example.practicalcswrestful.model;

import com.example.practicalcswrestful.entity.Employees;

import java.util.List;

public interface EmployeesModel {

    boolean save(Employees employees);
    boolean update(Employees employees, int id);
    boolean delete(int id);
    List<Employees> findAll();
    Employees findById(int id);

}

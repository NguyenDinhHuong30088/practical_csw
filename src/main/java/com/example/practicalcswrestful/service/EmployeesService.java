package com.example.practicalcswrestful.service;

import com.example.practicalcswrestful.entity.Employees;
import com.example.practicalcswrestful.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> findById(Integer id) {
        return employeesRepository.findById(id);
    }

    public Employees save(Employees district) {
        return employeesRepository.save(district);
    }

    public List<Employees> saveAll(List<Employees> districts){return employeesRepository.saveAll(districts);}

    public void deleteById(Integer id) {
        employeesRepository.deleteById(id);
    }
}

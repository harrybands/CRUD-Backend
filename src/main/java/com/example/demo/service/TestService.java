package com.example.demo.service;

import com.example.demo.DTO.EmployeesDTO;
import com.example.demo.repository.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author phucnv
 * @create 6/10/2021 10:58 AM
 */
@Service
public interface TestService {
    String getData();
    List<EmployeesDTO> getEmployeeData(String name);

    void saveEmployee(Employees employees);
    void deleteEmployee(long id);

}


package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.EmployeesDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


/**
 * @Author phucnv
 * @create 6/10/2021 11:01 AM
 */
@Repository
public interface TestRepositoryCustom {
    String getData();
    List<EmployeesDTO> getEmployeeData(String name);
}

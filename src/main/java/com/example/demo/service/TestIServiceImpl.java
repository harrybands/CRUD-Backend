package com.example.demo.service;

import com.example.demo.DTO.EmployeesDTO;
import com.example.demo.repository.EmployeesRepository;
import com.example.demo.repository.TestRepositoryCustom;
import com.example.demo.repository.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author phucnv
 * @create 6/10/2021 10:59 AM
 */
@Service
public class TestIServiceImpl implements TestService {
    @Qualifier("testRepositoryImpl")

    @Autowired
    private TestRepositoryCustom repositoryCustom;
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public String getData() {
        return repositoryCustom.getData();
    }

    @Override
    public List<EmployeesDTO> getEmployeeData(String name) {
        return repositoryCustom.getEmployeeData(name);
    }

    @Override
    public void saveEmployee(Employees employees) {
        // 22/12/2021
        try {
            employeesRepository.save(employees);
            //employeesRepository.save(employees);
            System.out.println(employees + "aaaaaa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAaaaILED");
        }
    }

//    @Override
//    public void updateEmployee(long id, Employees employees) {
//        Optional<Employees> employeesData1 = employeesRepository.findById(id);
//        if (employeesData1.isPresent()) {
//            Employees _employees = employeesData1.get();
//            _employees.setFullName(employees.getFullName());
//            _employees.setAddress(employees.getAddress());
//            _employees.setGender(employees.getGender());
//            _employees.setCreateDate((Timestamp) employees.getCreateDate());
//            _employees.setUpdateDate((Timestamp) employees.getUpdateDate());
//            _employees.setStatus(employees.getStatus());
//            System.out.println(employees + "God blesses you");
//            employeesRepository.save(_employees);
//        } else {
//            System.out.println("Updating failed ");
//        }
//    }

    @Override
    public void deleteEmployee(long id) {
        try {
            employeesRepository.deleteById(id);
            System.out.println(id + " succesfully deleted ?");
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("ngu :(");
        }
    }
}


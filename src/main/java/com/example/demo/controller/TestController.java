package com.example.demo.controller;

import com.example.demo.DTO.EmployeesDTO;
import com.example.demo.repository.Employees;
import com.example.demo.repository.TestRepositoryCustom;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;


/**
 * @Author phucnv
 * @create 6/10/2021 10:54 AM
 */
@CrossOrigin
@Controller
@RequestMapping("/getData")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<List<EmployeesDTO>> testApi(@RequestParam(required = false) String name) {
        System.out.println("name in controller " + name);
        List<EmployeesDTO> get = testService.getEmployeeData(name);
        System.out.println(get);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

//    @PostMapping("/tutorials")
//    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {

//    @DeleteMapping("/employees/{id}")
//    public Map<String, boolean> deleteEmployee(@PathVariable Long id) {
//        Employees employees =
//    }

    @PostMapping("/add")
    @CrossOrigin
    public ResponseEntity<Employees> createData(@RequestBody Employees employees) {
        testService.saveEmployee(employees);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/update")
    @CrossOrigin
    public ResponseEntity<Employees> updateData(@RequestBody Employees employees) {
        System.out.println(employees + "db changing");
        return new ResponseEntity<>( employees, HttpStatus.OK);
        }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@RequestParam("id") long id) {
       System.out.println("data that are being deleted has an ID of: " + id);
       testService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

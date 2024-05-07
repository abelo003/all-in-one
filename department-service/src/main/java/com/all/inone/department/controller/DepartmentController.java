package com.all.inone.department.controller;

import com.all.inone.department.entity.Department;
import com.all.inone.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    /*public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }*/

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController.");
        return departmentService.save(department);
    }

    @GetMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartment(@PathVariable Long departmentId) {
        log.info("Inside saveDepartment method of DepartmentController.");
        return departmentService.getDeparmentById(departmentId);
    }

}

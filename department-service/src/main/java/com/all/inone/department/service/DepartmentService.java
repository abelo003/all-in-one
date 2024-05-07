package com.all.inone.department.service;

import com.all.inone.department.entity.Department;
import com.all.inone.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    /**public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }*/

    public Department save(Department department) {
        log.info("Inside save of DeparmentService.");
        return departmentRepository.save(department);
    }

    public Department getDeparmentById(Long id) {
        log.info("Inside getDeparmentById of DeparmentService.");
        return departmentRepository.findByDepartmentId(id);
    }



}

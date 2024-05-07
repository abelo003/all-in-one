package com.all.inone.department.repository;

import com.all.inone.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentId(Long id);

}

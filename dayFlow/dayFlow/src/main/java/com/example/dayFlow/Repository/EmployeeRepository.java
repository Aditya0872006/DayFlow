package com.example.dayFlow.Repository;


import com.example.dayFlow.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

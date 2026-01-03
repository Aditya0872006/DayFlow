package com.example.dayFlow.Repository;

import com.example.dayFlow.models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll,Long> {
}

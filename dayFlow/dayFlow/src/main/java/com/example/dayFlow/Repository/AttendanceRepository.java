package com.example.dayFlow.Repository;

import com.example.dayFlow.models.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendence,Long> {
}

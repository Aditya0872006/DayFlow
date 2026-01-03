package com.example.dayFlow.Repository;

import com.example.dayFlow.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository  extends JpaRepository<Leave,Long> {
}

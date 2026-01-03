package com.example.dayFlow.Repository;


import com.example.dayFlow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User,Long> {
}

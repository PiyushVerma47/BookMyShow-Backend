package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String emailId);
}

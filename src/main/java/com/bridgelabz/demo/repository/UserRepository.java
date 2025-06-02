package com.bridgelabz.demo.repository;

import com.bridgelabz.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

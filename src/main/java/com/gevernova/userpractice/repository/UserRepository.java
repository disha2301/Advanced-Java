package com.gevernova.userpractice.repository;

import com.gevernova.userpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.gevernova.demo.repository;

import com.gevernova.demo.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}

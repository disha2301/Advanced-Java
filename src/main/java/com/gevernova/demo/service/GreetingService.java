package com.gevernova.demo.service;

import com.gevernova.demo.entity.Greeting;
import com.gevernova.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }
    public Greeting getSimpleGreeting() {
        return new Greeting("Hello World");
    }
    public Greeting getCustomGreeting(String fName, String lName) {
        if (fName != null && lName != null) {
            return new Greeting("Hello " + fName + " " + lName);
        } else if (fName != null) {
            return new Greeting("Hello " + fName);
        } else if (lName != null) {
            return new Greeting("Hello " + lName);
        } else {
            return getSimpleGreeting();
        }
    }

    public Greeting saveGreeting(Greeting greeting) {
        return repository.save(greeting);
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return repository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    public Greeting updateGreeting(Long id, String message) {
        return repository.findById(id).map(g -> {
            g.setMessage(message);
            return repository.save(g);
        }).orElse(null);
    }

    public boolean deleteGreeting(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}


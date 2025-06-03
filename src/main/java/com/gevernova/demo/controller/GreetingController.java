package com.gevernova.demo.controller;

import com.gevernova.demo.entity.Greeting;
import com.gevernova.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/greetings")

public class GreetingController {
    private GreetingService service;

    public GreetingController(GreetingService service){
        this.service = service;
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    // UC2 - GET simple greeting
    @GetMapping("/simple")
    public Greeting getSimpleGreeting(){
        return service.getSimpleGreeting();
    }
    // UC3 - GET greeting with optional params
    @GetMapping("/custom")
    public Greeting getCustomGreeting(
        @RequestParam(required = false) String fName,
                @RequestParam(required = false) String lName){
        return service.getCustomGreeting(fName,lName);
    }
    // UC4 - POST save greeting
    public Greeting saveGreeting(@RequestBody Greeting greeting){
        return service.saveGreeting(greeting);
    }
    // UC5 - GET greeting by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return service.getGreetingById(id);
    }

    // UC6 - GET all greetings
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return service.getAllGreetings();
    }
    // UC7 - PUT edit greeting
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody String message){
        return service.updateGreeting(id, message);
    }
    // UC8 - DELETE greeting
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean deleted = service.deleteGreeting(id);
        return deleted ? "Greeting deleted successfully" : "Greeting not found";
    }
}

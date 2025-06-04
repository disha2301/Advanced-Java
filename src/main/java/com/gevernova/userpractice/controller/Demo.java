package com.gevernova.userpractice.controller;

import com.gevernova.userpractice.entity.User;
import com.gevernova.userpractice.service.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // controller + response body
public class Demo {
    DemoService demoService;

    // dependency injection

    // 1. constructor injection - mostly used
    public Demo(DemoService demoService){
        this.demoService = demoService;
    }

    // pathvariable usage

    //localhost:8080/hello/Spring/Boot
    @RequestMapping(value = "/hello/{fName}/{lName}", method = RequestMethod.GET)
    public String messageOne(@PathVariable String fName, @PathVariable String lName){
        return fName+" "+lName;
    }

    // RequestParam usage

    // localhost:8080/param?fName=Spring&lName=Boot
    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String messageTwo(@RequestParam String fName, @RequestParam String lName){
        return fName+" "+lName;
    }

    // pathvariable and requestparam usage

    @RequestMapping(value = "/path/{fName}")
    public String messageThree(@PathVariable String fName, @RequestParam String lName){
        return fName+" "+lName;
    }

    // request body

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User addUsers(@RequestBody User user){
//        return user;
//    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return demoService.addUser(user);
    }

    @GetMapping
    public List<User> findAllUser(){
        return demoService.findAllUser();
    }

    // GET - http://localhost:8081/1
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return demoService.findUserById(id);
    }

    // PUT - ttp://localhost:8081/1
    @PutMapping("/{id}")
    public User updateData(@PathVariable int id, @RequestBody User user){
        return demoService.updateUser(id,user);
    }

    // DELETE METHOD - http://localhost:8081/1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        demoService.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }

}

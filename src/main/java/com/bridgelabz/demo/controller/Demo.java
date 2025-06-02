package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.entity.User;
import com.bridgelabz.demo.service.DemoService;
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

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return demoService.findUserById(id);
    }

    @PutMapping("/{id}")
    public User updateData(@PathVariable int id, @RequestBody User user){
        return demoService.updateUser(id,user);
    }
}

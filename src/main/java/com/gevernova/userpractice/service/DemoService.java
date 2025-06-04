package com.gevernova.userpractice.service;

import com.gevernova.userpractice.entity.User;
import com.gevernova.userpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private UserRepository userRepository;

    public DemoService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public String message(){
        return "Hello Disha";
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public User findUserById(int id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public User updateUser(int id, User user){
        User userById = findUserById(id);
        userById.setfName(user.getfName());
        userById.setlName(user.getlName());
        userById.setMail(user.getMail());
        userById.setSalary(user.getSalary());
        return userRepository.save(userById);
    }
    public void deleteUser(int id) {
        User user = findUserById(id); // check if user exists
        userRepository.delete(user);
    }
}

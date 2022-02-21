package com.example.users;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RequestMapping("/users")
@RestController
public class UserController {
    private List<User> users = Arrays.asList(
        new User(1,"zuck"),
        new User(2,"stanley"),
        new User(3,"bill")
    );
    @GetMapping
    public List<User> getAllUers(){
        return users;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return users.stream().filter(user->user.getId()==id).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}

package com.example.admin;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {
    private final List<Admin> admin = Arrays.asList(
        new Admin(1,"mark","phoney"),
        new Admin(2,"macro","person"),
        new Admin(3,"monica","tele")
    );
    @GetMapping
    public List<Admin> getAllDetails(){
        return admin;
    }
    @GetMapping("/{id}")
    public Admin getDetailById(@PathVariable int id){
        return admin.stream().filter(order->order.getId()==id).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}

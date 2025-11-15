package com.example.CrudApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    // CREATE
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return repo.save(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    // DELETE USER BY ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
        return "User deleted: " + id;
    }
}

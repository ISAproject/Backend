package com.example.ISA2023.back.user;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUnverified(@RequestBody User user){
        user.setVerified(false);
        return userService.save(user);
    }
    @PostMapping("/verify/{id}")
    public User verify(@PathVariable Long id, @RequestBody User verifiedUser){
        verifiedUser.setVerified(true);
        return userService.update(id, verifiedUser);
    }
    @GetMapping("email/{email}")
    public User getByEmail(@PathVariable String email){
        var user = userService.findByEmail(email);
        return user;
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User updatedUser){return userService.update(id,updatedUser);}


}

package com.pointofsale.controller;

import com.pointofsale.dto.login.LoginRespone;
import com.pointofsale.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/registratsi")
    public ResponseEntity<LoginRespone> saveUser(@RequestBody LoginRespone request){
        ResponseEntity<LoginRespone> respone = saveUser(request);
        return ResponseEntity.ok(respone.getBody());
    }
}

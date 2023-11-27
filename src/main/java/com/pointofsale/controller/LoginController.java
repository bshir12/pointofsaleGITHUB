package com.pointofsale.controller;

import com.pointofsale.dto.login.LoginKaryawanRequest;
import com.pointofsale.dto.login.LoginPembeliRequest;
import com.pointofsale.dto.login.LoginRespone;
import com.pointofsale.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/karyawan")
    public ResponseEntity<LoginRespone> login(@RequestBody LoginKaryawanRequest request) {
        LoginRespone response = loginService.loginKaryawan(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/pembeli")
    public ResponseEntity<LoginRespone> login(@RequestBody LoginPembeliRequest request) {
        LoginRespone response = loginService.loginPembeli(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

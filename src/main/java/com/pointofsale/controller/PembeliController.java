package com.pointofsale.controller;

import com.pointofsale.dto.pembeli.PembeliRequest;
import com.pointofsale.dto.pembeli.PembeliRespone;
import com.pointofsale.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {


    @Autowired
    private PembeliService pembeliService;


    @GetMapping
    public ResponseEntity<List<PembeliRespone>> getAllPembeli(@RequestHeader("token") String token) {
        List<PembeliRespone> response = pembeliService.getAllPembeli(token);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/registratsi")
    public ResponseEntity<PembeliRespone> savePembeli(@RequestBody PembeliRequest request) throws Exception {
        PembeliRespone respone = pembeliService.savePembeli(request);
        return ResponseEntity.ok(respone);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PembeliRespone> updatePembeliById(@RequestHeader("token")String token,@PathVariable("id")Integer id, @RequestBody PembeliRequest request) throws Exception {
        PembeliRespone respone = pembeliService.updatePembeliById(token,id, request);
        return ResponseEntity.ok(respone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePembeliById(@RequestHeader("token")String token,@PathVariable("id") Integer id) throws Exception {
        String respone = pembeliService.deletePembeliById(token,id);
        return ResponseEntity.ok(respone);
    }

}

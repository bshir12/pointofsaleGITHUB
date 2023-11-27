package com.pointofsale.controller;

import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barang")
public class BarangController {

    @Autowired
    private BarangService barangService;


    @GetMapping
    public ResponseEntity<List<BarangRespone>> getAllBarang(@RequestHeader("token") String token) throws Exception {
        List<BarangRespone> response = barangService.getAllBarang(token);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/add")
    public ResponseEntity<BarangRespone> saveBarang(@RequestHeader String token, @RequestBody BarangRequest request) throws Exception {
        BarangRespone respone = barangService.saveBarang(token,request);
        return ResponseEntity.ok(respone);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<BarangRespone> updateBarangById(@RequestHeader("token")String token, @PathVariable("id")Integer id, @RequestBody BarangRequest request) throws Exception {
        BarangRespone respone = barangService.updateBarangById(token,id, request);
        return ResponseEntity.ok(respone);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBarangById(@RequestHeader("token")String token,@PathVariable("id") Integer id) throws Exception {
        String respone = barangService.deleteBarangById(token,id);
        return ResponseEntity.ok(respone);
    }


}

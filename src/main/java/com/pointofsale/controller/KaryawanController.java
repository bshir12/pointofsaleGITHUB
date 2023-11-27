package com.pointofsale.controller;

import com.pointofsale.dto.karyawan.KaryawanRequest;
import com.pointofsale.dto.karyawan.KaryawanRespone;
import com.pointofsale.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {


    @Autowired
    private KaryawanService karyawanService;


    @GetMapping
    public ResponseEntity<List<KaryawanRespone>> getAllKaryawan(@RequestHeader("token") String token) {
        List<KaryawanRespone> response = karyawanService.getAllKaryawan(token);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/registratsi")
    public ResponseEntity<KaryawanRespone> saveKaryawan(@RequestBody KaryawanRequest request){
        KaryawanRespone respone = karyawanService.saveKaryawan(request);
        return ResponseEntity.ok(respone);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<KaryawanRespone> updateKaryawanById(@RequestHeader("token")String token, @PathVariable("id")Integer id, @RequestBody KaryawanRequest request) throws Exception {
        KaryawanRespone respone = karyawanService.updateKaryawanById(token,id, request);
        return ResponseEntity.ok(respone);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKaryawanById(@RequestHeader("token")String token,@PathVariable("id") Integer id) throws Exception {
        String respone = karyawanService.deleteKaryawanById(token,id);
        return ResponseEntity.ok(respone);
    }

}

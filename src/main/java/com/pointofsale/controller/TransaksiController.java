package com.pointofsale.controller;

import com.pointofsale.dto.transaksi.DetailTransaksi;
import com.pointofsale.dto.transaksi.TransaksiRequest;
import com.pointofsale.dto.transaksi.TransaksiRespone;
import com.pointofsale.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {


    @Autowired
    private TransaksiService transaksiService;

    @GetMapping
    public ResponseEntity<List<TransaksiRespone>> getAllTransaksi(@RequestHeader("token") String token) {
        List<TransaksiRespone> response = transaksiService.getAllTransaksi(token);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/{id}/detail")
    public ResponseEntity<DetailTransaksi> getTransaksiDetail(@RequestHeader("token") String token, @PathVariable("id") Integer pembeliId) {
        DetailTransaksi response = transaksiService.getTransaksiByPembeliId(token, pembeliId);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/add")
    public ResponseEntity<TransaksiRespone> saveTransaksi(@RequestHeader String token, @RequestBody TransaksiRequest request) throws Exception {
        TransaksiRespone respone = transaksiService.saveTransaksi(token,request);
        return ResponseEntity.ok(respone);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<TransaksiRespone> updateTransaksiById(@RequestHeader("token")String token, @PathVariable("id")Integer id, @RequestBody TransaksiRequest request) throws Exception {
        TransaksiRespone respone = transaksiService.updateTransaksiById(token,id, request);
        return ResponseEntity.ok(respone);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaksiById(@RequestHeader("token")String token,@PathVariable("id") Integer id) throws Exception {
        String respone = transaksiService.deleteTransaksiById(token,id);
        return ResponseEntity.ok(respone);
    }


}

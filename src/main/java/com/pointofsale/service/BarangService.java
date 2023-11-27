package com.pointofsale.service;

import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.entitiy.Barang;
import com.pointofsale.repository.BarangRepository;
import com.pointofsale.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;
    @Autowired
    private PembeliRepository pembeliRepository;

    @Autowired
    private  TokenService tokenService;


    public List<BarangRespone> getAllBarang(String token) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        List<BarangRespone> listBarang = new ArrayList<>();
        for (Barang barang : barangRepository.findAll()) {
            listBarang.add(BarangRespone.builder()
                    .id(barang.getId())
                    .stockBarang(barang.getStockBarang())
                    .kodeBarang(barang.getKodeBarang())
                    .namaBarang(barang.getNamaBarang())
                    .hargaBarang(barang.getHargaBarang())
                    .detailBarang(barang.getDetailBarang())
                    .build());
        }
        return listBarang;
    }



    public BarangRespone saveBarang(String token,BarangRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }

        Barang barang = new Barang();

        barang.setId(barang.getId());
        barang.setStockBarang(request.getStockBarang());
        barang.setKodeBarang(request.getKodeBarang());
        barang.setNamaBarang(request.getNamaBarang());
        barang.setHargaBarang(request.getHargaBarang());
        barang.setDetailBarang(request.getDetailBarang());
        barangRepository.save(barang);

        return BarangRespone.builder()
                .id(barang.getId())
                .stockBarang(request.getStockBarang())
                .kodeBarang(request.getKodeBarang())
                .namaBarang(request.getNamaBarang())
                .hargaBarang(request.getHargaBarang())
                .detailBarang(request.getDetailBarang())
                .build();
    }



    public BarangRespone updateBarangById(String token, Integer id, BarangRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        Optional<Barang> barang = barangRepository.findById(id);
        Barang b = new Barang();

        if (!barang.get().getId().equals(id)) {
            throw new Exception();
        } else {
            b.setId(id);
            b.setStockBarang(request.getStockBarang());
            b.setKodeBarang(request.getKodeBarang());
            b.setNamaBarang(request.getNamaBarang());
            b.setHargaBarang(request.getHargaBarang());
            b.setDetailBarang(request.getDetailBarang());
            barangRepository.save(b);
        }

        return BarangRespone.builder()
                .id(barang.get().getId())
                .stockBarang(request.getStockBarang())
                .kodeBarang(request.getKodeBarang())
                .namaBarang(request.getNamaBarang())
                .hargaBarang(request.getHargaBarang())
                .detailBarang(request.getDetailBarang())
                .build();
    }


    public String deleteBarangById(String token,Integer id) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        String respone = "";
        Optional<Barang>  barang = null;
        try {
            barang = barangRepository.findById(id);
            barangRepository.deleteById(id);
            respone = "Deleted Success";
        }catch (Exception e){
            throw new Exception();
        }
        return respone;
    }




}

package com.pointofsale.service;

import com.pointofsale.dto.transaksi.DetailTransaksi;
import com.pointofsale.dto.transaksi.InfoTransaksi;
import com.pointofsale.dto.transaksi.TransaksiRequest;
import com.pointofsale.dto.transaksi.TransaksiRespone;
import com.pointofsale.entitiy.Barang;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.entitiy.Transaksi;
import com.pointofsale.repository.BarangRepository;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private TransaksiRepository transaksiRepository;
    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private PembeliRepository pembeliRepository;


    public List<TransaksiRespone> getAllTransaksi(String token) {
        if (!tokenService.getToken(token)) {
            return null;
        }

        List<TransaksiRespone> listTransaksi = new ArrayList<>();
        for (Transaksi transaksi : transaksiRepository.findAll()) {
            listTransaksi.add(TransaksiRespone.builder()
                    .id(transaksi.getId())
                    .kodeTransaksi(transaksi.getKodeTransaksi())
                    .totalBayar(transaksi.getTotalBayar())
                    .jumlahBeli(transaksi.getJumlahBeli())
                    .tanggalTransaksi(transaksi.getTanggalTransaksi())
                    .idPembeli(transaksi.getId())
                    .idBarang(transaksi.getId())
                    .build());
        }
        return listTransaksi;
    }



    public DetailTransaksi getTransaksiByPembeliId(String token, Integer pembeliId) {
        if (!tokenService.getToken(token)) {
            return null;
        }

        Optional<Pembeli> optional = pembeliRepository.findById(pembeliId);
        if (!optional.isPresent()) {
            return null;
        }
        Pembeli pembeli = optional.get();
        List<InfoTransaksi> listTransaksi = transaksiRepository.findDetailTransaksi(pembeliId);

        return DetailTransaksi.builder()
                .namaPembeli(pembeli.getNama())
                .noTelepon(pembeli.getNoTelepon())
                .alamat(pembeli.getAlamat())
                .listTransaksi(listTransaksi)
                .build();
    }



    public TransaksiRespone saveTransaksi(String token, TransaksiRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }

        Transaksi transaksi = new Transaksi();
        Barang barang = barangRepository.findById(request.getBarangId()).orElseThrow(() -> new EntityNotFoundException("Barang dengan ID " + request.getBarangId() + " tidak ditemukan"));
        Pembeli pembeli = pembeliRepository.findById(request.getPembeliId()).orElseThrow(() -> new EntityNotFoundException("Pembeli dengan ID " + request.getPembeliId() + " tidak ditemukan"));

        transaksi.setKodeTransaksi(request.getKodeTransaksi());
        transaksi.setTotalBayar(request.getTotalBayar());
        transaksi.setJumlahBeli(request.getJumlahBeli());
        transaksi.setTanggalTransaksi(new Date());
        transaksi.setBarang(barang);
        transaksi.setPembeli(pembeli);
        transaksiRepository.save(transaksi);

        return TransaksiRespone.builder()
                .id(transaksi.getId())
                .idBarang(barang.getId())
                .idPembeli(pembeli.getId())
                .kodeTransaksi(transaksi.getKodeTransaksi())
                .totalBayar(transaksi.getTotalBayar())
                .jumlahBeli(transaksi.getJumlahBeli())
                .tanggalTransaksi(new Date())
                .build();
    }



    public TransaksiRespone updateTransaksiById(String token, Integer id, TransaksiRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        Optional<Transaksi> transaksi = transaksiRepository.findById(id);
        Transaksi t = new Transaksi();
        Barang barang = barangRepository.findById(request.getBarangId()).orElseThrow(() -> new EntityNotFoundException("Barang dengan ID " + request.getBarangId() + " tidak ditemukan"));
        Pembeli pembeli = pembeliRepository.findById(request.getPembeliId()).orElseThrow(() -> new EntityNotFoundException("Pembeli dengan ID " + request.getPembeliId() + " tidak ditemukan"));

        if (!transaksi.get().getId().equals(id)) { //
            throw new Exception();
        } else {
            t.setId(id);
            t.setKodeTransaksi(request.getKodeTransaksi());
            t.setTotalBayar(request.getTotalBayar());
            t.setJumlahBeli(request.getJumlahBeli());
            t.setTanggalTransaksi(new Date());
            t.setBarang(barang);
            t.setPembeli(pembeli);
            transaksiRepository.save(t);
        }

        return TransaksiRespone.builder()
                .id(transaksi.get().getId())
                .idBarang(request.getBarangId())
                .idPembeli(request.getPembeliId())
                .kodeTransaksi(request.getKodeTransaksi())
                .totalBayar(request.getTotalBayar())
                .jumlahBeli(request.getJumlahBeli())
                .tanggalTransaksi(new Date())
                .build();
    }

    public String deleteTransaksiById(String token,Integer id) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        String respone = "";
        Optional<Transaksi>  transaksi = null;
        try {
            transaksi = transaksiRepository.findById(id);
            transaksiRepository.deleteById(id);
            respone = "Deleted Success";
        }catch (Exception e){
            throw new Exception();
        }
        return respone;
    }



}

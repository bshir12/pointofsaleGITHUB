package com.pointofsale.service;

import com.pointofsale.dto.pembeli.PembeliRequest;
import com.pointofsale.dto.pembeli.PembeliRespone;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PembeliService {


    @Autowired
    private PembeliRepository pembeliRepository;

    @Autowired
    private TokenService tokenService;


    public List<PembeliRespone> getAllPembeli(String token) {
        if (!tokenService.getToken(token)) {
            return null;
        }
        List<PembeliRespone> listPembeli = new ArrayList<>();
        for (Pembeli pembeli : pembeliRepository.findAll()) {
            listPembeli.add(PembeliRespone.builder()
                    .id(pembeli.getId())
                    .noTelepon(pembeli.getNoTelepon())
                    .email(pembeli.getEmail())
                    .nama(pembeli.getNama())
                    .alamat(pembeli.getAlamat())
                    .tanggalLahir(pembeli.getTanggalLahir())
                    .jenisKelamin(pembeli.getJenisKelamin())
                    .build());
        }
        return listPembeli;
    }


    public PembeliRespone savePembeli(PembeliRequest request) {

        Pembeli pembeli = new Pembeli();

        pembeli.setNoTelepon(request.getNoTelepon());
        pembeli.setEmail(request.getEmail());
        pembeli.setNama(request.getNama());
        pembeli.setAlamat(request.getAlamat());
        pembeli.setTanggalLahir(request.getTanggalLahir());
        pembeli.setJenisKelamin(request.getJenisKelamin());
        pembeliRepository.save(pembeli);

        return PembeliRespone.builder()
                .id(pembeli.getId())
                .noTelepon(pembeli.getNoTelepon())
                .email(pembeli.getEmail())
                .nama(pembeli.getNama())
                .alamat(pembeli.getAlamat())
                .tanggalLahir(pembeli.getTanggalLahir())
                .jenisKelamin(pembeli.getJenisKelamin())
                .build();
    }


    public PembeliRespone updatePembeliById(String token, Integer id, PembeliRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        Optional<Pembeli> pembeli = pembeliRepository.findById(id);
        Pembeli p = new Pembeli();

        if (!pembeli.get().getId().equals(id)) {
            throw new Exception();
        } else {
            p.setId(id);
            p.setNoTelepon(request.getNoTelepon());
            p.setEmail(request.getEmail());
            p.setNama(request.getNama());
            p.setAlamat(request.getAlamat());
            p.setTanggalLahir(request.getTanggalLahir());
            p.setJenisKelamin(request.getJenisKelamin());
            pembeliRepository.save(p);
        }

        return PembeliRespone.builder()
                .id(pembeli.get().getId())
                .noTelepon(request.getNoTelepon())
                .email(request.getEmail())
                .nama(request.getNama())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();
    }


    public String deletePembeliById(String token,Integer id) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        String respone = "";
        Optional<Pembeli>  pembeli = null;
        try {
            pembeli = pembeliRepository.findById(id);
            pembeliRepository.deleteById(id);
            respone = "Deleted Success";
        }catch (Exception e){
            throw new Exception();
        }
        return respone;
    }


}

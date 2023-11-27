package com.pointofsale.service;

import com.pointofsale.dto.karyawan.KaryawanRequest;
import com.pointofsale.dto.karyawan.KaryawanRespone;
import com.pointofsale.entitiy.Karyawan;
import com.pointofsale.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Autowired
    private TokenService tokenService;


    public List<KaryawanRespone> getAllKaryawan(String token) {
        if (!tokenService.getToken(token)) {
            return null;
        }
        List<KaryawanRespone> listKaryawan = new ArrayList<>();
        for (Karyawan karyawan : karyawanRepository.findAll()) {
            listKaryawan.add(KaryawanRespone.builder()
                    .id(karyawan.getId())
                    .nik(karyawan.getNik())
                    .email(karyawan.getEmail())
                    .nama(karyawan.getNama())
                    .alamat(karyawan.getAlamat())
                    .tanggalLahir(karyawan.getTanggalLahir())
                    .jenisKelamin(karyawan.getJenisKelamin())
                    .build());
        }
        return listKaryawan;
    }


    public KaryawanRespone saveKaryawan(KaryawanRequest request) {

        Karyawan karyawan = new Karyawan();

        karyawan.setNik(request.getNik());
        karyawan.setEmail(request.getEmail());
        karyawan.setNama(request.getNama());
        karyawan.setAlamat(request.getAlamat());
        karyawan.setTanggalLahir(request.getTanggalLahir());
        karyawan.setJenisKelamin(request.getJenisKelamin());
        karyawanRepository.save(karyawan);

        return KaryawanRespone.builder()
                .id(karyawan.getId())
                .nik(karyawan.getNik())
                .email(karyawan.getEmail())
                .nama(karyawan.getNama())
                .alamat(karyawan.getAlamat())
                .tanggalLahir(karyawan.getTanggalLahir())
                .jenisKelamin(karyawan.getJenisKelamin())
                .build();
    }


    public KaryawanRespone updateKaryawanById(String token, Integer id, KaryawanRequest request) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        Optional<Karyawan> karyawan = karyawanRepository.findById(id);
        Karyawan k = new Karyawan();

        if (!karyawan.get().getId().equals(id)) {
            throw new Exception();
        } else {
            k.setId(id);
            k.setNik(request.getNik());
            k.setEmail(request.getEmail());
            k.setNama(request.getNama());
            k.setAlamat(request.getAlamat());
            k.setTanggalLahir(request.getTanggalLahir());
            k.setJenisKelamin(request.getJenisKelamin());
            karyawanRepository.save(k);
        }

        return KaryawanRespone.builder()
                .id(karyawan.get().getId())
                .nik(request.getNik())
                .email(request.getEmail())
                .nama(request.getNama())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();
    }


    public String deleteKaryawanById(String token,Integer id) throws Exception {
        if (!tokenService.getToken(token)) {
            throw new Exception("TOKEN TIDAK VALID");
        }
        String respone = "";
        Optional<Karyawan>  karyawan = null;
        try {
            karyawan = karyawanRepository.findById(id);
            karyawanRepository.deleteById(id);
            respone = "Deleted Success";
        }catch (Exception e){
            throw new Exception();
        }
        return respone;
    }




}

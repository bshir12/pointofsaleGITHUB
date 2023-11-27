package com.pointofsale.service;

import com.pointofsale.dto.login.LoginKaryawanRequest;
import com.pointofsale.dto.login.LoginPembeliRequest;
import com.pointofsale.dto.login.LoginRespone;
import com.pointofsale.entitiy.Karyawan;
import com.pointofsale.entitiy.Login;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.repository.KaryawanRepository;
import com.pointofsale.repository.LoginRepository;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private KaryawanRepository karyawanRepository;
    @Autowired
    private PembeliRepository pembeliRepository;
    @Autowired
    private LoginRepository loginRepository;


    public LoginRespone loginKaryawan(LoginKaryawanRequest request) {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findWithUserDataByEmailAndNik(request.getEmail(),
                request.getNik());
        if (!optionalKaryawan.isPresent()) {
            return null;
        }
          Login login = new Login();
        Karyawan karyawan = optionalKaryawan.get();

        karyawan.setNik(request.getNik());
        karyawan.setEmail(request.getEmail());
        karyawan.setId(request.getKaryawanId());
        login.setTanggalLogin(new Date());
        login.setId(login.getId());
        login.setKaryawan(karyawan);
        login.setToken(JwtToken.getTokenKaryawan(request));
        loginRepository.save(login);

        return LoginRespone.builder()
                .token(login.getToken())
                .build();
    }


    public LoginRespone loginPembeli(LoginPembeliRequest request) {
        Optional<Pembeli> optionalPembeli = pembeliRepository.findWithUserDataByEmailAndNoTelepon(request.getEmail(),
                request.getNoTelepon());
        if (!optionalPembeli.isPresent()) {
            return null;
        }
        Login login = new Login();
        Pembeli pembeli = optionalPembeli.get();

        pembeli.setNoTelepon(request.getNoTelepon());
        pembeli.setEmail(request.getEmail());
        pembeli.setId(request.getPembeliId());
        login.setId(login.getId());
        login.setTanggalLogin(new Date());
        login.setToken(JwtToken.getTokenPembeli(request));
        login.setPembeli(pembeli);
        loginRepository.save(login);

        return LoginRespone.builder()
                .token(login.getToken())
                .build();
    }




}

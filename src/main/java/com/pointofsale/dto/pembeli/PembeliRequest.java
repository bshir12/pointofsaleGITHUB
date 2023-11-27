package com.pointofsale.dto.pembeli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class PembeliRequest {

    private String noTelepon;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

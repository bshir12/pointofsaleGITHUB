package com.pointofsale.dto.pembeli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PembeliRespone {

    private Integer id;
    private String noTelepon;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

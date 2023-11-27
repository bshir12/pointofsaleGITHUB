package com.pointofsale.dto.pembeli;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PembeliRequest {

    private String noTelepon;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

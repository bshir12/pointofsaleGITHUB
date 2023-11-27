package com.pointofsale.dto.pembeli;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PembeliRequest {

    private String noTelepon;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

package com.pointofsale.dto.pembeli;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PembeliRequest {

    private String noTelepon;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

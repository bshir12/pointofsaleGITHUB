package com.pointofsale.dto.karyawan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KaryawanRequest {

    private String nik;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

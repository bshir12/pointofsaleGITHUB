package com.pointofsale.dto.karyawan;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KaryawanRequest {

    private String nik;
    private String email;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;

}

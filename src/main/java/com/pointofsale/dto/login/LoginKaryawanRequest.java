package com.pointofsale.dto.login;

import lombok.Data;

@Data
public class LoginKaryawanRequest {

    private String email;
    private String nik;
    private Integer karyawanId;
}

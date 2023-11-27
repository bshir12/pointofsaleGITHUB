package com.pointofsale.dto.login;

import lombok.Data;

@Data
public class LoginPembeliRequest {

    private String email;
    private String noTelepon;
    private Integer pembeliId;

}

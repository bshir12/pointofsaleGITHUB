package com.pointofsale.util;

import com.pointofsale.dto.login.LoginKaryawanRequest;
import com.pointofsale.dto.login.LoginPembeliRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Date;

public class JwtToken {

    public static String getTokenKaryawan(LoginKaryawanRequest request) {
        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills + 255);
        Date expireDate = new Date(nowMills);
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject(String.valueOf(request))
                .setAudience("users")
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return compactJws;
    }


    public static String getTokenPembeli(LoginPembeliRequest request) {
        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills + 255);
        Date expireDate = new Date(nowMills);
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject(String.valueOf(request))
                .setAudience("users")
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return compactJws;
    }

}

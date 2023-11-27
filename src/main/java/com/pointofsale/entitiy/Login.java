package com.pointofsale.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String token;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tanggalLogin;


    @OneToOne
    private Karyawan karyawan;

    @OneToOne
    private Pembeli Pembeli;

}

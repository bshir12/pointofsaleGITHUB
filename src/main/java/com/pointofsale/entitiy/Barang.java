package com.pointofsale.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer stockBarang;
    private String kodeBarang;
    private String namaBarang;
    private Integer hargaBarang;
    private String detailBarang;


}

package com.pointofsale.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kodeTransaksi;
    private Double totalBayar;
    private Integer jumlahBeli;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tanggalTransaksi;



    @ManyToOne
    private Pembeli pembeli;
    @ManyToOne
    private Barang barang;

}

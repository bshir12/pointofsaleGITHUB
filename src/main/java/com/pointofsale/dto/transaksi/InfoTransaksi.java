package com.pointofsale.dto.transaksi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
public class InfoTransaksi {


    private Integer kodeTransaksi;
    private String kodeBarang;
    private String namaBarang;
    private Integer jumlahBeli;
    private Double totalBayar;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tanggalTransaksi;

}

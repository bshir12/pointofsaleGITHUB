package com.pointofsale.dto.transaksi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class TransaksiRespone {

    private Integer id;
    private Integer idPembeli;
    private Integer idBarang;
    private String kodeTransaksi;
    private Double totalBayar;
    private Integer jumlahBeli;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date tanggalTransaksi;

}

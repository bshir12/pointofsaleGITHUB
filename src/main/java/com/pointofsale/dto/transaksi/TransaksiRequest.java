package com.pointofsale.dto.transaksi;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TransaksiRequest {

    private Integer pembeliId;
    private Integer barangId;
    private String kodeTransaksi;
    private Double totalBayar;
    private Integer jumlahBeli;


}

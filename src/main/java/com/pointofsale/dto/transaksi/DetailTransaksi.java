package com.pointofsale.dto.transaksi;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DetailTransaksi {

    private String namaPembeli;
    private String noTelepon;
    private String alamat;
    private List<InfoTransaksi> listTransaksi;

}

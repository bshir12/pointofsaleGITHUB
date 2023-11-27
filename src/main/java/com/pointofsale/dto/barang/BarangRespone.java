package com.pointofsale.dto.barang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BarangRespone {

    private Integer id;
    private Integer stockBarang;
    private String kodeBarang;
    private String namaBarang;
    private Integer hargaBarang;
    private String detailBarang;

}

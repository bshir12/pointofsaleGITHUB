package com.pointofsale.dto.barang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarangRequest {

    private Integer stockBarang;
    private String kodeBarang;
    private String namaBarang;
    private Integer hargaBarang;
    private String detailBarang;

}

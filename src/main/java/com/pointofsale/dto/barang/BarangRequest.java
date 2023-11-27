package com.pointofsale.dto.barang;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BarangRequest {

    private Integer stockBarang;
    private String kodeBarang;
    private String namaBarang;
    private Integer hargaBarang;
    private String detailBarang;

}

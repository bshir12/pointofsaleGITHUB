package com.pointofsale.dto.barang;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BarangRequest {

    private Integer stockBarang;
    private String kodeBarang;
    private String namaBarang;
    private Integer hargaBarang;
    private String detailBarang;

}

package com.pointofsale.Testing;

import com.pointofsale.dto.transaksi.TransaksiRequest;
import com.pointofsale.dto.transaksi.TransaksiRespone;
import com.pointofsale.entitiy.Barang;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.entitiy.Transaksi;
import com.pointofsale.repository.BarangRepository;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.repository.TransaksiRepository;
import com.pointofsale.service.TokenService;
import com.pointofsale.service.TransaksiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransaksiServiceTest {

    @Mock
    private TokenService tokenService;

    @Mock
    private TransaksiRepository transaksiRepository;

    @Mock
    private BarangRepository barangRepository;

    @Mock
    private PembeliRepository pembeliRepository;

    @InjectMocks
    TransaksiService transaksiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveTransaksi() throws Exception{
        //ini untuk parameter tuk hit saveTransaksi()
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMb2dpblBlbWJlbGlSZXF1ZXN0KGVtYWlsPWFzZmFmYSwgbm9UZWxlcG9uPTQ0NDQ0NCwgcGVtYmVsaUlkPTYpIiwiYXVkIjoidXNlcnMiLCJpYXQiOjE3MDAzMTYyMjAsImV4cCI6MTcwMDMxNjIyMH0.mP2GiIDnJLet7YUL2R8P34Ar96OgqUJavVL1vzZzZPfpPNhnK8CLz5dlrVaUriltd_Psvmgr1dqbLz7E51eSKA";
        TransaksiRequest request = new TransaksiRequest(1, 1, "12", 10000.00, 2);

        //ini Mocking TokenService
        when(tokenService.getToken(token)).thenReturn(true); //klo di baca, ketika tokenService.getToken(token)). maka hasilkan true

        //Mocking Barang repo
        Barang barang = new Barang();
        barang.setId(1);
        when(barangRepository.findById(request.getBarangId())).thenReturn(Optional.of(barang));
        //klo di baca, ketika barangRepository.findById(request.getBarangId())). maka hasilkan data" barangId = 1

        //Mocking Pembeli repo
        Pembeli pembeli = new Pembeli();
        pembeli.setId(1);
        when(pembeliRepository.findById(request.getPembeliId())).thenReturn(Optional.of(pembeli));
        //klo di baca, ketika pembeliRepository.findById(request.getPembeliId())). maka hasilkan data" pembeliId = 1

        //Mocking Transaksi repo
        when(transaksiRepository.save(any(Transaksi.class))).thenAnswer(invocation -> {
            Transaksi saveTransaksi = invocation.getArgument(0);
            saveTransaksi.setId(1); //simulasi simpan ke DB
            return saveTransaksi;
        });
        //klo dibaca, ketika repo tranksasi dijalankan. kita buat seolah-olah terjadi menyimpan database

        //iniTestingnya
        TransaksiRespone respone = transaksiService.saveTransaksi(token, request);

        //kumpulan Assertions
        assertNotNull(respone.getId());
        assertEquals(request.getBarangId(), respone.getIdBarang());
        assertEquals(request.getPembeliId(), respone.getIdPembeli());
        assertEquals(request.getKodeTransaksi(), respone.getKodeTransaksi());
        assertEquals(request.getTotalBayar(), respone.getTotalBayar());
        assertEquals(request.getJumlahBeli(), respone.getJumlahBeli());
        assertNotNull(respone.getTanggalTransaksi());

    }

    @Test
    public void testSaveTransaksiInvalidToken() throws Exception{
        //ini untuk parameter tuk hit saveTransaksi()
        String token = "invalid_token";
        TransaksiRequest request = new TransaksiRequest(1, 1, "12", 10000.00, 2);

        //mocking tokenservice
        when(tokenService.getToken(token)).thenReturn(false); //klo di baca, ketika tokenService.getToken(token)). maka hasilkan false, biar gagal

        Exception exception = assertThrows(Exception.class, () -> {
            transaksiService.saveTransaksi(token, request);
        });

        assertEquals("TOKEN TIDAK VALID", exception.getMessage());
    }

}

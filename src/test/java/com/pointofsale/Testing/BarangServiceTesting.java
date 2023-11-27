package com.pointofsale.Testing;

import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.entitiy.Barang;
import com.pointofsale.entitiy.Transaksi;
import com.pointofsale.repository.BarangRepository;
import com.pointofsale.service.BarangService;
import com.pointofsale.service.TokenService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BarangServiceTesting {

    @InjectMocks
    BarangService barangService;

    @Mock
    TokenService tokenService;

    @Mock
    BarangRepository barangRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBarangInvalidToken(){
        String token = "token";

        BarangRequest request = new BarangRequest(12, "barang", "barang test", 1244, "testing");

        when(tokenService.getToken(token)).thenReturn(false);

        Exception exception = Assert.assertThrows(Exception.class, () ->{
           barangService.saveBarang(token, request);
        });

        Assert.assertEquals("TOKEN TIDAK VALID", exception.getMessage());
    }

    @Test
    public void testSaveBarang() throws Exception {
        String token = "token";

        BarangRequest request = new BarangRequest(12, "barang", "barang test", 1244, "testing");

        when(tokenService.getToken(token)).thenReturn(true);

        when(barangRepository.save(any(Barang.class))).thenAnswer(invocation -> {
            Barang saveBarang = invocation.getArgument(0);
            saveBarang.setId(1);
            return saveBarang;
        });

        BarangRespone respone = barangService.saveBarang(token, request);

        assertNotNull(respone.getId());
        assertEquals(request.getStockBarang(), respone.getStockBarang());
        assertEquals(request.getKodeBarang(), respone.getKodeBarang());
        assertEquals(request.getNamaBarang(), respone.getNamaBarang());
        assertEquals(request.getHargaBarang(), respone.getHargaBarang());
        assertEquals(request.getDetailBarang(), respone.getDetailBarang());
    }
}

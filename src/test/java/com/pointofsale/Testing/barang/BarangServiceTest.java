package com.pointofsale.Testing.barang;

import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.entitiy.Barang;
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

public class BarangServiceTest {
    @InjectMocks
    BarangService barangService;

    @Mock
    TokenService tokenService;

    @Mock
    BarangRepository barangRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBarangInvaidToken() throws Exception {
        String token = "token";
        BarangRequest request = new BarangRequest(10, "barang", "Rokok", 10000, "tembakau");

        when(tokenService.getToken(token)).thenReturn(true);

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            barangService.saveBarang(token, request);
        });

        Assert.assertEquals("Token Tidak Valid", exception.getMessage());
    }

    @Test
    public void testSaveBarang() throws Exception{
        String token = "token";

        BarangRequest request = new BarangRequest(10, "barang", "rokok", 10000, "tembakau");

        when(tokenService.getToken(token)).thenReturn(true);

        when(barangRepository.save(any(Barang.class))).thenAnswer(invocationOnMock -> {
            Barang saveBarang = invocationOnMock.getArgument(0);
            saveBarang.setId(1);
            return saveBarang;
        });

        BarangRespone respone = barangService.saveBarang(token,request);

        assertNotNull(respone.getId());
        assertEquals(request.getStockBarang(),respone.getStockBarang());
        assertEquals(request.getKodeBarang(),respone.getKodeBarang());
        assertEquals(request.getNamaBarang(),respone.getNamaBarang());
        assertEquals(request.getHargaBarang(),respone.getHargaBarang());
        assertEquals(request.getDetailBarang(),respone.getDetailBarang());

    }
}

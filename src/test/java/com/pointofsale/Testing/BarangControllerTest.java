package com.pointofsale.Testing;

import com.pointofsale.controller.BarangController;
import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.service.BarangService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BarangControllerTest {

    @InjectMocks
    BarangController barangController;

    @Mock
    BarangService barangService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBarang() throws Exception{
        String token = "token";
        BarangRequest request = new BarangRequest(12, "kode", "barang", 2005, "test");
        BarangRespone mockRespone = new BarangRespone(1, 12, "kode", "barang", 2005, "test");
        when(barangService.saveBarang(token, request)).thenReturn(mockRespone);

        ResponseEntity<BarangRespone> responseEntity = barangController.saveBarang(token, request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockRespone, responseEntity.getBody());
    }
}

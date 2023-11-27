package com.pointofsale.Testing.barang;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testSaveBarang() throws Exception{
        String token = "token";
        BarangRequest request = new BarangRequest(10, "barang", "rokok", 10000, "tembakau");
        BarangRespone mockResponse = new BarangRespone(1, 50, "barang", "rokok", 10000, "tembakau");
        when(barangService.saveBarang(token,request)).thenReturn(mockResponse);

        ResponseEntity<BarangRespone> responseEntity = barangController.saveBarang(token,request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }
}

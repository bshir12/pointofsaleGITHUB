package com.pointofsale.Testing;

import com.pointofsale.controller.TransaksiController;

import com.pointofsale.dto.transaksi.TransaksiRequest;
import com.pointofsale.dto.transaksi.TransaksiRespone;
import com.pointofsale.service.TransaksiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Date;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TransaksiControllerTest {

    @InjectMocks
    TransaksiController transaksiController;

    @Mock
     TransaksiService transaksiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveTransaksi() throws Exception {

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMb2dpblBlbWJlbGlSZXF1ZXN0KGVtYWlsPWFzZmFmYSwgbm9UZWxlcG9uPTQ0NDQ0NCwgcGVtYmVsaUlkPTYpIiwiYXVkIjoidXNlcnMiLCJpYXQiOjE3MDAzMTYyMjAsImV4cCI6MTcwMDMxNjIyMH0.mP2GiIDnJLet7YUL2R8P34Ar96OgqUJavVL1vzZzZPfpPNhnK8CLz5dlrVaUriltd_Psvmgr1dqbLz7E51eSKA";
        TransaksiRequest request = new TransaksiRequest(1, 1, "5", 70000.00, 3); // Provide appropriate values
        TransaksiRespone mockResponse = new TransaksiRespone(1, 1, 1, "5", 88880.0, 4, new Date()); // Provide appropriate values
        when(transaksiService.saveTransaksi(token, request)).thenReturn(mockResponse);

        ResponseEntity<TransaksiRespone> responseEntity = transaksiController.saveTransaksi(token, request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());

    }

}

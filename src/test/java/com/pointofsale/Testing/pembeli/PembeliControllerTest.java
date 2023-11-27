package com.pointofsale.Testing.pembeli;

import com.pointofsale.controller.PembeliController;
import com.pointofsale.dto.barang.BarangRequest;
import com.pointofsale.dto.pembeli.PembeliRequest;
import com.pointofsale.dto.pembeli.PembeliRespone;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.service.PembeliService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PembeliControllerTest {
    @InjectMocks
    PembeliController pembeliController;

    @Mock
    PembeliService pembeliService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPembeli()throws Exception{
        PembeliRequest request = new PembeliRequest("085156162351","marsyal071@gmail.com","Arsyal","Bekasi","8 Agustus 2000","Laki-laki");
        PembeliRespone mockResponse = new PembeliRespone(1,"085156162351","marsyal071@gmail.com","Arsyal","Bekasi","8 Agustus 2000","Laki-laki");

        when(pembeliService.savePembeli(request)).thenReturn(mockResponse);

        ResponseEntity<PembeliRespone> responseEntity = pembeliController.savePembeli(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }
}

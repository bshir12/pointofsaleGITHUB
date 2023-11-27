package com.pointofsale.Testing;

import com.pointofsale.controller.PembeliController;
import com.pointofsale.dto.barang.BarangRespone;
import com.pointofsale.dto.pembeli.PembeliRequest;
import com.pointofsale.dto.pembeli.PembeliRespone;
import com.pointofsale.service.PembeliService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PembeliControllerTest {

    @InjectMocks
    PembeliController pembeliController;

    @Mock
    PembeliService pembeliService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisPembeli() throws Exception{
        PembeliRequest request = new PembeliRequest("1234", "adit", "adyt", "jkt", "11-08-2002", "ada");
        PembeliRespone mockRespone = new PembeliRespone(1, "1234", "adit", "adyt", "jkt", "11-08-2002", "ada");
        when(pembeliService.savePembeli(request)).thenReturn(mockRespone);

        ResponseEntity<PembeliRespone> responseEntity = pembeliController.savePembeli(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockRespone, responseEntity.getBody());
    }
}

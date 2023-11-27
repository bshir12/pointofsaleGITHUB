package com.pointofsale.Testing;

import com.pointofsale.controller.KaryawanController;
import com.pointofsale.dto.karyawan.KaryawanRequest;
import com.pointofsale.dto.karyawan.KaryawanRespone;
import com.pointofsale.service.KaryawanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class KaryawanControllerTest {

    @InjectMocks
    KaryawanController karyawanController;

    @Mock
    KaryawanService karyawanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisKaryawan(){
        KaryawanRequest request = new KaryawanRequest("1234", "adw", "adyt", "jkt", "12-05-2003", "qead");
        KaryawanRespone respone = new KaryawanRespone(1, "1234", "adw", "adyt", "jkt", "12-05-2003", "gead");
        when(karyawanService.saveKaryawan(request)).thenReturn(respone);

        ResponseEntity<KaryawanRespone> responseEntity = karyawanController.saveKaryawan(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(respone, responseEntity.getBody());
    }
}

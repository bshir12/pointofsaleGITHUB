package com.pointofsale.Testing;

import com.pointofsale.dto.pembeli.PembeliRequest;
import com.pointofsale.dto.pembeli.PembeliRespone;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.service.PembeliService;
import com.pointofsale.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PembeliServiceTest {

    @InjectMocks
    PembeliService pembeliService;

    @Mock
    private PembeliRepository pembeliRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePembeli(){
        PembeliRequest request =  new PembeliRequest("12345", "testing", "adyt", "jkt", "awee", "gta");

        when(pembeliRepository.save(any(Pembeli.class))).thenAnswer(invocation -> {
            Pembeli savePembeli = invocation.getArgument(0);
            savePembeli.setId(1);
            return savePembeli;
        });

        PembeliRespone respone = pembeliService.savePembeli(request);

        assertNotNull(respone.getId());
        assertEquals(request.getNoTelepon(), respone.getNoTelepon());
        assertEquals(request.getEmail(), respone.getEmail());
        assertEquals(request.getNama(), respone.getNama());
        assertEquals(request.getAlamat(), respone.getAlamat());
        assertEquals(request.getTanggalLahir(), respone.getTanggalLahir());
        assertEquals(request.getJenisKelamin(), respone.getJenisKelamin());
    }
}

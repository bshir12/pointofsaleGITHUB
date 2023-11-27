package com.pointofsale.Testing.pembeli;

import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.service.PembeliService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class PembeliServiceTest {

    @InjectMocks
    private PembeliService pembeliService;

    @Mock
    private PembeliRepository pembeliRepository;

    @BeforeEach
    public void SetUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePembeli(){
        Pembeli pembeli = new Pembeli();

        pembeli.setNoTelepon("085156162351");
        pembeli.setEmail("marsyal071@gmail.com");
        pembeli.setNama("Muhammad Arsyal Kyvariwijya");
        pembeli.setAlamat("Bekasi");
        pembeli.setTanggalLahir("8 Agustus 2000");
        pembeli.setJenisKelamin("Laki-laki");

        when(pembeliRepository.save(pembeli)).thenReturn(new Pembeli());

        assertNotNull(pembeli);
    }

}

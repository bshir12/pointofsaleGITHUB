package com.pointofsale.Testing;

import com.pointofsale.dto.login.LoginPembeliRequest;
import com.pointofsale.dto.login.LoginRespone;
import com.pointofsale.entitiy.Pembeli;
import com.pointofsale.repository.LoginRepository;
import com.pointofsale.repository.PembeliRepository;
import com.pointofsale.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService;

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private PembeliRepository pembeliRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginPembeli() throws Exception{
        LoginPembeliRequest request = new LoginPembeliRequest();
        request.setPembeliId(6);
        request.setEmail("asfafa");
        request.setNoTelepon("444444");

        Pembeli mockPembeli = new Pembeli();
        mockPembeli.setId(6);
        mockPembeli.setEmail("asfafa");
        mockPembeli.setNoTelepon("444444");
        mockPembeli.setNama("fdhhdffhd");
        mockPembeli.setAlamat("asdfhdfhda");
        mockPembeli.setJenisKelamin("dfhdh");
        mockPembeli.setTanggalLahir("dfhdh");

        when(pembeliRepository.findWithUserDataByEmailAndNoTelepon(request.getEmail(), request.getNoTelepon()))
                .thenReturn(Optional.of(mockPembeli));

        LoginRespone respone = loginService.loginPembeli(request);

        assertNotNull(respone);
        assertNotNull(respone.getToken());

    }

    @Test
    void testLoginPembeliNotFound () throws Exception{
        LoginPembeliRequest request = new LoginPembeliRequest();
        request.setPembeliId(6);
        request.setEmail("adddddddd");
        request.setNoTelepon("444444");

        when(pembeliRepository.findWithUserDataByEmailAndNoTelepon(request.getEmail(), request.getNoTelepon()))
                .thenReturn(Optional.empty());

        LoginRespone respone = loginService.loginPembeli(request);
        assertNull(respone);

    }

}

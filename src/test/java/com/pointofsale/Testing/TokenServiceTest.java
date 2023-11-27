package com.pointofsale.Testing;

import com.pointofsale.entitiy.Login;
import com.pointofsale.repository.LoginRepository;
import com.pointofsale.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TokenServiceTest {

    @InjectMocks
    TokenService tokenService;

    @Mock
    LoginRepository loginRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void cekToken(){
        String token = "ada";

        Login log = new Login();
        log.setToken("ada");
        when(loginRepository.findByToken(token)).thenReturn(Optional.of(log));

        assertEquals(token, log.getToken());
    }
}

package com.pointofsale.Testing;

import com.pointofsale.controller.LoginController;
import com.pointofsale.dto.login.LoginPembeliRequest;
import com.pointofsale.dto.login.LoginRespone;
import com.pointofsale.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    @BeforeEach
    void setUp() {MockitoAnnotations.initMocks(this);}


    @Test
    void testLoginPembeli () throws Exception{
        LoginPembeliRequest request = new LoginPembeliRequest();
        request.setPembeliId(6);
        request.setEmail("asfafa");
        request.setNoTelepon("444444");

        LoginRespone mockResponse = new LoginRespone("test_token");
        //silahkan cek classnya, ad anotasi yang ku tambhin. googling tuk cari tau gunanya

        when(loginService.loginPembeli(request)).thenReturn(mockResponse);

        ResponseEntity<LoginRespone> response = loginController.login(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockResponse.getToken(), response.getBody().getToken());
        assertNotNull(response.getBody());

    }


}

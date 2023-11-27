package com.pointofsale.repository;

import com.pointofsale.PointofsaleApplication;
import com.pointofsale.entitiy.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PointofsaleApplication.class)
public class LoginRepositoryTest {

    @Mock
    private LoginRepository loginRepository;


    @Test
    public void findByToken_ReturnsLogin() {
        String sampleToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdW";
        Login expectedLogin = new Login();
        expectedLogin.setId(1);
        expectedLogin.setToken(sampleToken);
        when(loginRepository.findByToken(sampleToken)).thenReturn(Optional.of(expectedLogin));
        Optional<Login> result = loginRepository.findByToken(sampleToken);
        assertEquals(expectedLogin, result.orElse(null));
    }

    @Test
    public void findByToken_ReturnsEmptyOptional() {
        String nonExistentToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdW";
        when(loginRepository.findByToken(nonExistentToken)).thenReturn(Optional.empty());
        Optional<Login> result = loginRepository.findByToken(nonExistentToken);
        assertEquals(Optional.empty(), result);
    }



}

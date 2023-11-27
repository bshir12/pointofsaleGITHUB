package com.pointofsale.repository;

import com.pointofsale.PointofsaleApplication;
import com.pointofsale.entitiy.Pembeli;
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
public class PembeliRepositoryTest {
    @Mock
    private PembeliRepository pembeliRepository;


    @Test
    public void findWithUserDataByEmailAndNoTelepon_ReturnsPembeli() {
        String sampleEmail = "alifvir@gmail.com";
        String sampleNoTelepon = "081223844841";

        Pembeli expectedPembeli = new Pembeli();
        expectedPembeli.setId(1);
        expectedPembeli.setEmail(sampleEmail);
        expectedPembeli.setNoTelepon(sampleNoTelepon);

        when(pembeliRepository.findWithUserDataByEmailAndNoTelepon(sampleEmail, sampleNoTelepon))
                .thenReturn(Optional.of(expectedPembeli));

        Optional<Pembeli> result = pembeliRepository.findWithUserDataByEmailAndNoTelepon(sampleEmail, sampleNoTelepon);

        assertEquals(expectedPembeli, result.orElse(null));
    }

    @Test
    public void findWithUserDataByEmailAndNoTelepon_ReturnsEmptyOptional() {
        String nonExistentEmail = "alifvir@gmail.com";
        String nonExistentNoTelepon = "081223844841";

        when(pembeliRepository.findWithUserDataByEmailAndNoTelepon(nonExistentEmail, nonExistentNoTelepon))
                .thenReturn(Optional.empty());

        Optional<Pembeli> result = pembeliRepository.findWithUserDataByEmailAndNoTelepon(
                nonExistentEmail, nonExistentNoTelepon);

        assertEquals(Optional.empty(), result);
    }

}

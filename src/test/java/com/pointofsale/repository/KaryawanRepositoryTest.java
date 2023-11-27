package com.pointofsale.repository;

import com.pointofsale.PointofsaleApplication;
import com.pointofsale.entitiy.Karyawan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PointofsaleApplication.class)
public class KaryawanRepositoryTest {

    @Mock
    private KaryawanRepository karyawanRepository;


    @Test
    public void findWithUserDataByEmailAndNik_ReturnsKaryawan() {
        String sampleEmail = "alifvir@gmail.com";
        String sampleNik = "A1234";
        Karyawan expectedKaryawan = new Karyawan();
        expectedKaryawan.setId(1);
        expectedKaryawan.setEmail(sampleEmail);
        expectedKaryawan.setNik(sampleNik);
        when(karyawanRepository.findWithUserDataByEmailAndNik(sampleEmail, sampleNik))
                .thenReturn(Optional.of(expectedKaryawan));
        Optional<Karyawan> result = karyawanRepository.findWithUserDataByEmailAndNik(sampleEmail, sampleNik);
        assertEquals(expectedKaryawan, result.orElse(null));
    }

    @Test
    public void findWithUserDataByEmailAndNik_ReturnsEmptyOptional() {
        String nonExistentEmail = "alifvir@gmail.com";
        String nonExistentNik = "B5678";
        when(karyawanRepository.findWithUserDataByEmailAndNik(nonExistentEmail, nonExistentNik))
                .thenReturn(Optional.empty());
        Optional<Karyawan> result = karyawanRepository.findWithUserDataByEmailAndNik(
                nonExistentEmail, nonExistentNik);
        assertEquals(Optional.empty(), result);
    }

}

package com.pointofsale.repository;

import com.pointofsale.PointofsaleApplication;
import com.pointofsale.dto.transaksi.InfoTransaksi;
import com.pointofsale.entitiy.Transaksi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PointofsaleApplication.class)
public class TransaksiRepositoryTest {

    @Mock
    private TransaksiRepository transaksiRepository;

    @Test
    public void findDetailTransaksi_ReturnsListInfoTransaksi() {
        Integer samplePembeliId = 1;

        Transaksi transaksi1 = new Transaksi();
        transaksi1.setId(1);
        transaksi1.setJumlahBeli(3);
        transaksi1.setTotalBayar(150000.0);
        transaksi1.setTanggalTransaksi(new Date());

        Transaksi transaksi2 = new Transaksi();
        transaksi2.setId(2);
        transaksi2.setJumlahBeli(2);
        transaksi2.setTotalBayar(100000.0);
        transaksi2.setTanggalTransaksi(new Date());

        InfoTransaksi infoTransaksi1 = new InfoTransaksi(1, "ABC001", "Barang1", 3, 150000.0, new Date());
        InfoTransaksi infoTransaksi2 = new InfoTransaksi(2, "DEF002", "Barang2", 2, 100000.0, new Date());

        when(transaksiRepository.findDetailTransaksi(samplePembeliId)).thenReturn(Arrays.asList(infoTransaksi1, infoTransaksi2));


        List<InfoTransaksi> result = transaksiRepository.findDetailTransaksi(samplePembeliId);
        assertEquals(2, result.size());
        assertEquals(infoTransaksi1, result.get(0));
        assertEquals(infoTransaksi2, result.get(1));
    }

    @Test
    public void findDetailTransaksi_ReturnsEmptyList() {
        Integer nonExistentPembeliId = 99;
        when(transaksiRepository.findDetailTransaksi(nonExistentPembeliId)).thenReturn(Arrays.asList());
        List<InfoTransaksi> result = transaksiRepository.findDetailTransaksi(nonExistentPembeliId);
        assertEquals(0, result.size());
    }

}

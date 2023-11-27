package com.pointofsale.repository;

import com.pointofsale.PointofsaleApplication;
import com.pointofsale.entitiy.Barang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PointofsaleApplication.class)
public class BarangRepositoryTest {


    @Autowired
    private BarangRepository barangRepository;

    private Barang barang = new Barang();


    @Test
    public void testSavePositiveCase(){
        barang.setId(1);
        barangRepository.save(barang);
        Barang b = barangRepository.findById(barang.getId()).get();
        assertEquals(barang.getId(),b.getId());

    }

    @Test
    public void testSaveNegativeCase(){
        barang.setId(1);
        barangRepository.save(barang);
        Barang b = barangRepository.findById(barang.getId()).get();
        assertEquals(barang.getId(),b.getId());
    }


    public Barang generateBarang(Integer stockBarang,String kodeBarang,String namaBarang,Integer hargaBarang,String detailBarang) {
        barang.setStockBarang(stockBarang);
        barang.setKodeBarang(kodeBarang);
        barang.setNamaBarang(namaBarang);
        barang.setHargaBarang(hargaBarang);
        barang.setDetailBarang(detailBarang );
        return barang;

    }


    @Test
    public void saveBarang() {
        Barang barang = generateBarang(99, "GLS99","GELASKEREN",99000,"Gelas Mudah Pecah");
        Barang saved = barangRepository.save(barang);
        Optional<Barang> barangOptional = barangRepository.findById(saved.getId());
        assertTrue(barangOptional.isPresent());
        assertEquals(99, barangOptional.get().getStockBarang());
        assertEquals("GLS99", barangOptional.get().getKodeBarang());
        assertEquals("GELASKEREN", barangOptional.get().getNamaBarang());
        assertEquals(99000, barangOptional.get().getHargaBarang());
        assertEquals("Gelas Mudah Pecah", barangOptional.get().getDetailBarang());
    }


    @Test
    public void updateBarang() {
        Barang barang = generateBarang(99, "GLS99","GELASKEREN",99000,"Gelas Mudah Pecah");
        Barang saved = barangRepository.save(barang);
        barang.setStockBarang(2);
        barang.setKodeBarang("PRNG01");
        barang.setNamaBarang("Piring");
        barang.setHargaBarang(25000);
        barang.setDetailBarang("piring mudah pecah" );
        barangRepository.save(barang);
        Optional<Barang> barangOptional = barangRepository.findById(saved.getId());
        assertTrue(barangOptional.isPresent());
        assertEquals(2, barangOptional.get().getStockBarang());
        assertEquals("PRNG01", barangOptional.get().getKodeBarang());
        assertEquals("Piring", barangOptional.get().getNamaBarang());
        assertEquals(25000, barangOptional.get().getHargaBarang());
        assertEquals("piring mudah pecah", barangOptional.get().getDetailBarang());
    }

    @Test
    public void deleteBarang() {
        Barang barang = generateBarang(999, "GLS999","GELASKEREN9",9999,"Gelas Mudah Pecah");
        Barang saved = barangRepository.save(barang);
        barangRepository.delete(saved);

        Optional<Barang> barangOptional = barangRepository.findById(saved.getId());
        assertFalse(barangOptional.isPresent());
    }



}


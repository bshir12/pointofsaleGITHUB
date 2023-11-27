package com.pointofsale.repository;

import com.pointofsale.dto.transaksi.InfoTransaksi;
import com.pointofsale.entitiy.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi,Integer> {

    @Query("SELECT new com.pointofsale.dto.transaksi.InfoTransaksi(t.id, b.kodeBarang, b.namaBarang, t.jumlahBeli, t.totalBayar, t.tanggalTransaksi) FROM Transaksi t JOIN t.barang b JOIN t.pembeli p WHERE p.id=:id")
    List<InfoTransaksi> findDetailTransaksi(@Param("id") Integer id);

}

package com.pointofsale.repository;

import com.pointofsale.entitiy.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang,Integer> {
}

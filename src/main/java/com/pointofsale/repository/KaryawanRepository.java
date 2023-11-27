package com.pointofsale.repository;

import com.pointofsale.entitiy.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan,Integer> {

    @Query("SELECT k FROM Karyawan k WHERE k.nik=:nik AND k.email=:email")
    Optional<Karyawan> findWithUserDataByEmailAndNik(String email, String nik);

}

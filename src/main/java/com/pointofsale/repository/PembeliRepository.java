package com.pointofsale.repository;

import com.pointofsale.entitiy.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PembeliRepository extends JpaRepository<Pembeli,Integer> {

    @Query("SELECT p FROM Pembeli p WHERE p.noTelepon=:noTelepon AND p.email=:email")
    Optional<Pembeli> findWithUserDataByEmailAndNoTelepon(String email, String noTelepon);

}

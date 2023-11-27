package com.pointofsale.repository;

import com.pointofsale.entitiy.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

    Optional<Login> findByToken(String token);

}

package com.pointofsale.service;

import com.pointofsale.entitiy.Login;
import com.pointofsale.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class TokenService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean getToken(String token) {
        Optional<Login> getToken = loginRepository.findByToken(token);
        return getToken.isPresent();
    }

}

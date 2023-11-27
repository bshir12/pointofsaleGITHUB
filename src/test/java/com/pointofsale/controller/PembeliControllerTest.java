package com.pointofsale.controller;

import com.pointofsale.service.PembeliService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PembeliControllerTest {
    @InjectMocks
    private PembeliController pembeliController;
    @Mock
    private PembeliService pembeliService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllPembeli() {
    }

    @Test
    void savePembeli() {
    }

    @Test
    void updatePembeliById() {
    }

    @Test
    void deletePembeliById() {
    }
}
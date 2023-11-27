package com.pointofsale.controller;

import com.pointofsale.entitiy.Barang;
import com.pointofsale.service.BarangService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class BarangControllerTest {

    @InjectMocks
    private BarangController barangController;

    @Mock
    private BarangService barangService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
}

package com.grupocastores.bitacora.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupocastores.bitacora.repository.BitacoraRepository;
import com.grupocastores.bitacora.repository.UtilitiesRepository;

@Service
public class BitacoraServiceImpl implements IBitacoraService{
    
    @Autowired
    private BitacoraRepository bitacoraRepository;
    
    @Autowired
    private UtilitiesRepository utilitiesRepository;
    
    
    public static final String DBPRUEBA = "TIJUANAPRUEBA";

   

   
    
   
    
    
}

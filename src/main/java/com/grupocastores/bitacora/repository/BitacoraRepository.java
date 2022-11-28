package com.grupocastores.bitacora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class BitacoraRepository extends UtilitiesRepository{
    
    
    @PersistenceContext
    private EntityManager entityManager;
   

   
   
}

package com.colheita.pa.repositories;

import com.colheita.pa.entities.Familia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository <Familia,Long>{
    
}

package com.colheita.pa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.colheita.pa.dto.especieDTO.InsertEspecie;

import javax.persistence.JoinColumn;

@Entity
public class Especie implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera PK automaticamente
    private long id;

    private String nameEspecie;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Especie_Muda",
                joinColumns={@JoinColumn(name="MUDA_ID")},
                inverseJoinColumns={@JoinColumn(name="Especie_ID")})
    private List<Muda> mudas;
    

    public Especie(long id, String nameEspecie, List<Muda> mudas) {
        this.id = id;
        this.nameEspecie = nameEspecie;
        this.mudas = mudas;
    }

    public Especie() {
    }

    public Especie(InsertEspecie insertDTO) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameEspecie() {
        return nameEspecie;
    }

    public void setNameEspecie(String nameEspecie) {
        this.nameEspecie = nameEspecie;
    }

    public List<Muda> getMudas() {
        return mudas;
    }

    public void setMudas(List<Muda> mudas) {
        this.mudas = mudas;
    }

}

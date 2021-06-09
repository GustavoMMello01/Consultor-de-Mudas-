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

import javax.persistence.JoinColumn;

import com.colheita.pa.dto.biomaDTO.InsertBiomaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Bioma implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera PK automaticamente
    private long id;

    private String nomeBioma;

    	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name="Muda_Bioma",
	             joinColumns={@JoinColumn(name="MUDA_ID")},
	             inverseJoinColumns={@JoinColumn(name="BIOMA_ID")})
	 //@JsonBackReference
	 private List<Muda> mudas;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNomeBioma() {
        return nomeBioma;
    }


    public void setNomeBioma(String nomeBioma) {
        this.nomeBioma = nomeBioma;
    }


    // public List<Muda> getMudas() {
    //     return mudas;
    // }


    // public void setMudas(List<Muda> mudas) {
    //     this.mudas = mudas;
    // }


    public Bioma(long id, String nomeBioma) {
        this.id = id;
        this.nomeBioma = nomeBioma;
        // this.mudas = mudas;
    }


    public Bioma() {
    }

    public Bioma(InsertBiomaDTO insertDTO) {
        this.nomeBioma = insertDTO.getNomeBioma();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        // result = prime * result + ((mudas == null) ? 0 : mudas.hashCode());
        result = prime * result + ((nomeBioma == null) ? 0 : nomeBioma.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bioma other = (Bioma) obj;
        if (id != other.id)
            return false;
        // if (mudas == null) {
        //     if (other.mudas != null)
        //         return false;
        // } else if (!mudas.equals(other.mudas))
        //     return false;
        if (nomeBioma == null) {
            if (other.nomeBioma != null)
                return false;
        } else if (!nomeBioma.equals(other.nomeBioma))
            return false;
        return true;
    }

     


}

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
import javax.persistence.OneToMany;

import com.colheita.pa.dto.familiaDTO.InsertFamiliaDTO;

import javax.persistence.JoinColumn;

@Entity
public class Familia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameFamilia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Especie_Familia",
                joinColumns={@JoinColumn(name="ESPECIE_ID")},
                inverseJoinColumns={@JoinColumn(name="FAMILIA_ID")})
    private List<Especie> especies;

    public Familia(long id, String nameFamilia) {
        this.id = id;
        this.nameFamilia = nameFamilia;
    }

    public Familia(){

    }

    
    
    public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public Familia(InsertFamiliaDTO insertDTO){
        this.nameFamilia = insertDTO.getNameFamilia();
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameFamilia() {
        return nameFamilia;
    }

    public void setNameFamilia(String nameFamilia) {
        this.nameFamilia = nameFamilia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        // result = prime * result + ((mudas == null) ? 0 : mudas.hashCode());
        result = prime * result + ((nameFamilia == null) ? 0 : nameFamilia.hashCode());
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
        Familia other = (Familia) obj;
        if (id != other.id)
            return false;
        // if (mudas == null) {
        //     if (other.mudas != null)
        //         return false;
        // } else if (!mudas.equals(other.mudas))
        //     return false;
        if (nameFamilia == null) {
            if (other.nameFamilia != null)
                return false;
        } else if (!nameFamilia.equals(other.nameFamilia))
            return false;
        return true;
    }    

    // public List<Muda> getMudas() {
    //     return mudas;
    // }

    // public void setMudas(List<Muda> mudas) {
    //     this.mudas = mudas;
    // }   
    
    
}

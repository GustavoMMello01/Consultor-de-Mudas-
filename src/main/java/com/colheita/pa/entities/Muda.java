package com.colheita.pa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.colheita.pa.dto.mudaDTO.InsertMudaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@Table(name="TB_Muda")
public class Muda implements Serializable {
    
    private static final long serialVersionUID = 1L; // ver depois essa linha com o serializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera PK automaticamente
    private long id;

    private boolean frutifera;
    private String nomeMuda;

    //mapeamento de entidades/tabelas
    @ManyToMany(mappedBy="mudas", cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<Regiao> regioes = new ArrayList<>();

    @ManyToMany(mappedBy="mudas", cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<Bioma> biomas = new ArrayList<>();

    @ManyToMany(mappedBy="mudas", cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<Solo> solos = new ArrayList<>();
    
    @ManyToOne
    private Especie especie;

    

    public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public List<Solo> getSolos() {
		return solos;
	}

	public void setSolos(List<Solo> solos) {
		this.solos = solos;
	}

	public Muda() {
    	super();
    }

    public Muda(InsertMudaDTO insertDTO) {
        this.frutifera = insertDTO.isFrutifera();
        this.nomeMuda = insertDTO.getNomeMuda();
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    public List<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Muda other = (Muda) obj;
        if (id != other.id)
            return false;
        return true;
    }

	public boolean isFrutifera() {
		return frutifera;
	}

	public void setFrutifera(boolean frutifera) {
		this.frutifera = frutifera;
	}

    public String getNomeMuda() {
        return nomeMuda;
    }

    public void setNomeMuda(String nomeMuda) {
        this.nomeMuda = nomeMuda;
    }

    public List<Bioma> getBiomas() {
        return biomas;
    }

    public void setBiomas(List<Bioma> biomas) {
        this.biomas = biomas;
    }

    



}

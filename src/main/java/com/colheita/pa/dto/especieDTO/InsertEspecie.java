package com.colheita.pa.dto.especieDTO;

import java.util.List;

import com.colheita.pa.entities.Muda;

public class InsertEspecie {
    
    private long id;
    private String nameEspecie;
    private List<Muda> mudas;
    private long idFamilia;
    
    public InsertEspecie() {
    }

    
    public InsertEspecie(long id, String nameEspecie, List<Muda> mudas) {
        this.id = id;
        this.nameEspecie = nameEspecie;
        this.mudas = mudas;
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


	public long getIdFamilia() {
		return idFamilia;
	}


	public void setIdFamilia(long idFamilia) {
		this.idFamilia = idFamilia;
	}
    

}

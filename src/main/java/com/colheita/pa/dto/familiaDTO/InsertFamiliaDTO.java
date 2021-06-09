package com.colheita.pa.dto.familiaDTO;

import java.util.List;

import com.colheita.pa.entities.Muda;

public class InsertFamiliaDTO {
    
    private long id;
    private String nameFamilia;
    // private List<Muda> mudas;

    public InsertFamiliaDTO(long id, String nameFamilia) {
        this.id = id;
        this.nameFamilia = nameFamilia;
        // this.mudas = mudas;
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

    // public List<Muda> getMudas() {
    //     return mudas;
    // }

    // public void setMudas(List<Muda> mudas) {
    //     this.mudas = mudas;
    // }

    
}

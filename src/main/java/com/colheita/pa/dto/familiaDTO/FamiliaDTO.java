package com.colheita.pa.dto.familiaDTO;

import java.util.List;

import com.colheita.pa.entities.Familia;
import com.colheita.pa.entities.Muda;

public class FamiliaDTO {
    
    private long id;
    private String nameFamilia;
    // private List<Muda> mudas;

    public FamiliaDTO(){

    }

    public FamiliaDTO(long id, String nameFamilia) {
        this.id = id;
        this.nameFamilia = nameFamilia;
        // this.mudas = mudas;
    }

    public FamiliaDTO(Familia familia){
        this.id = familia.getId();
        this.nameFamilia = familia.getNameFamilia();
        // this.mudas = familia.getMudas();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnameFamilia() {
        return nameFamilia;
    }

    public void setnameFamilia(String nameFamilia) {
        this.nameFamilia = nameFamilia;
    }

    // public List<Muda> getMudas() {
    //     return mudas;
    // }

    // public void setMudas(List<Muda> mudas) {
    //     this.mudas = mudas;
    // }  
}

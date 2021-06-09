package com.colheita.pa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.colheita.pa.dto.especieDTO.InsertEspecie;
import com.colheita.pa.dto.especieDTO.EspecieDTO;
import com.colheita.pa.entities.Especie;
import com.colheita.pa.entities.Familia;
import com.colheita.pa.repositories.EspecieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EspecieService {
    
    @Autowired
    private EspecieRepository repo;

    public List<EspecieDTO> getEspecie(){
        
        List<Especie> especieList = repo.findAll();

        return toDTOList(especieList);

    }

    public EspecieDTO getEspecieByID(long id){

        Optional <Especie> op = repo.findById(id);
        Especie especie = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especie not found"));
        
        return new EspecieDTO(especie);

    }    

    public EspecieDTO insert(InsertEspecie insertDTO, Familia familia) {
		
        Especie entity = new Especie(insertDTO);
        entity.setFamilia(familia);
        entity = repo.save(entity);

        return new EspecieDTO(entity);
	}

    public void delete(Long id){

        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especie not found");
        }
    }


    private List<EspecieDTO> toDTOList(List<Especie> especieList) {
        return especieList.stream().map(EspecieDTO::new).collect(Collectors.toList());
    }

}

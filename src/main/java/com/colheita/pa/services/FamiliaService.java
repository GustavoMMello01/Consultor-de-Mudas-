package com.colheita.pa.services;

import com.colheita.pa.dto.familiaDTO.FamiliaDTO;
import com.colheita.pa.dto.familiaDTO.InsertFamiliaDTO;
import com.colheita.pa.repositories.FamiliaRepository;
import java.util.List;
import com.colheita.pa.entities.Familia;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FamiliaService {
    
    @Autowired
    private FamiliaRepository repo;

    public List<FamiliaDTO> getFamilia(){
        
        List<Familia> familiaList = repo.findAll();

        return toDTOList(familiaList);

    }

    public FamiliaDTO getFamiliaById(long id){
        Optional<Familia> op = repo.findById(id);
        Familia familia = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Familia not found"));

        return new FamiliaDTO(familia);
    }

    public FamiliaDTO insert(InsertFamiliaDTO insertDTO) {

        Familia entity = new Familia(insertDTO);
        entity = repo.save(entity);

        return new FamiliaDTO(entity);
    }
    
    public void delete(Long id){

        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Familia not found");
        }
    }

    private List<FamiliaDTO> toDTOList(List<Familia> familiaList) {
        return familiaList.stream().map(FamiliaDTO::new).collect(Collectors.toList());
    }
}

package com.colheita.pa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.colheita.pa.dto.mudaDTO.InsertMudaDTO;
import com.colheita.pa.dto.mudaDTO.MudaDTO;
import com.colheita.pa.dto.mudaDTO.UpdateMudaDTO;
import com.colheita.pa.entities.Bioma;
import com.colheita.pa.entities.Especie;
import com.colheita.pa.entities.Familia;
import com.colheita.pa.entities.Muda;
import com.colheita.pa.entities.Regiao;
import com.colheita.pa.entities.Solo;
import com.colheita.pa.repositories.BiomaRepository;
import com.colheita.pa.repositories.EspecieRepository;
import com.colheita.pa.repositories.MudaRepository;
import com.colheita.pa.repositories.RegiaoRepository;
import com.colheita.pa.repositories.SoloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MudaService {
    
    @Autowired
    private MudaRepository repo;
    @Autowired
    private BiomaRepository biomaRepo;
    @Autowired
    private EspecieRepository especieRepo;
    @Autowired
    private RegiaoRepository regiaoRepo;
    @Autowired
    private SoloRepository soloRepo;

    // devolve todas as mudas
    public List<MudaDTO> getMudas(){

        List<Muda> mudaList = repo.findAll();

        return toDTOList(mudaList);
       
    }

    // recupera muda pelo ID
    public MudaDTO getMudaByID(long id){
        
        Optional <Muda> op = repo.findById(id);
        Muda muda = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));
        
        return new MudaDTO(muda);

    }

    public MudaDTO insert(InsertMudaDTO insertDTO){
    	
    	long idBioma = insertDTO.getIdbioma();
    	long idEspecie = insertDTO.getIdEspecie();
    	long idRegiao = insertDTO.getIdRegiao();
    	long idSolo = insertDTO.getIdSolo();
    	
    	Bioma bioma = biomaRepo.findById(idBioma).get();
    	Especie especie = especieRepo.findById(idEspecie).get();
    	Regiao regiao = regiaoRepo.findById(idRegiao).get();
    	Solo solo = soloRepo.findById(idSolo).get();
        
        Muda entity = new Muda(insertDTO);
        entity.getBiomas().add(bioma);
        entity.getRegioes().add(regiao);
        entity.getSolos().add(solo);
        entity.setEspecie(especie);
        entity = repo.save(entity);

        return new MudaDTO(entity);

    }

    public void delete(Long id){
       
        try{
           repo.deleteById(id);
       }
       catch (EmptyResultDataAccessException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Muda not found");
       }

    }

    // public MudaDTO update(Long id, UpdateMudaDTO updateDTO){
        
    //     Muda entity = repo.getOne(id);
    //     try{
        	
    //     	entity.setRegioes(updateDTO.getRegioes());     
    //        entity.setFrutifera(updateDTO.isFrutifera());
    //        entity.setBiomas(updateDTO.getBioma());
    //        entity.setSolo(updateDTO.getSolo());
    //        entity.setRegiao(updateDTO.getRegiao());
    //        entity.setEspecie(updateDTO.getEspecie());
    //        entity = repo.save(entity);
    //     }
    //     catch(EntityNotFoundException e) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
    //     }

    //     return new MudaDTO(entity);

    // }
    


    // metodo que tramsforma Muda em MudaDTO
    private List<MudaDTO> toDTOList(List<Muda> list){
        return list.stream().map(MudaDTO::new).collect(Collectors.toList());
    }

}

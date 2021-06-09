package com.colheita.pa.controllers;

import java.net.URI;
import java.util.List;

import com.colheita.pa.dto.familiaDTO.FamiliaDTO;
import com.colheita.pa.dto.familiaDTO.InsertFamiliaDTO;
import com.colheita.pa.services.FamiliaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/familias")
@CrossOrigin
public class FamiliaController {
    
    @Autowired
    private FamiliaService service;

    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> getFamilias(){
        
        List <FamiliaDTO> familiaList = service.getFamilia();

        return ResponseEntity.ok().body(familiaList);
    }

    @GetMapping("{id}")         
    public ResponseEntity<FamiliaDTO> getFamiliaById(@PathVariable Long id){

        FamiliaDTO dto = service.getFamiliaById(id);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping            
    public ResponseEntity<FamiliaDTO> insert(@RequestBody InsertFamiliaDTO insertDTO){
        
        FamiliaDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();

    }
}

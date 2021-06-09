package com.colheita.pa.controllers;


import java.net.URI;
import java.util.List;

import com.colheita.pa.dto.mudaDTO.InsertMudaDTO;
import com.colheita.pa.dto.mudaDTO.MudaDTO;
import com.colheita.pa.dto.mudaDTO.UpdateMudaDTO;
import com.colheita.pa.services.MudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// regras de negocio da aplicação

@RestController
@RequestMapping("/mudas") // rota para o front end
@CrossOrigin
public class MudaController {
    
    @Autowired // evita nullException no MudaService
    private MudaService service;

    @GetMapping         //WORKING
    public ResponseEntity<List<MudaDTO>> getMudas(){
        
        List <MudaDTO> mudaList = service.getMudas();

        return ResponseEntity.ok().body(mudaList);
    }

    @GetMapping("{id}")         //WORKING
    public ResponseEntity<MudaDTO> getMudaByID(@PathVariable Long id){

        MudaDTO dto = service.getMudaByID(id);

        return ResponseEntity.ok().body(dto);

    }

    @PostMapping            //WORKING
    public ResponseEntity<MudaDTO> insert(@RequestBody InsertMudaDTO insertDTO){
        
        MudaDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }

    @DeleteMapping("{id}")      //WORKING
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

    // @PutMapping("{id}")
    // public ResponseEntity<MudaDTO> update(@RequestBody UpdateMudaDTO updateDto, @PathVariable Long id){
        
    //     MudaDTO dto = service.update(id, updateDto);
    //     return ResponseEntity.ok().body(dto);
    
    // }


}

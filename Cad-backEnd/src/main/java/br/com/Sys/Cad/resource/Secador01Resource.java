package br.com.Sys.Cad.resource;

import br.com.Sys.Cad.Entities.Secador01;
import br.com.Sys.Cad.dto.Secador01DTO;
import br.com.Sys.Cad.services.Secador01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/secador01")
public class Secador01Resource {

    @Autowired
    private Secador01Service service;

    @GetMapping(value = "buscaTodos")
    public ResponseEntity <List<Secador01DTO>> findAll(){
        List<Secador01DTO> list = service.findAll();
        //String data  = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss").format(new Date());
        // list.add(new Secador01(1L, "12", "10", data));

        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "buscarId/{id}")
    public ResponseEntity <List<Secador01DTO>> finById(@PathVariable Long id){
        List<Secador01DTO> list = service.findById(id);
        return  ResponseEntity.ok().body(list);
    }
    @PostMapping(value = "/salvar")
    public ResponseEntity<Secador01DTO>insert(@RequestBody Secador01DTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return  ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Secador01DTO>update(@PathVariable Long id, @RequestBody Secador01DTO dto){
        dto = service.update(id, dto);
        return  ResponseEntity.ok().body(dto);
    }


}

package br.com.Sys.Cad.resource;

import br.com.Sys.Cad.Entities.Secador01;
import br.com.Sys.Cad.dto.Secador01DTO;
import br.com.Sys.Cad.services.Secador01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/secador01")
public class Secador01Resource {

    @Autowired
    private Secador01Service service;

    @GetMapping
    public ResponseEntity <List<Secador01DTO>> findAll(){
        List<Secador01DTO> list = service.findAll();
        //String data  = new SimpleDateFormat("DD/MM/YYYY HH:mm:ss").format(new Date());
       // list.add(new Secador01(1L, "12", "10", data));

        return  ResponseEntity.ok().body(list);
    }
}

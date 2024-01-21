package br.com.Sys.Cad.services;

import br.com.Sys.Cad.Entities.Secador01;
import br.com.Sys.Cad.dto.Secador01DTO;
import br.com.Sys.Cad.repositories.Secador01Repository;
import br.com.Sys.Cad.services.exceptions.EntityNotFoundExceptionRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Secador01Service {

    @Autowired
    private Secador01Repository repository;
    @Transactional(readOnly = true)
    public List<Secador01DTO> findAll(){
        List<Secador01> list = repository.findAll();
        return list.stream().map(x -> new Secador01DTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Secador01DTO> findById(Long id){
        Optional<Secador01> obj = repository.findById(id);
        return obj.stream().map(x -> new Secador01DTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public Secador01DTO insert(Secador01DTO dto) {
        Secador01 entity = new Secador01();
        entity.setUmidade(dto.getUmidade());
        entity.setPerca(dto.getPerca());
        entity.setData(new SimpleDateFormat("DD/MM/YYYY HH:mm:ss").format(new Date()));
        entity=repository.save(entity);
        return new Secador01DTO(entity);

    }
}

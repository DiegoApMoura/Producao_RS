package br.com.Sys.Cad.services;

import br.com.Sys.Cad.Entities.Secador01;
import br.com.Sys.Cad.dto.Secador01DTO;
import br.com.Sys.Cad.repositories.Secador01Repository;
import br.com.Sys.Cad.services.exceptions.DataBaseNotFoundExceptionRS;
import br.com.Sys.Cad.services.exceptions.EntityNotFoundExceptionRS;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Secador01DTO findById(Long id){
        Optional<Secador01> obj = repository.findById(id);
        Secador01 entity = obj.orElseThrow(() -> new EntityNotFoundExceptionRS("Entidade não encontrada!"));
        return new Secador01DTO(entity);
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
    @Transactional
    public Secador01DTO update(Long id, Secador01DTO dto) {
        try {
            Secador01 entity = repository.getReferenceById(id);
            entity.setUmidade(dto.getUmidade());
            entity.setPerca(dto.getPerca());
            entity = repository.save(entity);
            return new Secador01DTO(entity);

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundExceptionRS("ID não encontrado!");
        }

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionRS("ID "+id+" não encontrado!");
        }catch (DataIntegrityViolationException e){
            throw new DataBaseNotFoundExceptionRS("Violação de integridade dos dados!");

        }
    }
}

package br.com.Sys.Cad.services;

import br.com.Sys.Cad.Entities.Secador01;
import br.com.Sys.Cad.repositories.Secador01Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Secador01Service {

    @Autowired
    private Secador01Repository repository;
    @Transactional(readOnly = true)
    public List<Secador01> findAll(){
        return repository.findAll();
    }
}

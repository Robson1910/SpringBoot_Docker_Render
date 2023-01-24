package io.github.robson.spring_boot_docker_render.services;

import io.github.robson.spring_boot_docker_render.entities.Teste;
import io.github.robson.spring_boot_docker_render.repositories.TesteRepository;
import io.github.robson.spring_boot_docker_render.services.exceptions.DatabaseException;
import io.github.robson.spring_boot_docker_render.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesteService {

    @Autowired
    private TesteRepository testeRepository;

    public List<Teste> findAll(){
        return testeRepository.findAll();
    }

    public Teste findById(Long id){
        Optional<Teste> obj = testeRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Teste insert(Teste obj){
        return testeRepository.save(obj);
    }

    public void delete(Long id){
        try {
            testeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Teste update(Long id, Teste obj){
        try {
            Teste entity = testeRepository.getReferenceById(id);
            updateData(entity,obj);
            return testeRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Teste entity, Teste obj) {
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
    }
}

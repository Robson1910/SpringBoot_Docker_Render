package io.github.robson.spring_boot_docker_render.controller;

import io.github.robson.spring_boot_docker_render.entities.Teste;
import io.github.robson.spring_boot_docker_render.services.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class TesteController {

    @Autowired
    private TesteService service;

    @GetMapping
    public ResponseEntity<List<Teste>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Teste> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Teste> insert(@RequestBody Teste obj){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Teste> update(@PathVariable Long id, @RequestBody Teste obj){
       return ResponseEntity.ok().body(service.update(id,obj));
    }
}

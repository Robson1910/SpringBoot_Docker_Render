package io.github.robson.spring_boot_docker_render.repositories;

import io.github.robson.spring_boot_docker_render.entities.Teste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesteRepository extends JpaRepository<Teste,Long> {
}

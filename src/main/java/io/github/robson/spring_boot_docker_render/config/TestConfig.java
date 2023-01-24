package io.github.robson.spring_boot_docker_render.config;

import io.github.robson.spring_boot_docker_render.entities.Teste;
import io.github.robson.spring_boot_docker_render.repositories.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
// Essa classe de config so e executado quando o apllication.properties esta no ambiente spring.profiles.active=test
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TesteRepository testeRepository;

    @Override
    public void run(String... args) throws Exception {

        Teste u1 = new Teste(null, "Maria Brown", "988888888", "maria@gmail.com");
        Teste u2 = new Teste(null, "Alex Green", "977777777", "alex@gmail.com");
        testeRepository.saveAll(Arrays.asList(u1,u2));
    }
}

package com.example.forumhub;

import com.example.forumhub.domain.usuario.Usuario;
import com.example.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class ForumHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumHubApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            Optional<Usuario> testUserOptional = repository.findByLogin("ana.silva@example.com");

            testUserOptional.ifPresent(repository::delete);

            Usuario testUser = new Usuario(null, "ana.silva@example.com", passwordEncoder.encode("123456"));
            repository.save(testUser);

            System.out.println(">>>>>>>>>> UTILIZADOR DE TESTE 'ana.silva@example.com' FOI CRIADO COM SUCESSO! <<<<<<<<<<");
        };
    }
}
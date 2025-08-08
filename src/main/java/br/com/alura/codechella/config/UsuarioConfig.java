package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositoryUsuarioService;
import br.com.alura.codechella.application.usecases.UsuarioServiceImpl;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositoryUsuarioJPA;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    UsuarioServiceImpl useService(RepositoryUsuarioService repositoryUsuarioService){
        return new UsuarioServiceImpl(repositoryUsuarioService);
    }

    @Bean
    RepositoryUsuarioJPA criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper){
        return new RepositoryUsuarioJPA(repositorio, mapper);
    }

    @Bean
    UsuarioEntityMapper retornMapper(){
        return new UsuarioEntityMapper();
    }
}

package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositoryUsuarioService;
import br.com.alura.codechella.application.usecases.UsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    UsuarioServiceImpl useService(RepositoryUsuarioService repositoryUsuarioService){
        return new UsuarioServiceImpl(repositoryUsuarioService);
    }
}

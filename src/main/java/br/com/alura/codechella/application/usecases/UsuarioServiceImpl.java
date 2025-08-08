package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositoryUsuarioService;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class UsuarioServiceImpl {

    private final RepositoryUsuarioService repository;

    public UsuarioServiceImpl(RepositoryUsuarioService repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.cadastrarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.listarTodos();
    }
}

package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositoryUsuarioService;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.entity.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositoryUsuarioJPA implements RepositoryUsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositoryUsuarioJPA(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}

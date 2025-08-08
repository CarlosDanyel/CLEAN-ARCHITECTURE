package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.UsuarioServiceImpl;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.dto.UsuarioDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioServiceImpl criarUsuario;

    public UsuarioController(UsuarioServiceImpl criarUsuario) {
        this.criarUsuario = criarUsuario;
    }

    @PostMapping("/create")
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
       Usuario save =  criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
       return new UsuarioDto(save.getCpf(), save.getNome(), save.getNascimento(), save.getEmail());
    }
}

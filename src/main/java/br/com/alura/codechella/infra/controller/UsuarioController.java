package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.UsuarioServiceImpl;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.dto.UsuarioDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioServiceImpl useService;

    public UsuarioController(UsuarioServiceImpl criarUsuario) {
        this.useService = criarUsuario;
    }

    @PostMapping("/create")
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
       Usuario save =  useService.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
       return new UsuarioDto(save.getCpf(), save.getNome(), save.getNascimento(), save.getEmail());
    }

    @GetMapping("/findAll")
    public List<UsuarioDto> listaUsuarios() {
        return useService.listarUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }
}

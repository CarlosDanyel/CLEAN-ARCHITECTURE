package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.123.123-12", "Carlos", LocalDate.parse("1990-09-09"), "carlosdanyel@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.123.123-12", "Robert", LocalDate.parse("1990-09-09"), "carlosdanyel@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.123.123-12", "Joao", LocalDate.parse("1990-09-09"), "carlosdanyel@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.123.123-12", "Gabriela", LocalDate.parse("1990-09-09"), "carlosdanyel@gmail.com"));

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
    }
}

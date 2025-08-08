package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("424343.355-77", "Carlos", LocalDate.parse("1999-09-08"), "carlosdanyel@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Carlos", LocalDate.parse("1999-09-08"), "carlosdanyel@gmail.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabriaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Carlos", "123.123.123-12", LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Carlos", usuario.getNome());
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Carlos", LocalDate.parse("1999-09-08"), "carlosdanyel@gmail.com"));

        usuario = fabrica.incluiEndereco("09912230", 40, "apto 102");

        Assertions.assertEquals("apto 102", usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {
        LocalDate dataNascimento = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });

        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }
}

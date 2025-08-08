package br.com.alura.codechella.domain.valueobject;

public class Endereco {
    private String cep;
    private  Integer numero;
    private  String complemento;

    public Endereco(String cep, Integer numero, String complemento) {
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}

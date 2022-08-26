package br.com.alura.model.domain;

import java.time.LocalDate;

public class Produto {

    private String nome;
    private Double preco;
    private LocalDate dataCadastro;

    public Produto() {
    }

    private Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    private String metodoPrivadoRetornaString(String palavra) {
        return " Método sem retorno e público da classe Produto , e recebeu por parametro uma palavra "+palavra ;
    }

    public void printInfo() {
        System.out.println(" Método sem retorno e público da classe Produto ");
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

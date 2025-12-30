package com.yehudi.backend.model;

public class Receita {
    String nome;
    String imagem;
    String categoria;
    String ingredientes;
    String preparo;

    public Receita(String nome, String imagem, String categoria, String ingredientes, String preparo) {
        this.nome = nome;
        this.imagem = imagem;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparo = preparo;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getImagem() {
        return imagem;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public String getNome() {
        return nome;
    }
    public String getPreparo() {
        return preparo;
    }
    
}

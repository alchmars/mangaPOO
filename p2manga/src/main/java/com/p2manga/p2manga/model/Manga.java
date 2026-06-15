package com.p2manga.p2manga.model;

import java.util.HashMap;

public class Manga {

    private int id;
    private String nomeManga, autor, descricao, urlCapa;
    private double nota;
    private EstadoManga estadoManga;

    public Manga() {
    }

    // Construtor sem id (para inserção)
    public Manga(String nomeManga, String autor, String descricao, double nota, EstadoManga estadoManga, String urlCapa) {
        this.nomeManga = nomeManga;
        this.autor = autor;
        this.descricao = descricao;
        this.nota = nota;
        this.estadoManga = estadoManga;
        this.urlCapa = urlCapa;
    }

    // Construtor com id (para listagem/edição)
    public Manga(int id, String nomeManga, String autor, String descricao, double nota, EstadoManga estadoManga, String urlCapa) {
        this.id = id;
        this.nomeManga = nomeManga;
        this.autor = autor;
        this.descricao = descricao;
        this.nota = nota;
        this.estadoManga = estadoManga;
        this.urlCapa = urlCapa;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomeManga() { return nomeManga; }
    public void setNomeManga(String nomeManga) { this.nomeManga = nomeManga; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public EstadoManga getEstadoManga() { return estadoManga; }
    public void setEstadoManga(EstadoManga estadoManga) { this.estadoManga = estadoManga; }

    public String getUrlCapa() { return urlCapa; }
    public void setUrlCapa(String urlCapa) { this.urlCapa = urlCapa; }

    // Conversor a partir de HashMap (usado pelo DAO)
    public static Manga converterRegistros(HashMap<String, Object> registros) {
        int idManga = (int) registros.get("id");
        String nome = (String) registros.get("nomemanga");
        String aut = (String) registros.get("autor");
        String desc = (String) registros.get("descricao");
        double notaManga = Double.parseDouble(registros.get("nota").toString());
        String estadoStr = (String) registros.get("estadomanga");
        EstadoManga est = estadoStr != null ? EstadoManga.valueOf(estadoStr) : null;
        String capaUrl = (String) registros.get("urlcapa"); // nome da coluna no banco
        return new Manga(idManga, nome, aut, desc, notaManga, est, capaUrl);
    }
}
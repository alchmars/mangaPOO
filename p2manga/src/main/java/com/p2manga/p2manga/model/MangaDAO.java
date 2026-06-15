package com.p2manga.p2manga.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MangaDAO {

    @Autowired
    DataSource dataSource;
    private JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirManga(Manga manga) {
        String sql = "INSERT INTO manga(nomemanga, autor, descricao, nota, estadomanga, urlcapa) VALUES (?,?,?,?,?,?)";
        Object[] obj = new Object[6];
        obj[0] = manga.getNomeManga();
        obj[1] = manga.getAutor();
        obj[2] = manga.getDescricao();
        obj[3] = manga.getNota();
        obj[4] = manga.getEstadoManga() != null ? manga.getEstadoManga().name() : null;
        obj[5] = manga.getUrlCapa();
        jdbc.update(sql, obj);
    }

    public void atualizarManga(int id, Manga novo) {
        String sql = "UPDATE manga SET nomemanga = ?, autor = ?, descricao = ?, nota = ?, estadomanga = ?, urlcapa = ? WHERE id = ?";
        Object[] obj = new Object[7];
        obj[0] = novo.getNomeManga();
        obj[1] = novo.getAutor();
        obj[2] = novo.getDescricao();
        obj[3] = novo.getNota();
        obj[4] = novo.getEstadoManga() != null ? novo.getEstadoManga().name() : null;
        obj[5] = novo.getUrlCapa();
        obj[6] = id;
        jdbc.update(sql, obj);
    }

    public List<Manga> obterTodosMangas() {
        String sql = "SELECT * FROM manga";
        List<Map<String, Object>> listaRegistros = jdbc.queryForList(sql);
        List<Manga> aux = new ArrayList<>();

        for (Map<String, Object> registro : listaRegistros) {
            aux.add(Manga.converterRegistros(new HashMap<>(registro)));
        }
        return aux;
    }

    public Manga obterManga(int id) {
        String sql = "SELECT * FROM manga WHERE id=?";
        try {
            Map<String, Object> resultado = jdbc.queryForMap(sql, id);
            return Manga.converterRegistros(new HashMap<>(resultado));
        } catch (Exception e) {
            return null;
        }
    }

    public void deletarManga(int id) {
        String sql = "DELETE FROM manga WHERE id = ?";
        jdbc.update(sql, id);
    }
}
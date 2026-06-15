package com.p2manga.p2manga.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangaService {

    @Autowired
    private MangaDAO mdao;

    public void inserirManga(Manga manga) {
        mdao.inserirManga(manga);
    }

    public Manga obterManga(int id) {
        return mdao.obterManga(id);
    }

    public List<Manga> obterTodosMangas() {
        return mdao.obterTodosMangas();
    }

    public void atualizarManga(int id, Manga novo) {
        mdao.atualizarManga(id, novo);
    }

    public void deletarManga(int id) {
        mdao.deletarManga(id);
    }
}

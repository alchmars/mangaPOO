package com.p2manga.p2manga.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.p2manga.p2manga.model.Manga;
import com.p2manga.p2manga.model.EstadoManga;
import com.p2manga.p2manga.model.MangaService;
@Controller
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    public String listarMangas(Model model) {
        List<Manga> lista = mangaService.obterTodosMangas();

        model.addAttribute("listaMangas", lista);
        model.addAttribute("estados", EstadoManga.values());
        model.addAttribute("manga", new Manga());

        return "pagManga"; // Esta será a página principal do catálogo
    }

    @PostMapping("/novo")
    public String inserirManga(@ModelAttribute Manga manga) {
        mangaService.inserirManga(manga);
        return "redirect:/mangas";
    }

    @GetMapping("/editar/{id}")
    public String exibirEdicao(@PathVariable("id") int id, Model model) {
        Manga manga = mangaService.obterManga(id);

        if (manga == null) {
            return "redirect:/mangas";
        }

        model.addAttribute("manga", manga);
        model.addAttribute("estados", EstadoManga.values());
        return "mangas-editar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarManga(@PathVariable("id") int id, @ModelAttribute Manga manga) {
        mangaService.atualizarManga(id, manga);
        return "redirect:/mangas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarManga(@PathVariable("id") int id) {
        mangaService.deletarManga(id);
        return "redirect:/mangas";
    }
}

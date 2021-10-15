package com.songr.controllers;

import com.songr.models.Album;
import com.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albumPage(Model model){
        List<Album> dbAlbums = albumRepository.findAll();
        model.addAttribute("albums", dbAlbums);
        return "pages/albums";
    }

    @PostMapping("/")
    public RedirectView createAlbum(String title, String artist, int songCount, int lengthInS, String imageURL){
        Album newAlbum = new Album(title, artist, songCount, lengthInS, imageURL);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    @GetMapping("/displayAlbum/{albumName}")
    public String displayAlbum(Model m, @PathVariable String albumName){
       Album album = albumRepository.findByTitle(albumName);
       m.addAttribute("album", album);
       return "pages/oneAlbum";
    }

}

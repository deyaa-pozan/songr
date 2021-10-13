package com.myapp.songr.controller;




import com.myapp.songr.model.Album;
import com.myapp.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongrController {

    // Wires up repository
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albumPage(Model m){
        List<Album> dbAlbums = albumRepository.findAll();
        m.addAttribute("albums", dbAlbums);
        return "albums";
    }
    @GetMapping("/")
    public String add(Model m){
        return "addAlbum";
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
        return "oneAlbum";
    }

}

//@Controller
//public class AlbumController {
//
//    @GetMapping("/albums")
//    public String Albums(Model model){
//        Album album1 = new Album("Eghdab", "asala",5,1840,"https://upload.wikimedia.org/wikipedia/ar/f/fb/Ighdab.jpg");
//        Album album2 = new Album("Batlob Redak", "Hani Shaker",7,2500,"https://media.gemini.media/img/large/2021/7/8/2021_7_8_23_1_13_977.jpg");
//        Album album3 = new Album("bihabk 'ana katir", "Wael Kfoury",5,1400,"https://i.ytimg.com/vi/DEFJ9PI4qgc/maxresdefault.jpg");
//        ArrayList<Album> allAlbums = new ArrayList<>();
//        allAlbums.add(album1);
//        allAlbums.add(album2);
//        allAlbums.add(album3);
//        model.addAttribute("albums",allAlbums);
//
//        return "albums";
//    }
//}

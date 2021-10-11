package com.myapp.songr.controller;


import com.myapp.songr.model.Album;
import com.myapp.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;



@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getThreeAlbums(Model m){
        ArrayList<Album> albums = (ArrayList<Album>) albumRepository.findAll();
        m.addAttribute("albums",albums);
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String viewAddAlbumForm(){
        return "addAlbum";
    }
    @PostMapping("/addAlbum")
    public RedirectView addAlbumToDB(Model m,
                                     @RequestParam(value="title") String title,
                                     @RequestParam(value="artist") String artist,
                                     @RequestParam(value="songCount") int songCount,
                                     @RequestParam(value="length") int length,
                                     @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
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

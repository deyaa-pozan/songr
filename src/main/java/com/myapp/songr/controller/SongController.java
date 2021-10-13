package com.myapp.songr.controller;

import com.myapp.songr.model.Album;
import com.myapp.songr.model.Song;
import com.myapp.songr.repository.AlbumRepository;
import com.myapp.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/add-song")
    public RedirectView createAlbum(String title, int length, int trackNumber, String album){
        Album currentAlbum = albumRepository.findByTitle(album);
        Song newSong = new Song(title, length, trackNumber, album, currentAlbum);
        List<Song> songs =currentAlbum.getSongsInThisAlbum();
        if(songs == null){
            songs = new ArrayList<>();
        }
        songs.add(newSong);
        albumRepository.save(currentAlbum);
        songRepository.save(newSong);
        return new RedirectView("/albums");
    }
}
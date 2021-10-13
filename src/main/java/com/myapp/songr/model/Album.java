package com.myapp.songr.model;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Store in the db
@Entity
public class Album {
    // Add Id and GeneratedValue annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;
    @OneToMany(mappedBy = "album")
    List<Song> songsInThisAlbum;
    // JPA and Hibernate NEED Default constructor
    protected Album(){
    }

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getArtist(){
        return this.artist;
    }
    public String getTitle(){
        return this.title;
    }
    public int getSongCount(){
        return this.songCount;
    }
    public int getlength(){
        return this.length;
    }
    public String imageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String path)
    {
        this.imageUrl = path;
    }

    public List<Song> getSongsInThisAlbum() {
        return songsInThisAlbum;
    }

    public void setSongsInThisAlbum(List<Song> songsInThisAlbum) {
        this.songsInThisAlbum = songsInThisAlbum;
    }
}
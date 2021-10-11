package com.myapp.songr.repository;

import com.myapp.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

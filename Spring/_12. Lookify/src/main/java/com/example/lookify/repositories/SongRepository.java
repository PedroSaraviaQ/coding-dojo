package com.example.lookify.repositories;

import com.example.lookify.models.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends BaseRepository<Song> {
    List<Song> findTop10ByOrderByRatingDesc();

    List<Song> findAllByArtistContaining(String artist);
}

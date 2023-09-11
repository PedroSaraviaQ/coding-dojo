package com.example.lookify.services;

import com.example.lookify.models.Song;
import com.example.lookify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService extends BaseService<Song> {
    @Autowired private SongRepository songRepository;

    public List<Song> findTop10ByOrderByRatingDesc() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }

    public List<Song> findAllByArtistContaining(String artist) {
        return songRepository.findAllByArtistContaining(artist);
    }
}

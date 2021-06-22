package com.aws.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.lookify.models.Song;
import com.aws.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	 	private final SongRepository songRepository;
	 	
	    
	    public SongService(SongRepository songRepository) {
	        this.songRepository = songRepository;
	    }

	    public List<Song> allSongs() {
	        return songRepository.findAll();
	    }
	    
	    public List<Song> artistSongs(String artist) {
	        return songRepository.findByArtist(artist);
	    }

	    public Song createSong(Song b) {
	        return songRepository.save(b);
	    }

	    public Song findSong(Long id) {
	        Optional<Song> optionalSong = songRepository.findById(id);
	        if(optionalSong.isPresent()) {
	            return optionalSong.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public void deleteSong(Song song) {
	    	songRepository.delete(song);
	    }
	    
	    public List<Song> topTenSongs() {
	        return songRepository.findTop10ByOrderByRateDesc();
	    }
	
}

package com.aws.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>, JpaRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtist(String artist);
	List<Song> findTop10ByOrderByRateDesc();
}

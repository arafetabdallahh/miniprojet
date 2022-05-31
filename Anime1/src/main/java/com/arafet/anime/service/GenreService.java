package com.arafet.anime.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.arafet.anime.entities.Genre;



public interface GenreService {
	List<Genre> getAllGenre();

	

	Genre saveGenre(Genre genre);
	Page<Genre> getAllGenreParPage(int page, int size);
	void deleteGenreById(Long id);
	Genre getGenre(Long id);
	
	Genre updateGenre(Genre g);
}

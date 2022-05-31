package com.arafet.anime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.arafet.anime.entities.Genre;
import com.arafet.anime.repos.GenreRepository;



@Service
public class GenreServiceImp implements GenreService {
	
	@Autowired
	GenreRepository GenreRepository;

	
	
	@Override
	public List<Genre> getAllGenre() {
		return GenreRepository.findAll();
	}
	
	@Override
    public Genre saveGenre(Genre genre) {
        return GenreRepository.save(genre);
    }
 @Override
    public Page<Genre> getAllGenreParPage(int page, int size) {
    return GenreRepository.findAll(PageRequest.of(page, size));
    }
 
 @Override
    public void deleteGenreById(Long id) {
	 GenreRepository.deleteById(id);
    }
 
 @Override
    public Genre getGenre(Long id) {
        return GenreRepository.findById(id).get();
    }
 @Override
    public Genre updateGenre(Genre g) {
        return GenreRepository.save(g);
    }
	
	


}

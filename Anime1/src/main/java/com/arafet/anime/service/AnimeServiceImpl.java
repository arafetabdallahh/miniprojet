package com.arafet.anime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.arafet.anime.entities.Anime;
import com.arafet.anime.entities.Genre;
import com.arafet.anime.repos.AnimeRepository;

@Service
public class AnimeServiceImpl implements AnimeService{
	
	@Autowired
	private AnimeRepository animeRepository;
	
	@Override
	public Anime saveAnime(Anime A) {
		return animeRepository.save(A);
	}
	@Override
	public Anime updateAnime(Anime A) {
	return animeRepository.save(A);
	}
	@Override
	public void deleteAnime(Anime A) {
		animeRepository.delete(A);
	}
	@Override
	public void deleteAnimeById(Long id) {
		animeRepository.deleteById(id);
	}
	@Override
	public Anime getAnime(Long id) {
	return animeRepository.findById(id).get();
	}
	@Override
	public List<Anime> getAllAnime() {
		return animeRepository.findAll();
	}
	
	@Override
	public Page<Anime> getAllAnimeParPage(int page, int size) {
	return animeRepository.findAll(PageRequest.of(page, size));
	}
	
	

	/*
	@Override
	public List<Anime> findByNomAnime(String nom) {
		
		return animeRepository.findByNomAnime(nom);
	}
	@Override
	public List<Anime> findByNomAnimeContains(String nom) {
		
		return animeRepository.findByNomAnimeContains(nom);
	}
	@Override
	public List<Anime> findByNomEpisode(String nom, int episode) {
		
		return animeRepository.findByNomEpisode(nom, episode);
	}
	@Override
	public List<Anime> findByGenre(Genre genre) {
		
		return animeRepository.findByGenre(genre);
	}
	@Override
	public List<Anime> findByGenreIdGen(Long id) {
		
		return animeRepository.findByGenreIdGen(id);
	}
	@Override
	public List<Anime> findByOrderByNomAnimeAsc() {
		
		return animeRepository.findByOrderByNomAnimeAsc();
	}
	@Override
	public List<Anime> trierAnimeNomEpisode() {
		
		return animeRepository.trierAnimeNomEpisode();
	}
	*/
	

}

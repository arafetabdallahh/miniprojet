package com.arafet.anime.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.arafet.anime.entities.Anime;
import com.arafet.anime.entities.Genre;

public interface AnimeService {
	
	Anime saveAnime(Anime A);
	Anime updateAnime(Anime A);
	void deleteAnime(Anime A);
	void deleteAnimeById(Long id);
	Anime getAnime(Long id);
	List<Anime> getAllAnime();
	Page<Anime> getAllAnimeParPage(int page, int size);
	/*
	
	List<Anime> findByNomAnime(String nom);
	List<Anime> findByNomAnimeContains(String nom);
	List<Anime> findByNomEpisode(String nom,int episode);
	List<Anime> findByGenre (Genre genre);
    List<Anime> findByGenreIdGen(Long id);
	List<Anime> findByOrderByNomAnimeAsc();
	List<Anime> trierAnimeNomEpisode ();
*/	
}

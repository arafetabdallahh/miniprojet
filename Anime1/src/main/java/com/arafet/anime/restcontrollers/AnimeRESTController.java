package com.arafet.anime.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arafet.anime.entities.Anime;
import com.arafet.anime.service.AnimeService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimeRESTController {
	
	@Autowired
    AnimeService animeService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Anime> getAlAnime() {
	return animeService.getAllAnime();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Anime getAnimeById(@PathVariable("id") Long id) {
	return animeService.getAnime(id);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Anime createAnime(@RequestBody Anime anime) {
	return animeService.saveAnime(anime);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Anime updateAnime(@RequestBody Anime anime) {
	return animeService.updateAnime(anime);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteAnime(@PathVariable("id") Long id)
	{
	animeService.deleteAnimeById(id);
	}
	
	

}

package com.arafet.anime.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arafet.anime.entities.Anime;
import com.arafet.anime.entities.Genre;
import com.arafet.anime.service.AnimeService;
import com.arafet.anime.service.GenreService;


@Controller
public class AnimeController {

	@Autowired
	private AnimeService animeService;

	@Autowired
	private GenreService genreService;

	@RequestMapping("AjouterAnime")
	public String AjouterAnime(ModelMap modelMap) {
		modelMap.addAttribute("anime", new Anime());
		modelMap.addAttribute("mode", "new");
		List<Genre> gen = genreService.getAllGenre();
		modelMap.addAttribute("genre", gen);
		return "formAnime";
	}

	@RequestMapping("/saveAnime")
	public String saveAnime(@Valid Anime anime,

			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formAnime";
		animeService.saveAnime(anime);
		return "ListeAnime";
	}

	@RequestMapping("/ListeAnime")
	public String listeAnime(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		Page<Anime> A = animeService.getAllAnimeParPage(page, size);
		modelMap.addAttribute("anime", A);
		List<Genre> gen = genreService.getAllGenre();

		modelMap.addAttribute("genre", gen);

		modelMap.addAttribute("pages", new int[A.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "ListeAnime";
	}

	@RequestMapping("/supprimerAnime")
	public String supprimerAnime(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		animeService.deleteAnimeById(id);
		Page<Anime> A = animeService.getAllAnimeParPage(page,

				size);

		modelMap.addAttribute("anime", A);
		modelMap.addAttribute("pages", new int[A.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeAnime";

	}

	@RequestMapping("/modifierAnime")
	public String editerAnime(@RequestParam("id") Long id, ModelMap modelMap) {
		Anime A = animeService.getAnime(id);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("anime", A);
		List<Genre> gen = genreService.getAllGenre();
		modelMap.addAttribute("genre", gen);
		return "formAnime";
	}

	@RequestMapping("/updateAnime")
	public String updateAnime(@ModelAttribute("anime") Anime anime, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException

	{
		// conversion de la date

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		anime.setDateCreation(dateCreation);
		
		animeService.updateAnime(anime);
		List<Anime> A = animeService.getAllAnime();
		modelMap.addAttribute("anime", A);
		return "listeAnime";

	}

	/*
	 * @RequestMapping("/chercherNom") public String
	 * chercherweapen(@RequestParam("nomAnime") String nom, ModelMap modelMap,
	 * 
	 * @RequestParam (name="page",defaultValue = "0") int page,
	 * 
	 * @RequestParam (name="size", defaultValue = "2") int size)
	 * 
	 * 
	 * {
	 * 
	 * List <Anime> anime = animeService.findByNomAnimeContains(nom);
	 * 
	 * modelMap.addAttribute("anime",anime); System.out.println(anime);
	 * 
	 * return "listeAnime"; }
	 */
	@RequestMapping("/chercherGenre")
	public String chercherCat(@RequestParam("idCat") int idCat, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		List<Anime> A = animeService.getAllAnime();
		A = A.stream().filter(x -> x.getGenre().getIdCat() == idCat).collect(Collectors.toList());
		modelMap.addAttribute("anime", A);
		Page<Genre> g = genreService.getAllGenreParPage(page, size);
		modelMap.addAttribute("genre", g);
		modelMap.addAttribute("pages", new int[g.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeAnime";
	}

}

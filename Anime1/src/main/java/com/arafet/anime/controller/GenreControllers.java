package com.arafet.anime.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class GenreControllers {

	@Autowired
	private AnimeService animeService;
	
	@Autowired
	private GenreService genreService;

	@RequestMapping("AjouterGenre")
	public String AjouterGenre(ModelMap modelMap) {
		modelMap.addAttribute("genre", new Genre());
		modelMap.addAttribute("mode", "new");
		
		return "formGenre";
	}


	@RequestMapping("/saveGenre")
	public String saveGenre(@Valid Genre genre,

			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formGenre";
		genreService.saveGenre(genre);
		return "ListeGenre";
	}


	@RequestMapping("/ListeGenre")
	public String listeGenre(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size)
	{
		Page<Genre> g = genreService.getAllGenreParPage(page, size);
		modelMap.addAttribute("genre", g);
		modelMap.addAttribute("pages", new int[g.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeGenre";
	}
	
	

	@RequestMapping("/supprimerGenre")
	public String supprimerGenre(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		genreService.deleteGenreById(id);
		Page<Genre> g = genreService.getAllGenreParPage(page,size);

		modelMap.addAttribute("genre", g);
		modelMap.addAttribute("pages", new int[g.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeGenre";

	}

	@RequestMapping("/modifierGenre")
	public String editerAnime(@RequestParam("id") Long id, ModelMap modelMap) {
		Genre g = genreService.getGenre(id);
	
		modelMap.addAttribute("genre", g);
		modelMap.addAttribute("mode", "edit");
		
		

		return "formGenre";
	}

	 @RequestMapping("/updateGenre")
	    public String updateCategorie(@ModelAttribute("genre") Genre genre,ModelMap modelMap) throws ParseException
	    {

	        genreService.updateGenre(genre);
	        List<Genre> g = genreService.getAllGenre();
	        modelMap.addAttribute("genre", g);
	        return "ListeGenre";
	    }
	/* @RequestMapping("/chercherGenre")
	
	    public String chercherGenre(@RequestParam("nomCat") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Anime> A = animeService.findByNomAnimeContains(nom);
	    	  System.out.println(A);
	    	  modelMap.addAttribute("genre",A);
	    	  
	    	  return "chercherCat";
	    } */
}

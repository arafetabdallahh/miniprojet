package com.arafet.anime;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.arafet.anime.entities.Anime;
import com.arafet.anime.entities.Genre;
import com.arafet.anime.repos.AnimeRepository;
import com.arafet.anime.service.AnimeService;

@SpringBootTest
class Anime1ApplicationTests {
	
}
/*
	@Autowired
	private AnimeRepository animeRepository;

	@Autowired
	private AnimeService animeService;

	

	@Test
	public void testFindAnime() {
		Anime A = animeRepository.findById(1L).get();

		System.out.println(A);
	}

	@Test
	public void testUpdateAnime() {
		Anime A = animeRepository.findById(1L).get();
		A.setEpisodeAnime(999);
		animeRepository.save(A);
	}

	@Test
	public void testDeleteAnime() {
		animeRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousAnime() {
		List<Anime> prods = animeRepository.findAll();
		for (Anime A : prods) {
			System.out.println(A);
		}

	}

	@Test
	public void testFindByNomAnimeContains() {
		Page<Anime> A = animeService.getAllAnimeParPage(0, 2);
		System.out.println(A.getSize());
		System.out.println(A.getTotalElements());
		System.out.println(A.getTotalPages());
		A.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	
	
	/*
	 @Test
	public void testFindByNomAnime() {
		List<Anime> A = animeRepository.findByNomAnime("Monster");

		for (Anime p : A) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomAnimesContains() {
		List<Anime> A = animeRepository.findByNomAnimeContains("Monster");

		for (Anime p : A) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomEpisode() {
		List<Anime> A = animeRepository.findByNomEpisode("Monster", 74);
		for (Anime p : A) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByCategorie() {
		Genre gen = new Genre();
		gen.setIdCat(1L);
		List<Anime> A = animeRepository.findByGenre(gen);
		for (Anime p : A) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Anime> A = animeRepository.findByGenreIdGen(1L);
		for (Anime p : A) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Anime> A = animeRepository.findByOrderByNomAnimeAsc();
		for (Anime p : A) {
			System.out.println(p);
		}

	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Anime> A = animeRepository.trierAnimeNomEpisode();
	for (Anime p : A)
	{
	System.out.println(p);
	}

	}
	
	 */



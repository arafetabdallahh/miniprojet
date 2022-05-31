package com.arafet.anime.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import com.arafet.anime.entities.Anime;
import com.arafet.anime.entities.Genre;

@RepositoryRestResource(path = "rest")
public interface AnimeRepository extends JpaRepository<Anime, Long> {

	/*@Query("select A from Anime A where A.nomAnime like 'monster'")
	List<Anime> findByNomAnime(String nom);
	@Query("select A from Anime A where A.genre.nonCat = ?1")
	List<Anime> findByNomAnimeContains(String nom);
	
	@Query("select A from Anime A where A.nomAnime like %:nom and A.episodeAnime > :episode")
	List<Anime> findByNomEpisode (@Param("nom") String nom,@Param("episode") int episode);

	@Query("select A from Anime A where A.genre = ?1")
	List<Anime> findByGenre (Genre genre);
	
	List<Anime> findByGenreIdGen(Long id);
	
	List<Anime> findByOrderByNomAnimeAsc();
	
	@Query("select A from Anime A order by A.nomAnime ASC, A.episodeAnime DESC")
	List<Anime> trierAnimeNomEpisode ();*/

}

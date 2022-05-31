package com.arafet.anime.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "NomAnime", types = { Anime.class })
public interface AnimeProjection {

	public String getNomAnime();
}

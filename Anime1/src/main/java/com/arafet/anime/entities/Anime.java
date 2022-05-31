package com.arafet.anime.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Anime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnime;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomAnime;
	
	@Min(value = 10)
	@Max(value = 2000)
	private int episodeAnime;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Genre genre;

	
	public Anime() {
		super();
		
	}

	public Anime(String nomAnime, int episodeAnime, Date dateCreation, Genre g) {
		super();
		this.nomAnime = nomAnime;
		this.episodeAnime = episodeAnime;
		this.dateCreation = dateCreation;
		this.setGenre(g);
	}

	public Long getIdAnime() {
		return idAnime;
	}

	public void setIdAnime(Long idAnime) {
		this.idAnime = idAnime;
	}

	public String getNomAnime() {
		return nomAnime;
	}

	public void setNomAnime(String nomAnime) {
		this.nomAnime = nomAnime;
	}

	public int getEpisodeAnime() {
		return episodeAnime;
	}

	public void setEpisodeAnime(int episodeAnime) {
		this.episodeAnime = episodeAnime;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Anime [idAnime=" + idAnime + ", nomAnime=" + nomAnime + ", episodeAnime=" + episodeAnime
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	
	
	

	
}

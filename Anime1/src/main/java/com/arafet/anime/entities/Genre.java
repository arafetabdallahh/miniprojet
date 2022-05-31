package com.arafet.anime.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idCat;
	private String nomCat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Anime> anime;
	
	
	
	public Genre(String nomCat, List<Anime> anime) {
		super();
		this.nomCat = nomCat;
		this.anime = anime;
	}
	
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	
	public List<Anime> getAnime() {
		return anime;
	}
	public void setAnime(List<Anime> anime) {
		this.anime = anime;
	}

	

}

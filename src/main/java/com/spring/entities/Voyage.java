package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Voyage {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	@Lob
	@Size(min = 10, message = "la description doit faire au moins 10 caractères")
	private String description;
	private String superviseur;
	private String destination;
	@Min(value = 100, message = "le prix doit être supérieur à 100€")
	private double prix;
	
	
	
	
	
	public Voyage() {
		super();
	}
	public Voyage(String date, @Size(min = 10) String description, String superviseur, String destination,
			@Min(100) double prix) {
		super();
		this.date = date;
		this.description = description;
		this.superviseur = superviseur;
		this.destination = destination;
		this.prix = prix;
	}
	public Voyage(int id, String date, @Size(min = 10) String description, String superviseur, String destination,
			@Min(100) double prix) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.superviseur = superviseur;
		this.destination = destination;
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuperviseur() {
		return superviseur;
	}
	public void setSuperviseur(String superviseur) {
		this.superviseur = superviseur;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}

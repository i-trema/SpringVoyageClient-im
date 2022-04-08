package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "l''adresse est requise")
	private String adresse;
	@Min(value = 16, message = "l''âge minimum est 16 ans")
	@NotNull(message = "l''âge est requis")
	private int age;
	@Email
	@NotBlank(message = "ce champs est requis")
	private String email;
	private String grade;
	@Size(min=5, max=30)
	@NotBlank(message = "ce champs est requis")
	private String nom;
	@Size(min=5, max=30)
	@NotBlank(message = "ce champs est requis")
	private String prenom;
	@NotBlank(message = "ce champs est requis")
	@Size(min = 8,message = "au moins 8 caractères")
	private String telephone;
	
	
	
	public Client() {
		super();
	}
	
	public Client(@NotBlank String adresse, @Min(16) @NotNull int age, @Email @NotBlank String email, String grade,
			@Size(min = 5, max = 30) @NotBlank String nom, @Size(min = 5, max = 30) @NotBlank String prenom,
			@NotBlank @Size(min = 8) String telephone) {
		super();
		this.adresse = adresse;
		this.age = age;
		this.email = email;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	
	public Client(long id, @NotBlank String adresse, @Min(16) @NotNull int age, @Email @NotBlank String email,
			String grade, @Size(min = 5, max = 30) @NotBlank String nom,
			@Size(min = 5, max = 30) @NotBlank String prenom, @NotBlank @Size(min = 8) String telephone) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.age = age;
		this.email = email;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}

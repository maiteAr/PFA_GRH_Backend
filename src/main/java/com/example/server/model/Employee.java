package com.example.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cin", nullable = false,unique= true)
	private String cin;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	private String emailId;
	private String gendre;
	private String Etat;
	private String Nationalite;
    private String Grade;
    private String Tel;
    private String Adresse;
	private String Ville;
	@Column(name = "diplome", nullable = false)
	private String diplome;
	
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEmbauche;

    private double salaire;

    private String image;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
    private Service service;
	
	public Employee() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	
	public Service getService() {
		return service;
	}

	public void setService(final Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Employee [Adresse=" + Adresse + ", Etat=" + Etat + ", Grade=" + Grade + ", Nationalite=" + Nationalite
				+ ", Status=" + diplome + ", Tel=" + Tel + ", Ville=" + Ville + ", cin="
				+ cin + ", dateEmbauche=" + dateEmbauche + ", dateNaissance=" + dateNaissance + ", emailId=" + emailId
				+ ", firstName=" + firstName + ", gendre=" + gendre + ", id=" + id
				+ ", image=" + image + ", lastName=" + lastName + ", salaire=" + salaire + ", service=" + service + "]";
	}

	public String getGendre() {
		return gendre;
	}

	public void setGendre(String gendre) {
		this.gendre = gendre;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public String getNationalite() {
		return Nationalite;
	}

	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Employee(final String firstName,final String lastName,final String emailId,final String gendre,final String etat,final String nationalite,
	final String grade,final String tel,final String adresse,final String ville,final String status,final
			Date dateNaissance,final Date dateEmbauche,final double salaire,final String image, final String cin,
			final Service service) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gendre = gendre;
		this.cin  =cin;
		this.Etat = etat;
		this.Nationalite = nationalite;
		this.Grade = grade;
		this.Tel = tel;
		this.Adresse = adresse;
		this.Ville = ville;
		this.diplome = status;
		this.dateNaissance = dateNaissance;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		this.image = image;
		this.service = service;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	
	
}

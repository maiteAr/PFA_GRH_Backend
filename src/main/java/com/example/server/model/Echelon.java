package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "echelon")
public class Echelon {
    @Id
    @Column(name = "id_echelon", nullable = false)
    private long id_echelon;
    @Column(name = "lib_echelon", nullable = false)
    private String lib_echelon;
    @Column(name = "indice", nullable = false)
    private int indice;
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_grade", nullable = false)
    private Grade id_grade;
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_cadre", nullable = false)
    private Cadre id_cadre;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_echelle", nullable = false)
    private Echelle id_echelle;

    @Column(name = "suivant", nullable = false)
    private int suivant;

    @Column(name = "precedent", nullable = false)
    private int precedent;

    public long getId_echelon() {
        return id_echelon;
    }

    public void setId_echelon(long id_echelon) {
        this.id_echelon = id_echelon;
    }

    public String getLib_echelon() {
        return lib_echelon;
    }

    public void setLib_echelon(String lib_echelon) {
        this.lib_echelon = lib_echelon;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Grade getId_grade() {
        return id_grade;
    }

    public void setId_grade(Grade id_grade) {
        this.id_grade = id_grade;
    }

    public Cadre getId_cadre() {
        return id_cadre;
    }

    public void setId_cadre(Cadre id_cadre) {
        this.id_cadre = id_cadre;
    }

    public Echelle getId_echelle() {
        return id_echelle;
    }

    public void setId_echelle(Echelle id_echelle) {
        this.id_echelle = id_echelle;
    }

    public int getSuivant() {
        return suivant;
    }

    public void setSuivant(int suivant) {
        this.suivant = suivant;
    }

    public int getPrecedent() {
        return precedent;
    }

    public void setPrecedent(int precedent) {
        this.precedent = precedent;
    }

    public Echelon() {
    }

}
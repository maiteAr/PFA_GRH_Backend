package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caisse_retraite")
public class Caisse_retraite {
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long  id_caisse;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    public long getId_caisse() {
        return id_caisse;
    }

    public void setId_caisse(long id_caisse) {
        this.id_caisse = id_caisse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Caisse_retraite( String libelle) {
        
        this.libelle = libelle;
    }

    public Caisse_retraite() {
    }

    @Override
    public String toString() {
        return "Caisse_retraite [id_caisse=" + id_caisse + ", libelle=" + libelle + "]";
    }
}
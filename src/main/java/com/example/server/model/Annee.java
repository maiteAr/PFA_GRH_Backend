package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "annees")
public class Annee {
    @Id
    @Column(name = "id_annee", nullable = false,unique=true)
    private long id_annee;
    

    public long getId_annee() {
        return id_annee;
    }

    public void setId_annee(long id_annee) {
        this.id_annee = id_annee;
    }

    public Annee(long id_annee) {
        this.id_annee = id_annee; 
    }

    public Annee() {
    }

    @Override
    public String toString() {
        return "Annee [id_annee=" + id_annee + "]";
    }
    

}
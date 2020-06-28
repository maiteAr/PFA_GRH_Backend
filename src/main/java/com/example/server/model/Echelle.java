package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "echelle")
public class Echelle {

    @Id
    @Column(name = "id_echelon", nullable = false)
    private int id_echelle;
    @Column(name = "lib_echelle", nullable = false)
    private String lib_echelle;

    public int getId_echelle() {
        return id_echelle;
    }

    public void setId_echelle(int id_echelle) {
        this.id_echelle = id_echelle;
    }

    public String getLib_echelle() {
        return lib_echelle;
    }

    public void setLib_echelle(String lib_echelle) {
        this.lib_echelle = lib_echelle;
    }

    public Echelle() {
    }

    public Echelle(String lib_echelle) {
        this.lib_echelle = lib_echelle;
    }

    @Override
    public String toString() {
        return "Echelle [id_echelle=" + id_echelle + ", lib_echelle=" + lib_echelle + "]";
    }

}
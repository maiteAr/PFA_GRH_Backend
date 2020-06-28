package com.example.server.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadre")
public class Cadre {

    @Id
    @Column(name = "id_cadre", nullable = false)
    private int id_cadre;
    @Column(name = "lib_cadre", nullable = false)
    private String lib_cadre;

    @Column(name = "decret", nullable = false)
    private String decret;

    public int getId_cadre() {
        return id_cadre;
    }

    public void setId_cadre(int id_cadre) {
        this.id_cadre = id_cadre;
    }

    public String getLib_cadre() {
        return lib_cadre;
    }

    public void setLib_cadre(String lib_cadre) {
        this.lib_cadre = lib_cadre;
    }

    public String getDecret() {
        return decret;
    }

    public void setDecret(String decret) {
        this.decret = decret;
    }

    public Cadre() {
    }
    
}
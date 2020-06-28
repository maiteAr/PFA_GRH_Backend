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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jour_feriers")
public class Jour_feriers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_ferier;
    
    @Column(name = "lib", nullable = false)
    private String lib;

    @Column(name = "date", nullable = false)
    private Date date;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_annee", nullable = false)
    private Annee id_annee;

    public long getId_ferier() {
        return id_ferier;
    }

    public void setId_ferier(long id_ferier) {
        this.id_ferier = id_ferier;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Annee getId_annee() {
        return id_annee;
    }

    public void setId_annee(Annee id_annee) {
        this.id_annee = id_annee;
    }

    public Jour_feriers() {
    }

    public Jour_feriers(String lib, Date date, @NotNull Annee id_annee) {
        this.lib = lib;
        this.date = date;
        this.id_annee = id_annee;
    }

    @Override
    public String toString() {
        return "Jour_feriers [date=" + date + ", id_annee=" + id_annee + ", id_ferier=" + id_ferier + ", lib=" + lib
                + "]";
    }



}
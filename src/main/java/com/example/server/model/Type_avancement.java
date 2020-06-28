package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_avancements")
public class Type_avancement {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
  

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "nb_mois", nullable = false)
    private int nb_mois;

    @Column(name = "ac", nullable = false)
    private int ac;

     @Column(name = "nv", nullable = false)
    private int nv;

     @Column(name = "note_min", nullable = false)
    private float note_min;

     @Column(name = "note_max", nullable = false)
    private float note_max;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNb_mois() {
        return nb_mois;
    }

    public void setNb_mois(int nb_mois) {
        this.nb_mois = nb_mois;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public float getNote_min() {
        return note_min;
    }

    public void setNote_min(float note_min) {
        this.note_min = note_min;
    }

    public float getNote_max() {
        return note_max;
    }

    public void setNote_max(float note_max) {
        this.note_max = note_max;
    }

    public Type_avancement() {
    }

    public Type_avancement(String type, int nb_mois, int ac, int nv, float note_min, float note_max) {
        this.type = type;
        this.nb_mois = nb_mois;
        this.ac = ac;
        this.nv = nv;
        this.note_min = note_min;
        this.note_max = note_max;
    }

    @Override
    public String toString() {
        return "Type_avancement [ac=" + ac + ", id=" + id + ", nb_mois=" + nb_mois + ", note_max=" + note_max
                + ", note_min=" + note_min + ", nv=" + nv + ", type=" + type + "]";
    }
	
}
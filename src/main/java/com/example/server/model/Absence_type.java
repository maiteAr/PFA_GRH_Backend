package com.example.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Absence_type")
public class Absence_type {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long  id_absence;

    @Column(name = "type", nullable = false)
    private String type;

    public long getId_absence() {
        return id_absence;
    }

    public void setId_absence(long id_absence) {
        this.id_absence = id_absence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Absence_type [id_absence=" + id_absence + ", type=" + type + "]";
    }

    public Absence_type() {
    }

    public Absence_type(String type) {
        this.type = type;
    }

    
    
}
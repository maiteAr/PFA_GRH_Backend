package com.example.server.model;

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
@Table(name = "notes")
public class Note {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "note", nullable = false)
    private float note;

    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_annee", nullable = false)
    private Annee id_annee;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Annee getId_annee() {
        return id_annee;
    }

    public void setId_Annee(Annee id_annee) {
        this.id_annee = id_annee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Note() {
    }

    public Note(float note, @NotNull Annee id_annee, @NotNull Employee employee) {
        this.note = note;
        this.id_annee = id_annee;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Note [employee=" + employee + ", id=" + id + ", id_annee=" + id_annee + ", note=" + note + "]";
    }
    
}
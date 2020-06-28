package com.example.server.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "affecter_echelon")
public class Affecter_echelon {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
	@OneToOne
	@JoinColumn(name = "id_echelon", nullable = false)
    private Echelon id_echelon;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_affectation;

    private float note_moyenne;

    @NotNull
	@OneToOne
	@JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Echelon getId_echelon() {
        return id_echelon;
    }

    public void setId_echelon(Echelon id_echelon) {
        this.id_echelon = id_echelon;
    }

    public Date getDate_affectation() {
        return date_affectation;
    }

    public void setDate_affectation(Date date_affectation) {
        this.date_affectation = date_affectation;
    }

    public float getNote_moyenne() {
        return note_moyenne;
    }

    public void setNote_moyenne(float note_moyenne) {
        this.note_moyenne = note_moyenne;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Affecter_echelon [date_affectation=" + date_affectation + ", employee=" + employee + ", id=" + id
                + ", id_echelon=" + id_echelon + ", note_moyenne=" + note_moyenne + "]";
    }

    public Affecter_echelon() {
    }

    public Affecter_echelon(@NotNull Echelon id_echelon, Date date_affectation, float note_moyenne,
            @NotNull Employee employee) {
        this.id_echelon = id_echelon;
        this.date_affectation = date_affectation;
        this.note_moyenne = note_moyenne;
        this.employee = employee;
    }
}
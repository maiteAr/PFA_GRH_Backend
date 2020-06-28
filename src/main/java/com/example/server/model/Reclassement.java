
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
@Table(name = "reclassements")
public class Reclassement {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_cadre", nullable = false)
    private Cadre id_cadre;

   

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_grade", nullable = false)
    private Grade id_grade;

    @Column(name = "rec_exam", nullable = false)
    private int rec_exam;

    private Date date_reclassement;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_echelle", nullable = false)
    private Echelle id_echelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cadre getId_cadre() {
        return id_cadre;
    }

    public void setId_cadre(Cadre id_cadre) {
        this.id_cadre = id_cadre;
    }

    public Grade getId_grade() {
        return id_grade;
    }

    public void setId_grade(Grade id_grade) {
        this.id_grade = id_grade;
    }

    public int getRec_exam() {
        return rec_exam;
    }

    public void setRec_exam(int rec_exam) {
        this.rec_exam = rec_exam;
    }

    public Date getDate_reclassement() {
        return date_reclassement;
    }

    public void setDate_reclassement(Date date_reclassement) {
        this.date_reclassement = date_reclassement;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Echelle getId_echelle() {
        return id_echelle;
    }

    public void setId_echelle(Echelle id_echelle) {
        this.id_echelle = id_echelle;
    }

    public Reclassement() {
    }

    public Reclassement(@NotNull Cadre id_cadre, @NotNull Grade id_grade, int rec_exam, Date date_reclassement,
            @NotNull Employee employee, @NotNull Echelle id_echelle) {
        this.id_cadre = id_cadre;
        this.id_grade = id_grade;
        this.rec_exam = rec_exam;
        this.date_reclassement = date_reclassement;
        this.employee = employee;
        this.id_echelle = id_echelle;
    }

    @Override
    public String toString() {
        return "Reclassement [date_reclassement=" + date_reclassement + ", employee=" + employee + ", id=" + id
                + ", id_cadre=" + id_cadre + ", id_echelle=" + id_echelle + ", id_grade=" + id_grade + ", rec_exam="
                + rec_exam + "]";
    }

}
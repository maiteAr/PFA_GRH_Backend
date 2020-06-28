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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "absences")
public class Absence {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_absence", nullable = false)
    private Absence_type type;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  dateFin;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_annee", nullable = false)
    private Annee id_annee;

    @Column(name = "nb_jours", nullable = false)
    private int nb_jours;

    
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

    public Absence_type getType() {
        return type;
    }

    public void setType(Absence_type type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Annee getId_annee() {
        return id_annee;
    }

    public void setId_annee(Annee id_annee) {
        this.id_annee = id_annee;
    }

    public int getNb_jours() {
        return nb_jours;
    }

    public void setNb_jours(int nb_jours) {
        this.nb_jours = nb_jours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Absence() {
    }

    public Absence(@NotNull Absence_type type, Date dateDebut, Date dateFin, @NotNull Annee id_annee, int nb_jours,
            @NotNull Employee employee) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.id_annee = id_annee;
        this.nb_jours = nb_jours;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Absence [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", employee=" + employee + ", id=" + id
                + ", id_annee=" + id_annee + ", nb_jours=" + nb_jours + ", type=" + type + "]";
    }

   

    
    

	
}
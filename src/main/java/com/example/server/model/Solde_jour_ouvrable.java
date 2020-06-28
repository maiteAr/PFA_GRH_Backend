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
@Table(name = "solde_jour_ouvrable")
public class Solde_jour_ouvrable {

    @Column(name = "solde", nullable = false)
    private int solde;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_annee", nullable = false)
    private Annee id_Annee;

    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

   

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Annee getId_Annee() {
        return id_Annee;
    }

    public void setId_Annee(Annee id_Annee) {
        this.id_Annee = id_Annee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Solde_jour_ouvrable() {
    }

    public Solde_jour_ouvrable(int solde, @NotNull Annee id_Annee, @NotNull Employee employee) {
        this.solde = solde;
        this.id_Annee = id_Annee;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Solde_jour_ouvrable [employee=" + employee + ", id_Annee=" + id_Annee + ", solde="
                + solde + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
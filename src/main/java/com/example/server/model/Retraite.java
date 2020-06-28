package com.example.server.model;

import java.util.Date;

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
@Table(name = "retraites")
public class Retraite {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;
    
    private int salaire_base;
    private int indice_residence;
    private int indice_familialle;
    private int indice_difficulte;
    private int indice_graduation;
    private int salaire_annuel_brut;
    private int salaire_mensuel_brut;
    private int salaire_mensuel_net;
    private int coti_retraite;
    private int coti_mutuelle;
	
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_retraite;
    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_caisse", nullable = false)
    private Caisse_retraite type;

    @NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public int getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(int salaire_base) {
        this.salaire_base = salaire_base;
    }

    public int getIndice_residence() {
        return indice_residence;
    }

    public void setIndice_residence(int indice_residence) {
        this.indice_residence = indice_residence;
    }

    public int getIndice_familialle() {
        return indice_familialle;
    }

    public void setIndice_familialle(int indice_familialle) {
        this.indice_familialle = indice_familialle;
    }

    public int getIndice_difficulte() {
        return indice_difficulte;
    }

    public void setIndice_difficulte(int indice_difficulte) {
        this.indice_difficulte = indice_difficulte;
    }

    public int getIndice_graduation() {
        return indice_graduation;
    }

    public void setIndice_graduation(int indice_graduation) {
        this.indice_graduation = indice_graduation;
    }

    public int getSalaire_annuel_brut() {
        return salaire_annuel_brut;
    }

    public void setSalaire_annuel_brut(int salaire_annuel_brut) {
        this.salaire_annuel_brut = salaire_annuel_brut;
    }

    public int getSalaire_mensuel_brut() {
        return salaire_mensuel_brut;
    }

    public void setSalaire_mensuel_brut(int salaire_mensuel_brut) {
        this.salaire_mensuel_brut = salaire_mensuel_brut;
    }

    public int getSalaire_mensuel_net() {
        return salaire_mensuel_net;
    }

    public void setSalaire_mensuel_net(int salaire_mensuel_net) {
        this.salaire_mensuel_net = salaire_mensuel_net;
    }

    public int getCoti_retraite() {
        return coti_retraite;
    }

    public void setCoti_retraite(int coti_retraite) {
        this.coti_retraite = coti_retraite;
    }

    public int getCoti_mutuelle() {
        return coti_mutuelle;
    }

    public void setCoti_mutuelle(int coti_mutuelle) {
        this.coti_mutuelle = coti_mutuelle;
    }

    public Date getDate_retraite() {
        return date_retraite;
    }

    public void setDate_retraite(Date date_retraite) {
        this.date_retraite = date_retraite;
    }

    public Caisse_retraite getType() {
        return type;
    }

    public void setType(Caisse_retraite type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Retraite(int salaire_base, int indice_residence, int indice_familialle, int indice_difficulte,
            int indice_graduation, int salaire_annuel_brut, int salaire_mensuel_brut, int salaire_mensuel_net,
            int coti_retraite, int coti_mutuelle, Date date_retraite, @NotNull Caisse_retraite type,
            @NotNull Employee employee) {
        this.salaire_base = salaire_base;
        this.indice_residence = indice_residence;
        this.indice_familialle = indice_familialle;
        this.indice_difficulte = indice_difficulte;
        this.indice_graduation = indice_graduation;
        this.salaire_annuel_brut = salaire_annuel_brut;
        this.salaire_mensuel_brut = salaire_mensuel_brut;
        this.salaire_mensuel_net = salaire_mensuel_net;
        this.coti_retraite = coti_retraite;
        this.coti_mutuelle = coti_mutuelle;
        this.date_retraite = date_retraite;
        this.type = type;
        this.employee = employee;
    }

    public Retraite() {
    }

    @Override
    public String toString() {
        return "Retraite [coti_mutuelle=" + coti_mutuelle + ", coti_retraite=" + coti_retraite + ", date_retraite="
                + date_retraite + ", employee=" + employee + ", id=" + id + ", indice_difficulte=" + indice_difficulte
                + ", indice_familialle=" + indice_familialle + ", indice_graduation=" + indice_graduation
                + ", indice_residence=" + indice_residence + ", salaire_annuel_brut=" + salaire_annuel_brut
                + ", salaire_base=" + salaire_base + ", salaire_mensuel_brut=" + salaire_mensuel_brut
                + ", salaire_mensuel_net=" + salaire_mensuel_net + ", type=" + type + "]";
    }
}
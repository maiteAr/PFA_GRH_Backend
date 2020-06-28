
package com.example.server.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "permissions")
public class Permission {

    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "motif", nullable = false)
    private String motif;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "type", nullable = false)
    private String type;
    private LocalDateTime dateDebut;
    private LocalDateTime  dateFin;
    private LocalDateTime  dateReprise;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Permission() {
    }

    public Permission(String motif, String status, String type, LocalDateTime createdAt,
            LocalDateTime updatedAt,
            @NotNull Employee employee) {
        this.motif = motif;
        this.status = status;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
    }

    

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDateTime getDateReprise() {
        return dateReprise;
    }

    public void setDateReprise(LocalDateTime dateReprise) {
        this.dateReprise = dateReprise;
    }

    @Override
    public String toString() {
        return "Permission [createdAt=" + createdAt + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
                + ", dateReprise=" + dateReprise + ", employee=" + employee + ", id=" + id + ", motif=" + motif
                + ", status=" + status + ", type=" + type + ", updatedAt=" + updatedAt + "]";
    }

    

	
}
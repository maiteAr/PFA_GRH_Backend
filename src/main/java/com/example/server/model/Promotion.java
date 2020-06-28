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
@Table(name = "promotions")
public class Promotion {

    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "note_moyenne", nullable = false)
    private float note_moyenne;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "type", nullable = false)
    private String type;
    private int ac;
    private int  nv;
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

    public Promotion() {
    }

    public float getNote_moyenne() {
        return note_moyenne;
    }

    public void setNote_moyenne(float note_moyenne) {
        this.note_moyenne = note_moyenne;
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

    public Promotion(float note_moyenne, String status, String type, int ac, int nv, LocalDateTime createdAt,
            LocalDateTime updatedAt, @NotNull Employee employee) {
        this.note_moyenne = note_moyenne;
        this.status = status;
        this.type = type;
        this.ac = ac;
        this.nv = nv;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Promotion [ac=" + ac + ", createdAt=" + createdAt + ", employee=" + employee + ", id=" + id
                + ", note_moyenne=" + note_moyenne + ", nv=" + nv + ", status=" + status + ", type=" + type
                + ", updatedAt=" + updatedAt + "]";
    }

    


    

    

	
}
package com.example.server.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @Column(name = "id_grade", nullable = false)
    private int id_grade;
    @Column(name = "lib_grade", nullable = false)
    private String lib_grade;
    @Column(name = "lib_grade_ar", nullable = false)
    private String lib_grade_ar;

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }

    public String getLib_grade() {
        return lib_grade;
    }

    public void setLib_grade(String lib_grade) {
        this.lib_grade = lib_grade;
    }

    public String getLib_grade_ar() {
        return lib_grade_ar;
    }

    public void setLib_grade_ar(String lib_grade_ar) {
        this.lib_grade_ar = lib_grade_ar;
    }

    public Grade(String lib_grade, String lib_grade_ar) {
        this.lib_grade = lib_grade;
        this.lib_grade_ar = lib_grade_ar;
    }

    public Grade() {
    }
}
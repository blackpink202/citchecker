package com.group1.citchecker.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tblattendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classes;

    @ManyToMany
    @JoinTable(
            name = "attendance_student",
            joinColumns = @JoinColumn(name = "attendance_id")
    )
    private List<StudentEntity> students;
    
    
    @Column(name = "Date")
    private LocalDate date; // Use LocalDate for date representation

    @Column(name = "Status")
    private boolean present;

    public AttendanceEntity() {
        // Default constructor
    }

    public AttendanceEntity(int id, LocalDate date, boolean present) {
        this.id = id;
        this.date = date;
        this.present = present;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassEntity getClasses() {
        return classes;
    }

    public void setClasses(ClassEntity classes) {
        this.classes = classes;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
package com.hospitalmanagement.hospitalmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String room;
    private String doctorname;
    private Date admitdate;
    private double expenses;
    private String status;

    public Patient() {
    }

    public Patient(Long id, String name, int age, String room, String doctorname, Date admitdate, double expenses, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.room = room;
        this.doctorname = doctorname;
        this.admitdate = admitdate;
        this.expenses = expenses;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Date getAdmitdate() {
        return admitdate;
    }

    public void setAdmitdate(Date admitdate) {
        this.admitdate = admitdate;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", room='" + room + '\'' +
                ", doctorname='" + doctorname + '\'' +
                ", admitdate=" + admitdate +
                ", expenses=" + expenses +
                ", status='" + status + '\'' +
                '}';
    }
}

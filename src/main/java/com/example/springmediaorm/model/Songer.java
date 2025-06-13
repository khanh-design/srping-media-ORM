package com.example.srpingmediaorm.model;

import javax.persistence.*;

@Entity
@Table(name = "songer")
public class Songer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma;

    private String tenBaiHat;
    private String ngheSyTheHien;
    private String theLoai;

    @Column(name = "file_path")
    private String filePath;

    public Songer() {

    }

    public Songer(int ma, String tenBaiHat, String ngheSyTheHien, String theLoai, String filePath) {
        this.ma = ma;
        this.tenBaiHat = tenBaiHat;
        this.ngheSyTheHien = ngheSyTheHien;
        this.theLoai = theLoai;
        this.filePath = filePath;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSyTheHien() {
        return ngheSyTheHien;
    }

    public void setNgheSyTheHien(String ngheSyTheHien) {
        this.ngheSyTheHien = ngheSyTheHien;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

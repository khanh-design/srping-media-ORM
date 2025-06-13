package com.example.springmediaorm.model;

import org.springframework.web.multipart.MultipartFile;

public class SongerDTO {
    private int ma;

    private String tenBaiHat;
    private String ngheSyTheHien;
    private String theLoai;
    private MultipartFile filePath;

    public SongerDTO() {

    }

    public SongerDTO(int ma, String tenBaiHat, String ngheSyTheHien, String theLoai, MultipartFile filePath) {
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

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }
}

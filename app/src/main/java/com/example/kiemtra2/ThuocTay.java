package com.example.kiemtra2;

public class ThuocTay {
    String tenkhoahoc, tenthuonggoi, dactinh, congdung, lieudung, luuy, hinhanh;
    String idthuoctay;
    public ThuocTay() {}


    public ThuocTay(String tenkhoahoc, String tenthuonggoi, String dactinh, String congdung, String lieudung, String luuy, String hinhanh) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.congdung = congdung;
        this.lieudung = lieudung;
        this.luuy = luuy;
        this.hinhanh = hinhanh;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getLieudung() {
        return lieudung;
    }

    public void setLieudung(String lieudung) {
        this.lieudung = lieudung;
    }

    public String getLuuy() {
        return luuy;
    }

    public void setLuuy(String luuy) {
        this.luuy = luuy;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getIdthuoctay() {
        return idthuoctay;
    }

    public void setIdthuoctay(String idthuoctay) {
        this.idthuoctay = idthuoctay;
    }
}

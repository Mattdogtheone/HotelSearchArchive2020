package com.heroku.szallasportal.entities;

import java.io.Serializable;

public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sza_nev;
    private int iranyitoszam;
    private String varos;
    private String utca;
    private String hazszam;
    private int telefon;
    private String email;
    private int mobil;
    private float ertekeles;
    private String tipus;
    private String sza_url;
    private String letrehozta;
    private int ert_szam;

    public int getErt_szam() {
        return ert_szam;
    }

    public void setErt_szam(int ert_szam) {
        this.ert_szam = ert_szam;
    }

    public String getSza_nev() {
        return sza_nev;
    }

    public void setSza_nev(String sza_nev) {
        this.sza_nev = sza_nev;
    }

    public String getLetrehozta() {
        return letrehozta;
    }

    public void setLetrehozta(String letrehozta) {
        this.letrehozta = letrehozta;
    }

    public int getIranyitoszam() {
        return iranyitoszam;
    }

    public void setIranyitoszam(int iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public String getHazszam() {
        return hazszam;
    }

    public void setHazszam(String hazszam) {
        this.hazszam = hazszam;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobil() {
        return mobil;
    }

    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    public float getErtekeles() {
        return ertekeles;
    }

    public void setErtekeles(float ertekeles) {
        this.ertekeles = ertekeles;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getSza_url() {
        return sza_url;
    }

    public void setSza_url(String sza_url) {
        this.sza_url = sza_url;
    }

    public Hotel(String sza_nev, int iranyitoszam, String varos, String utca, String hazszam, int telefon, String email, int mobil, String tipus, String sza_url, String letrehozta) {
        this.sza_nev = sza_nev;
        this.iranyitoszam = iranyitoszam;
        this.varos = varos;
        this.utca = utca;
        this.hazszam = hazszam;
        this.telefon = telefon;
        this.email = email;
        this.mobil = mobil;
        this.tipus = tipus;
        this.sza_url = sza_url;
        this.letrehozta=letrehozta;
    }
    public  Hotel(){

    }
}

package com.heroku.szallasportal.entities;

import java.io.Serializable;

public class Foglalas implements Serializable{
    private static final long serialVersionUID = 1L;
    private int azon;
    private String felhasznalonev;
    private int szobaszam;
    private String erkezes;
    private String tavozas;
    private String szallodanev;
    private int kapacitas;
    private int arperfo;
    private String agytipus;
    private boolean konyha;
    private int iranyitoszam;
    private String varos;
    private String utca;
    private String hazszam;
    private int telefon;
    private int telefonszam;
    private String email;
    private String sza_url;
    private String url;
    private String keresztnev;
    private String vezeteknev;
    private int va_szobaszam;
    private float ertekeles;
    private int ert_szam;
    private boolean ertekelt;

    public boolean isErtekelt() {
        return ertekelt;
    }

    public void setErtekelt(boolean ertekelt) {
        this.ertekelt = ertekelt;
    }

    public float getErtekeles() {
        return ertekeles;
    }

    public void setErtekeles(float ertekeles) {
        this.ertekeles = ertekeles;
    }

    public int getErt_szam() {
        return ert_szam;
    }

    public void setErt_szam(int ert_szam) {
        this.ert_szam = ert_szam;
    }

    public int getVa_szobaszam() {
        return va_szobaszam;
    }

    public void setVa_szobaszam(int va_szobaszam) {
        this.va_szobaszam = va_szobaszam;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public int getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(int telefonszam) {
        this.telefonszam = telefonszam;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public int getArperfo() {
        return arperfo;
    }

    public void setArperfo(int arperfo) {
        this.arperfo = arperfo;
    }

    public int getAzon() {
        return azon;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public String getSzallodanev() {
        return szallodanev;
    }

    public void setSzallodanev(String szallodanev) {
        this.szallodanev = szallodanev;
    }

    public int getKapacitas() {
        return kapacitas;
    }

    public void setKapacitas(int kapacitas) {
        this.kapacitas = kapacitas;
    }

    public String getAgytipus() {
        return agytipus;
    }

    public void setAgytipus(String agytipus) {
        this.agytipus = agytipus;
    }

    public boolean isKonyha() {
        return konyha;
    }

    public void setKonyha(boolean konyha) {
        this.konyha = konyha;
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

    public String getSza_url() {
        return sza_url;
    }

    public void setSza_url(String sza_url) {
        this.sza_url = sza_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSzobaszam() {
        return szobaszam;
    }

    public String getErkezes() {
        return erkezes;
    }

    public String getTavozas() {
        return tavozas;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }



    public void setSzobaszam(int szobaszam) {
        this.szobaszam = szobaszam;
    }

    public void setErkezes(String erkezes) {
        this.erkezes = erkezes;
    }

    public void setTavozas(String tavozas) {
        this.tavozas = tavozas;
    }

    public Foglalas( String felhasznalonev, int szobaszam, String erkezes, String tavozas) {
        this.felhasznalonev = felhasznalonev;
        this.szobaszam = szobaszam;
        this.erkezes = erkezes;
        this.tavozas = tavozas;
    }

    public Foglalas() {
    }
}

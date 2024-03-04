package com.heroku.szallasportal.entities;

import java.io.Serializable;

public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    private int szobaszam;
    private String szallodanev;
    private int kapacitas;
    private int arperfo;
    private boolean szabad;
    private String agytipus;
    private boolean konyha;
    private String leiras;
    private String url;
    private String varos;
    private int va_szobaszam;
    private float ertekeles;
    private String utca;
    private String sza_url;

    public String getSza_url() {
        return sza_url;
    }

    public void setSza_url(String sza_url) {
        this.sza_url = sza_url;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public float getErtekeles() {
        return ertekeles;
    }

    public void setErtekeles(float ertekeles) {
        this.ertekeles = ertekeles;
    }

    public int getVa_szobaszam() {
        return va_szobaszam;
    }

    public void setVa_szobaszam(int va_szobaszam) {
        this.va_szobaszam = va_szobaszam;
    }

    public int getSzobaszam() {
        return szobaszam;
    }

    public void setSzobaszam(int szobaszam) {
        this.szobaszam = szobaszam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
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

    public int getArperfo() {
        return arperfo;
    }

    public void setArperfo(int arperfo) {
        this.arperfo = arperfo;
    }

    public boolean isSzabad() {
        return szabad;
    }

    public void setSzabad(boolean szabad) {
        this.szabad = szabad;
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

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Room(String szallodanev, int kapacitas, int arperfo, boolean szabad, String agytipus, boolean konyha, String leiras, String url, int va_szobaszam) {
        this.szallodanev = szallodanev;
        this.kapacitas = kapacitas;
        this.arperfo = arperfo;
        this.szabad = szabad;
        this.agytipus = agytipus;
        this.konyha = konyha;
        this.leiras = leiras;
        this.url = url;
        this.va_szobaszam=va_szobaszam;
    }

    public Room(int szobaszam, String szallodanev, int kapacitas, int arperfo, boolean szabad, String agytipus, boolean konyha, String leiras, String url, int va_szobaszam) {
        this.szobaszam = szobaszam;
        this.szallodanev = szallodanev;
        this.kapacitas = kapacitas;
        this.arperfo = arperfo;
        this.szabad = szabad;
        this.agytipus = agytipus;
        this.konyha = konyha;
        this.leiras = leiras;
        this.url = url;
        this.va_szobaszam=va_szobaszam;
    }

    public Room(){

    }
}

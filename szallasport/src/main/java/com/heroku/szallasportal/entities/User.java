package com.heroku.szallasportal.entities;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String keresztnev;
    private String vezeteknev;

    private String felhasznalonev;
    private String email;
    private String jelszo;
    private int telefonszam;
    private int iranyitoszam;
    private String varos;
    private String utca;
    private String hazszam;


    public String getKeresztnev() {
        return keresztnev;
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

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public int getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(int telefonszam) {
        this.telefonszam = telefonszam;
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

    public User(String keresztnev, String vezeteknev, String felhasznalonev, String email, String jelszo, int telefonszam, int iranyitoszam, String varos, String utca, String hazszam) {
        this.keresztnev = keresztnev;
        this.vezeteknev = vezeteknev;
        this.felhasznalonev = felhasznalonev;
        this.email = email;
        this.jelszo = jelszo;
        this.telefonszam = telefonszam;
        this.iranyitoszam = iranyitoszam;
        this.varos = varos;
        this.utca = utca;
        this.hazszam = hazszam;
    }

    public User(){

    }
}

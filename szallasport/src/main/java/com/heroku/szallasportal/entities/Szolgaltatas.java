package com.heroku.szallasportal.entities;

import java.io.Serializable;

public class Szolgaltatas implements Serializable {
    private static final long serialVersionUID = 1L;
    private int azon;
    private String tipus;
    private String szallodanev;
    private int szolg_ar;

    public String getTipus() {
        return tipus;
    }

    public int getAzon() {
        return azon;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getSzallodanev() {
        return szallodanev;
    }

    public void setSzallodanev(String szallodanev) {
        this.szallodanev = szallodanev;
    }

    public int getSzolg_ar() {
        return szolg_ar;
    }

    public void setSzolg_ar(int szolg_ar) {
        this.szolg_ar = szolg_ar;
    }

    public Szolgaltatas( String tipus, String szallodanev, int szolg_ar) {

        this.tipus = tipus;
        this.szallodanev = szallodanev;
        this.szolg_ar = szolg_ar;
    }

    public Szolgaltatas(){

    }
}

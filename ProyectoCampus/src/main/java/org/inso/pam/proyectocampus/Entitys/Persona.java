package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class Persona {
    private int nPerId;
    private String cPerApePat;
    private String cPerApeMat;
    private String cPerNombres;
    private String cPerTipo;

    public Persona() {
    }

    public Persona(String cPerApePat, String cPerApeMat, String cPerNombres, String cPerTipo) {
        this.cPerApePat = cPerApePat;
        this.cPerApeMat = cPerApeMat;
        this.cPerNombres = cPerNombres;
        this.cPerTipo = cPerTipo;
    }

    public Persona(int nPerId, String cPerApePat, String cPerApeMat, String cPerNombres, String cPerTipo) {
        this.nPerId = nPerId;
        this.cPerApePat = cPerApePat;
        this.cPerApeMat = cPerApeMat;
        this.cPerNombres = cPerNombres;
        this.cPerTipo = cPerTipo;
    }

    public int getnPerId() {
        return nPerId;
    }

    public void setnPerId(int nPerId) {
        this.nPerId = nPerId;
    }

    public String getcPerApePat() {
        return cPerApePat;
    }

    public void setcPerApePat(String cPerApePat) {
        this.cPerApePat = cPerApePat;
    }

    public String getcPerApeMat() {
        return cPerApeMat;
    }

    public void setcPerApeMat(String cPerApeMat) {
        this.cPerApeMat = cPerApeMat;
    }

    public String getcPerNombres() {
        return cPerNombres;
    }

    public void setcPerNombres(String cPerNombres) {
        this.cPerNombres = cPerNombres;
    }

    public String getcPerTipo() {
        return cPerTipo;
    }

    public void setcPerTipo(String cPerTipo) {
        this.cPerTipo = cPerTipo;
    }
}

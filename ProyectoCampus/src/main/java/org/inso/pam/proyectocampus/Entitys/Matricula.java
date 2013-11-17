package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class Matricula {
    private int nMatId;
    private int nHorId;
    private int nPerId;
    private int nMatEstado;
    private int nMatTipo;
    private String cMatFecha;

    public Matricula() {
        this.nMatId = 0;
        this.nHorId = 0;
        this.nPerId = 0;
        this.nMatEstado = 0;
        this.nMatTipo = 0;
        this.cMatFecha = "";
    }

    public Matricula(int nHorId, int nPerId, int nMatEstado, int nMatTipo, String cMatFecha) {
        this.nMatId = 0;
        this.nHorId = nHorId;
        this.nPerId = nPerId;
        this.nMatEstado = nMatEstado;
        this.nMatTipo = nMatTipo;
        this.cMatFecha = cMatFecha;
    }

    public Matricula(int nMatId, int nHorId, int nPerId, int nMatEstado, int nMatTipo, String cMatFecha) {
        this.nMatId = nMatId;
        this.nHorId = nHorId;
        this.nPerId = nPerId;
        this.nMatEstado = nMatEstado;
        this.nMatTipo = nMatTipo;
        this.cMatFecha = cMatFecha;
    }

    public int getnMatId() {
        return nMatId;
    }

    public void setnMatId(int nMatId) {
        this.nMatId = nMatId;
    }

    public int getnHorId() {
        return nHorId;
    }

    public void setnHorId(int nHorId) {
        this.nHorId = nHorId;
    }

    public int getnPerId() {
        return nPerId;
    }

    public void setnPerId(int nPerId) {
        this.nPerId = nPerId;
    }

    public int getnMatEstado() {
        return nMatEstado;
    }

    public void setnMatEstado(int nMatEstado) {
        this.nMatEstado = nMatEstado;
    }

    public int getnMatTipo() {
        return nMatTipo;
    }

    public void setnMatTipo(int nMatTipo) {
        this.nMatTipo = nMatTipo;
    }

    public String getcMatFecha() {
        return cMatFecha;
    }

    public void setcMatFecha(String cMatFecha) {
        this.cMatFecha = cMatFecha;
    }
}

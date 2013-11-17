package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class Sesion {
    private int nSesId;
    private int nHorId;
    private String cSesFechaProgramada;
    private String cSesTítulo;
    private int nSesEstado;

    public Sesion() {
        this.nSesId = 0;
        this.nHorId = 0;
        this.cSesFechaProgramada = "";
        this.cSesTítulo = "";
        this.nSesEstado = -1;
    }

    public Sesion(int nHorId, String cSesFechaProgramada, String cSesTítulo, int nSesEstado) {
        this.nSesId = 0;
        this.nHorId = nHorId;
        this.cSesFechaProgramada = cSesFechaProgramada;
        this.cSesTítulo = cSesTítulo;
        this.nSesEstado = nSesEstado;
    }

    public Sesion(int nSesId, int nHorId, String cSesFechaProgramada, String cSesTítulo, int nSesEstado) {
        this.nSesId = nSesId;
        this.nHorId = nHorId;
        this.cSesFechaProgramada = cSesFechaProgramada;
        this.cSesTítulo = cSesTítulo;
        this.nSesEstado = nSesEstado;
    }

    public int getnSesId() {
        return nSesId;
    }

    public void setnSesId(int nSesId) {
        this.nSesId = nSesId;
    }

    public int getnHorId() {
        return nHorId;
    }

    public void setnHorId(int nHorId) {
        this.nHorId = nHorId;
    }

    public String getcSesFechaProgramada() {
        return cSesFechaProgramada;
    }

    public void setcSesFechaProgramada(String cSesFechaProgramada) {
        this.cSesFechaProgramada = cSesFechaProgramada;
    }

    public String getcSesTítulo() {
        return cSesTítulo;
    }

    public void setcSesTítulo(String cSesTítulo) {
        this.cSesTítulo = cSesTítulo;
    }

    public int getnSesEstado() {
        return nSesEstado;
    }

    public void setnSesEstado(int nSesEstado) {
        this.nSesEstado = nSesEstado;
    }
}

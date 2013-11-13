package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 9/11/13.
 */
public class Nota {
    private int nNotaId;
    private int nMatId;
    private int nSesId;
    private String cNotFecha;
    private String cNotValor;

    public Nota() {
    }

    public Nota(int nMatId, int nSesId, String cNotFecha, String cNotValor) {
        this.nMatId = nMatId;
        this.nSesId = nSesId;
        this.cNotFecha = cNotFecha;
        this.cNotValor = cNotValor;
    }

    public Nota(int nNotaId, int nMatId, int nSesId, String cNotFecha, String cNotValor) {
        this.nNotaId = nNotaId;
        this.nMatId = nMatId;
        this.nSesId = nSesId;
        this.cNotFecha = cNotFecha;
        this.cNotValor = cNotValor;
    }

    public int getnNotaId() {
        return nNotaId;
    }

    public void setnNotaId(int nNotaId) {
        this.nNotaId = nNotaId;
    }

    public int getnMatId() {
        return nMatId;
    }

    public void setnMatId(int nMadId) {
        this.nMatId = nMatId;
    }

    public int getnSesId() {
        return nSesId;
    }

    public void setnSesId(int nSesId) {
        this.nSesId = nSesId;
    }

    public String getcNotFecha() {
        return cNotFecha;
    }

    public void setcNotFecha(String cNotFecha) {
        this.cNotFecha = cNotFecha;
    }

    public String getcNotValor() {
        return cNotValor;
    }

    public void setcNotValor(String cNotValor) {
        this.cNotValor = cNotValor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nNotaId=" + nNotaId +
                ", nMatId=" + nMatId +
                ", nSesId=" + nSesId +
                ", cNotFecha='" + cNotFecha + '\'' +
                ", cNotValor='" + cNotValor + '\'' +
                '}';
    }
}

package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class Asistencia {
    private int nAsiId;
    private int nMatId;
    private int nSesId;
    private String cAsiFecha;
    private String cAsiValor;

    public Asistencia(int nMatId, int nSesId, String cAsiFecha, String cAsiValor) {
        this.nAsiId = 0;
        this.nMatId = nMatId;
        this.nSesId = nSesId;
        this.cAsiFecha = cAsiFecha;
        this.cAsiValor = cAsiValor;
    }

    public Asistencia(int nAsiId, int nMatId, int nSesId, String cAsiFecha, String cAsiValor) {
        this.nAsiId = nAsiId;
        this.nMatId = nMatId;
        this.nSesId = nSesId;
        this.cAsiFecha = cAsiFecha;
        this.cAsiValor = cAsiValor;
    }

    public Asistencia() {
        this.nAsiId = 0;
        this.nMatId = 0;
        this.nSesId = 0;
        this.cAsiFecha = "";
        this.cAsiValor = "";
    }

    public int getnAsiId() {
        return nAsiId;
    }

    public void setnAsiId(int nAsiId) {
        this.nAsiId = nAsiId;
    }

    public int getnMatId() {
        return nMatId;
    }

    public void setnMatId(int nMatId) {
        this.nMatId = nMatId;
    }

    public int getnSesId() {
        return nSesId;
    }

    public void setnSesId(int nSesId) {
        this.nSesId = nSesId;
    }

    public String getcAsiFecha() {
        return cAsiFecha;
    }

    public void setcAsiFecha(String cAsiFecha) {
        this.cAsiFecha = cAsiFecha;
    }

    public String getcAsiValor() {
        return cAsiValor;
    }

    public void setcAsiValor(String cAsiValor) {
        this.cAsiValor = cAsiValor;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "nAsiId=" + nAsiId +
                ", nMatId=" + nMatId +
                ", nSesId=" + nSesId +
                ", cAsiFecha='" + cAsiFecha + '\'' +
                ", cAsiValor='" + cAsiValor + '\'' +
                '}';
    }
}

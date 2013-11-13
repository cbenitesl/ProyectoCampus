package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class Curso {
    private int nCurId;
    private String cCurNombre;
    private String cCurTipo;
    private int nCurEstado;

    public Curso() {
    }

    public Curso(String cCurNombre, String cCurTipo, int nCurEstado) {
        this.cCurNombre = cCurNombre;
        this.cCurTipo = cCurTipo;
        this.nCurEstado = nCurEstado;
        this.nCurId = 0;
    }

    public Curso(int nCurId, String cCurNombre, String cCurTipo, int nCurEstado) {
        this.nCurId = nCurId;
        this.cCurNombre = cCurNombre;
        this.cCurTipo = cCurTipo;
        this.nCurEstado = nCurEstado;
    }

    public int getnCurId() {
        return nCurId;
    }

    public void setnCurId(int nCurId) {
        this.nCurId = nCurId;
    }

    public String getcCurNombre() {
        return cCurNombre;
    }

    public void setcCurNombre(String cCurNombre) {
        this.cCurNombre = cCurNombre;
    }

    public String getcCurTipo() {
        return cCurTipo;
    }

    public void setcCurTipo(String cCurTipo) {
        this.cCurTipo = cCurTipo;
    }

    public int getnCurEstado() {
        return nCurEstado;
    }

    public void setnCurEstado(int nCurEstado) {
        this.nCurEstado = nCurEstado;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nCurId=" + nCurId +
                ", cCurNombre='" + cCurNombre + '\'' +
                ", cCurTipo='" + cCurTipo + '\'' +
                ", nCurEstado=" + nCurEstado +
                '}';
    }
}

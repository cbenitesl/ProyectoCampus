package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 10/11/13.
 */
public class MaterialCurso {
    private int nMcuId;
    private int nSesId;
    private String cMcuTipo;
    private String cMcuUbicacion;

    public MaterialCurso() {
    }

    public MaterialCurso(int nSesId, String cMcuTipo, String cMcuUbicacion) {
        this.nSesId = nSesId;
        this.cMcuTipo = cMcuTipo;
        this.cMcuUbicacion = cMcuUbicacion;
    }

    public MaterialCurso(int nMcuId, int nSesId, String cMcuTipo, String cMcuUbicacion) {
        this.nMcuId = nMcuId;
        this.nSesId = nSesId;
        this.cMcuTipo = cMcuTipo;
        this.cMcuUbicacion = cMcuUbicacion;
    }

    public int getnMcuId() {
        return nMcuId;
    }

    public void setnMcuId(int nMcuId) {
        this.nMcuId = nMcuId;
    }

    public int getnSesId() {
        return nSesId;
    }

    public void setnSesId(int nSesId) {
        this.nSesId = nSesId;
    }

    public String getcMcuTipo() {
        return cMcuTipo;
    }

    public void setcMcuTipo(String cMcuTipo) {
        this.cMcuTipo = cMcuTipo;
    }

    public String getcMcuUbicacion() {
        return cMcuUbicacion;
    }

    public void setcMcuUbicacion(String cMcuUbicacion) {
        this.cMcuUbicacion = cMcuUbicacion;
    }
}

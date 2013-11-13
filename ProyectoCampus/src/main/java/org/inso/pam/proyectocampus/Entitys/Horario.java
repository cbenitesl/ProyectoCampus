package org.inso.pam.proyectocampus.Entitys;

/**
 * Created by Christian on 7/11/13.
 */
public class Horario {
    private int nHorId;
    private int cDocNombe;
    private int nCurId;
    private String cHorDias;
    private String cHorHoraInicio;
    private String cHorFechaInicio;
    private String cHorAmbiente;
    private String cHorHoraFin;
    private String cHorFechaFin;

    public Horario(int cDocNombe, int nCurId, String cHorDias, String cHorHoraInicio, String cHorFechaInicio, String cHorAmbiente, String cHorHoraFin, String cHorFechaFin) {
        this.nHorId = 0;
        this.cDocNombe = cDocNombe;
        this.nCurId = nCurId;
        this.cHorDias = cHorDias;
        this.cHorHoraInicio = cHorHoraInicio;
        this.cHorFechaInicio = cHorFechaInicio;
        this.cHorAmbiente = cHorAmbiente;
        this.cHorHoraFin = cHorHoraFin;
        this.cHorFechaFin = cHorFechaFin;
    }

    public Horario(int nHorId, int cDocNombe, int nCurId, String cHorDias, String cHorHoraInicio, String cHorFechaInicio, String cHorAmbiente, String cHorHoraFin, String cHorFechaFin) {
        this.nHorId = nHorId;
        this.cDocNombe = cDocNombe;
        this.nCurId = nCurId;
        this.cHorDias = cHorDias;
        this.cHorHoraInicio = cHorHoraInicio;
        this.cHorFechaInicio = cHorFechaInicio;
        this.cHorAmbiente = cHorAmbiente;
        this.cHorHoraFin = cHorHoraFin;
        this.cHorFechaFin = cHorFechaFin;
    }

    public int getnHorId() {
        return nHorId;
    }

    public void setnHorId(int nHorId) {
        this.nHorId = nHorId;
    }

    public int getcDocNombe() {
        return cDocNombe;
    }

    public void setcDocNombe(int cDocNombe) {
        this.cDocNombe = cDocNombe;
    }

    public int getnCurId() {
        return nCurId;
    }

    public void setnCurId(int nCurId) {
        this.nCurId = nCurId;
    }

    public String getcHorDias() {
        return cHorDias;
    }

    public void setcHorDias(String cHorDias) {
        this.cHorDias = cHorDias;
    }

    public String getcHorHoraInicio() {
        return cHorHoraInicio;
    }

    public void setcHorHoraInicio(String cHorHoraInicio) {
        this.cHorHoraInicio = cHorHoraInicio;
    }

    public String getcHorFechaInicio() {
        return cHorFechaInicio;
    }

    public void setcHorFechaInicio(String cHorFechaInicio) {
        this.cHorFechaInicio = cHorFechaInicio;
    }

    public String getcHorAmbiente() {
        return cHorAmbiente;
    }

    public void setcHorAmbiente(String cHorAmbiente) {
        this.cHorAmbiente = cHorAmbiente;
    }

    public String getcHorHoraFin() {
        return cHorHoraFin;
    }

    public void setcHorHoraFin(String cHorHoraFin) {
        this.cHorHoraFin = cHorHoraFin;
    }

    public String getcHorFechaFin() {
        return cHorFechaFin;
    }

    public void setcHorFechaFin(String cHorFechaFin) {
        this.cHorFechaFin = cHorFechaFin;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "nHorId=" + nHorId +
                ", cDocNombe=" + cDocNombe +
                ", nCurId=" + nCurId +
                ", cHorDias='" + cHorDias + '\'' +
                ", cHorHoraInicio='" + cHorHoraInicio + '\'' +
                ", cHorFechaInicio='" + cHorFechaInicio + '\'' +
                ", cHorAmbiente='" + cHorAmbiente + '\'' +
                ", cHorHoraFin='" + cHorHoraFin + '\'' +
                ", cHorFechaFin='" + cHorFechaFin + '\'' +
                '}';
    }
}

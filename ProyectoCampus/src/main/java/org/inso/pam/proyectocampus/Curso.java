package org.inso.pam.proyectocampus;

/**
 * Created by Christian on 30/10/13.
 */
public class Curso {
    private Long id;
    private String nombre;
    private String dia;
    private String horaI;
    private String horaF;

    public Curso() {
        new Curso("","","","");
    }

    public Curso(String nombre, String dia, String horaI, String horaF) {
        id = null;
        this.nombre = nombre;
        this.dia = dia;
        this.horaI = horaI;
        this.horaF = horaF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }
}

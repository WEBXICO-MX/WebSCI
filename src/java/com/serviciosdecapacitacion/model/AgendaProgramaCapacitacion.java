/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.sql.Timestamp;

public class AgendaProgramaCapacitacion {

    private int cve_agenda;
    private ProgramaCapacitacion cve_programa_capacitacion;
    private Timestamp fecha_inicio;
    private Timestamp fecha_fin;
    private String horario;
    private int duracion_horas;
    private Persona instructor;
    private Timestamp fecha_registro;
    private boolean activo;

    public AgendaProgramaCapacitacion() {
        this.cve_agenda = 0;
        this.cve_programa_capacitacion = null;
        this.fecha_inicio = null;
        this.fecha_fin = null;
        this.horario = "";
        this.duracion_horas = 0;
        this.instructor = null;
        this.activo = false;
    }

    public AgendaProgramaCapacitacion(int cve_agenda, ProgramaCapacitacion cve_programa_capacitacion, Timestamp fecha_inicio, Timestamp fecha_fin, String horario, int duracion_horas, Persona instructor, Timestamp fecha_registro, boolean activo) {
        this.cve_agenda = cve_agenda;
        this.cve_programa_capacitacion = cve_programa_capacitacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horario = horario;
        this.duracion_horas = duracion_horas;
        this.instructor = instructor;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getCve_agenda() {
        return cve_agenda;
    }

    public void setCve_agenda(int cve_agenda) {
        this.cve_agenda = cve_agenda;
    }

    public ProgramaCapacitacion getCve_programa_capacitacion() {
        return cve_programa_capacitacion;
    }

    public void setCve_programa_capacitacion(ProgramaCapacitacion cve_programa_capacitacion) {
        this.cve_programa_capacitacion = cve_programa_capacitacion;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracion_horas() {
        return duracion_horas;
    }

    public void setDuracion_horas(int duracion_horas) {
        this.duracion_horas = duracion_horas;
    }

    public Persona getInstructor() {
        return instructor;
    }

    public void setInstructor(Persona instructor) {
        this.instructor = instructor;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "AgendaProgramaCapacitacion{" + "cve_agenda=" + cve_agenda + ", cve_programa_capacitacion=" + cve_programa_capacitacion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", horario=" + horario + ", duracion_horas=" + duracion_horas + ", instructor=" + instructor + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}

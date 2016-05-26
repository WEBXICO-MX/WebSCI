/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RegistroParticipante implements Serializable {

    private int cve_registro;
    private Persona participante;
    private AgendaProgramaCapacitacion cve_agenda;
    private Timestamp fecha_registro;

    public RegistroParticipante() {
    }

    public RegistroParticipante(int cve_registro, Persona participante, AgendaProgramaCapacitacion cve_agenda, Timestamp fecha_registro) {
        this.cve_registro = cve_registro;
        this.participante = participante;
        this.cve_agenda = cve_agenda;
        this.fecha_registro = fecha_registro;
    }

    public int getCve_registro() {
        return cve_registro;
    }

    public void setCve_registro(int cve_registro) {
        this.cve_registro = cve_registro;
    }

    public Persona getParticipante() {
        return participante;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }

    public AgendaProgramaCapacitacion getCve_agenda() {
        return cve_agenda;
    }

    public void setCve_agenda(AgendaProgramaCapacitacion cve_agenda) {
        this.cve_agenda = cve_agenda;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "RegistroParticipante{" + "cve_registro=" + cve_registro + ", participante=" + participante + ", cve_agenda=" + cve_agenda + ", fecha_registro=" + fecha_registro + '}';
    }

}

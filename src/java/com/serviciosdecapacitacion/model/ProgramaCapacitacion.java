/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProgramaCapacitacion implements Serializable {

    private int cve_programa_capacitacion;
    private String nombre_curso;
    private AreaTematica area_tematica;
    private Timestamp fecha_registro;
    private boolean activo;

    public ProgramaCapacitacion() {
        this.cve_programa_capacitacion = 0;
        this.nombre_curso = "";
        this.area_tematica = null;
        this.fecha_registro = null;
        this.activo = false;
    }

    public ProgramaCapacitacion(int cve_programa_capacitacion, String nombre_curso, AreaTematica area_tematica, Timestamp fecha_registro, boolean activo) {
        this.cve_programa_capacitacion = cve_programa_capacitacion;
        this.nombre_curso = nombre_curso;
        this.area_tematica = area_tematica;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getCve_programa_capacitacion() {
        return cve_programa_capacitacion;
    }

    public void setCve_programa_capacitacion(int cve_programa_capacitacion) {
        this.cve_programa_capacitacion = cve_programa_capacitacion;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public AreaTematica getArea_tematica() {
        return area_tematica;
    }

    public void setArea_tematica(AreaTematica area_tematica) {
        this.area_tematica = area_tematica;
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
        return "ProgramaCapacitacion{" + "cve_programa_capacitacion=" + cve_programa_capacitacion + ", nombre_curso=" + nombre_curso + ", area_tematica=" + area_tematica + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

}

/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;

public class AreaOcupacion implements Serializable {

    private int cve_area_ocupacion;
    private String clave_area_subarea;
    private String nombre;
    private boolean activo;

    public AreaOcupacion() {
        this.cve_area_ocupacion = 0;
        this.clave_area_subarea = "";
        this.nombre = "";
        this.activo = false;
    }

    public AreaOcupacion(int cve_area_ocupacion, String clave_area_subarea, String nombre, boolean activo) {
        this.cve_area_ocupacion = cve_area_ocupacion;
        this.clave_area_subarea = clave_area_subarea;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getCve_area_ocupacion() {
        return cve_area_ocupacion;
    }

    public void setCve_area_ocupacion(int cve_area_ocupacion) {
        this.cve_area_ocupacion = cve_area_ocupacion;
    }

    public String getClave_area_subarea() {
        return clave_area_subarea;
    }

    public void setClave_area_subarea(String clave_area_subarea) {
        this.clave_area_subarea = clave_area_subarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "AreaOcupacion{" + "cve_area_ocupacion=" + cve_area_ocupacion + ", clave_area_subarea=" + clave_area_subarea + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

}

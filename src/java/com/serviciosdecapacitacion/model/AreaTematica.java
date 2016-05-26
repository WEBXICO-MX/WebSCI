/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;

public class AreaTematica implements Serializable {

    private int cve_area_tematica;
    private String clave_del_area;
    private String nombre;
    private boolean activo;

    public AreaTematica() {
        this.cve_area_tematica = 0;
        this.clave_del_area = "";
        this.nombre = "";
        this.activo = false;
    }

    public AreaTematica(int cve_area_tematica, String clave_del_area, String nombre, boolean activo) {
        this.cve_area_tematica = cve_area_tematica;
        this.clave_del_area = clave_del_area;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getCve_area_tematica() {
        return cve_area_tematica;
    }

    public void setCve_area_tematica(int cve_area_tematica) {
        this.cve_area_tematica = cve_area_tematica;
    }

    public String getClave_del_area() {
        return clave_del_area;
    }

    public void setClave_del_area(String clave_del_area) {
        this.clave_del_area = clave_del_area;
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
        return "AreaTematica{" + "cve_area_tematica=" + cve_area_tematica + ", clave_del_area=" + clave_del_area + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

}

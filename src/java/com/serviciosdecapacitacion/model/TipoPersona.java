/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;

public class TipoPersona implements Serializable {

    private int cve_tipo;
    private String nombre;
    private boolean activo;

    public TipoPersona() {
        this.cve_tipo = 0;
        this.nombre = "";
        this.activo = false;
    }

    public TipoPersona(int cve_tipo, String nombre, boolean activo) {
        this.cve_tipo = cve_tipo;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getCve_tipo() {
        return cve_tipo;
    }

    public void setCve_tipo(int cve_tipo) {
        this.cve_tipo = cve_tipo;
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
        return "TipoPersona{" + "cve_tipo=" + cve_tipo + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

}

/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;

public class Empresa implements Serializable {

    private int cve_empresa;
    private String nombre_empresa;
    private String razon_social;
    private String rfc;
    private boolean activo;

    public Empresa() {
        this.cve_empresa = 0;
        this.nombre_empresa = "";
        this.razon_social = "";
        this.rfc = "";
        this.activo = false;
    }

    public Empresa(int cve_empresa) {
        this.cve_empresa = cve_empresa;
        this.nombre_empresa = "";
        this.razon_social = "";
        this.rfc = "";
        this.activo = false;
    }

    public Empresa(int cve_empresa, String nombre_empresa, String razon_social, String rfc, boolean activo) {
        this.cve_empresa = cve_empresa;
        this.nombre_empresa = nombre_empresa;
        this.razon_social = razon_social;
        this.rfc = rfc;
        this.activo = activo;
    }

    public int getCve_empresa() {
        return cve_empresa;
    }

    public void setCve_empresa(int cve_empresa) {
        this.cve_empresa = cve_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cve_empresa=" + cve_empresa + ", nombre_empresa=" + nombre_empresa + ", razon_social=" + razon_social + ", rfc=" + rfc + ", activo=" + activo + '}';
    }

}

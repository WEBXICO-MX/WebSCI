/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Persona implements Serializable {

    private int cve_persona;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String rfc;
    private String curp;
    private AreaOcupacion ocuapacion_especifica;
    private String puesto;
    private TipoPersona tipo;
    private Timestamp fecha_nacimiento;
    private Timestamp fecha_registro;
    private String ruta_img;
    private boolean activo;

    public Persona() {
        this.cve_persona = 0;
        this.nombre = "";
        this.ap_paterno = "";
        this.ap_materno = "";
        this.rfc = "";
        this.curp = "";
        this.ocuapacion_especifica = null;
        this.puesto = "";
        this.tipo = null;
        this.fecha_nacimiento = null;
        this.fecha_registro = null;
        this.ruta_img = "";
        this.activo = false;
    }

    public Persona(int cve_persona) {
        this.cve_persona = cve_persona;
    }

    public Persona(int cve_persona, String nombre, String ap_paterno, String ap_materno, String rfc, String curp, AreaOcupacion ocuapacion_especifica, String puesto, TipoPersona tipo, Timestamp fecha_nacimiento, Timestamp fecha_registro, String ruta_img, boolean activo) {
        this.cve_persona = cve_persona;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.rfc = rfc;
        this.curp = curp;
        this.ocuapacion_especifica = ocuapacion_especifica;
        this.puesto = puesto;
        this.tipo = tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_registro = fecha_registro;
        this.ruta_img = ruta_img;
        this.activo = activo;
    }

    public int getCve_persona() {
        return cve_persona;
    }

    public void setCve_persona(int cve_persona) {
        this.cve_persona = cve_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public AreaOcupacion getOcuapacion_especifica() {
        return ocuapacion_especifica;
    }

    public void setOcuapacion_especifica(AreaOcupacion ocuapacion_especifica) {
        this.ocuapacion_especifica = ocuapacion_especifica;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

    public Timestamp getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Timestamp fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Persona{" + "cve_persona=" + cve_persona + ", nombre=" + nombre + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", rfc=" + rfc + ", curp=" + curp + ", ocuapacion_especifica=" + ocuapacion_especifica + ", puesto=" + puesto + ", tipo=" + tipo + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_registro=" + fecha_registro + ", ruta_img=" + ruta_img + ", activo=" + activo + '}';
    }

}

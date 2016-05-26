/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.AreaOcupacion;
import com.serviciosdecapacitacion.model.AreaTematica;
import com.serviciosdecapacitacion.model.Persona;
import com.serviciosdecapacitacion.model.ProgramaCapacitacion;
import com.serviciosdecapacitacion.model.TipoPersona;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UsingDAOandDAOFactory {

    public static void main(String args[]) throws ParseException {
        // create the required DAO Factory
        TipoPersonaDAO dao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getTipoPersonaDAO();
        AreaOcupacionDAO dao2 = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaOcupacionDAO();
        AreaTematicaDAO dao3 = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaTematicaDAO();
        ProgramaCapacitacionDAO dao5= DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getProgramaCapacitacionDAO();
        PersonaDAO dao4 = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getPersonaDAO();

        /*AreaTematica at = dao3.findById(1);
        ProgramaCapacitacion programa = new ProgramaCapacitacion();
        //programa.setCve_programa_capacitacion(1);
        programa.setNombre_curso("Manejo de montacargas I");
        programa.setArea_tematica(at);
        programa.setFecha_registro(new Timestamp(new Date().getTime()));
        programa.setActivo(true);
        dao5.saveOrUpdate(programa);*/
        
        
        /*AreaOcupacion ao = dao2.findById(1);
        TipoPersona tipo = dao.findById(2);
        Persona p = new Persona();
        //p.setCve_persona(1);
        p.setNombre("Edith Valeria");
        p.setAp_paterno("Weiss");
        p.setAp_materno("Robles");
        p.setRfc("WWWWWWWWWWWWW");
        p.setCurp("XXXXXXXXXXXXXXXXXX");
        p.setOcuapacion_especifica(ao);
        p.setPuesto("Web Programmer");
        p.setTipo(tipo);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        java.util.Date date = sdf.parse("2013-08-08 00:00:00.000");
        
        p.setFecha_nacimiento(new Timestamp(date.getTime()));
        p.setFecha_registro(new Timestamp(new Date().getTime()));
        p.setRuta_img(null);
        p.setActivo(true);
        dao4.saveOrUpdate(p);*/
        
        
        
        
        /*AreaTematica areat1 = new AreaTematica();
        //areao1.setCve_area_ocupacion(1);
        areat1.setNombre("Producción general");
        areat1.setClave_del_area("1000");
        areat1.setActivo(true);
        
        dao3.saveOrUpdate(areat1);
        
        AreaTematica areat2 = new AreaTematica();
        //areat2.setCve_area_ocupacion(2);
        areat2.setNombre("Servicios");
        areat2.setClave_del_area("2000");
        areat2.setActivo(true);
        
        dao3.saveOrUpdate(areat2);*/
        
        
        
        
        /*AreaOcupacion areao1 = new AreaOcupacion();
        //areao1.setCve_area_ocupacion(1);
        areao1.setNombre("Cultivo, crianza y aprovechamiento");
        areao1.setClave_area_subarea("01");
        areao1.setActivo(true);
        
        dao2.saveOrUpdate(areao1);
        
        AreaOcupacion areao2 = new AreaOcupacion();
        //areao2.setCve_area_ocupacion(2);
        areao2.setNombre("Agricultura y silvicultura");
        areao2.setClave_area_subarea("01.1");
        areao2.setActivo(true);
        
        dao2.saveOrUpdate(areao2);*/
        
        
         /*List<AreaOcupacion> areas = dao2.findAll();
         for (AreaOcupacion area : areas) {
         System.out.println(area);
         }*/
        
        /*AreaOcupacion area = dao2.findById(1);
         System.out.println(area);*/

        
        
        

        
         /*TipoPersona tipo = new TipoPersona();
         tipo.setNombre("Participante curso");
         tipo.setActivo(true);
         dao.saveOrUpdate(tipo);
        
         TipoPersona tipo2 = new TipoPersona();
         tipo2.setNombre("Instructor");
         tipo2.setActivo(true);
         dao.saveOrUpdate(tipo2);*/
         
        /*TipoPersona tipo = new TipoPersona();
         tipo.setCve_tipo(1);
         tipo.setNombre("Cliente WEBXICO");
         tipo.setActivo(true);
         dao.saveOrUpdate(tipo);
        
         TipoPersona tipo2 = new TipoPersona();
         tipo2.setCve_tipo(2);
         tipo2.setNombre("Instructor WEBXICO");
         tipo2.setActivo(true);
         dao.saveOrUpdate(tipo2);*/
        /*dao.delete(1);
         dao.delete(2);
         dao.delete(3);*/
        /*
         List<TipoPersona> tipos = dao.findAll();
         for (TipoPersona tipo : tipos) {
         System.out.println(tipo);
         }*/
        /*TipoPersona tipo = dao.findById(4);
         System.out.println(tipo);
        
         TipoPersona tipo2 = dao.findById(5);
         System.out.println(tipo2);*/
    }
}

/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.dao.mssqlserver.MSSQLSERVERDAOFactory;

public abstract class DAOFactory {

    public static final int MSSQLSERVER = 1;

    public abstract TipoPersonaDAO getTipoPersonaDAO();

    public abstract AreaOcupacionDAO getAreaOcupacionDAO();

    public abstract AreaTematicaDAO getAreaTematicaDAO();

    public abstract ProgramaCapacitacionDAO getProgramaCapacitacionDAO();
    
    public abstract PersonaDAO getPersonaDAO();
    
    public abstract AgendaProgramaCapacitacionDAO getAgendaProgramaCapacitacionDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {

            case MSSQLSERVER:
                return new MSSQLSERVERDAOFactory();
            default:
                return null;
        }
    }
}

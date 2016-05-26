/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AgendaProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.dao.AreaOcupacionDAO;
import com.serviciosdecapacitacion.dao.AreaTematicaDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.PersonaDAO;
import com.serviciosdecapacitacion.dao.ProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.dao.TipoPersonaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLSERVERDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DBURL = "jdbc:sqlserver://localhost:1433;databaseName=SCI;user=appSCI;password=M@rvel87;";
    static Connection con;

    // method to create Cloudscape connections
    public static Connection createConnection() {
        // Use DRIVER and DBURL to create a connection
        // Recommend connection pool implementation/usage
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DBURL);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
            //e.printStackTrace();
        }
        return con;

    }

    @Override
    public TipoPersonaDAO getTipoPersonaDAO() {
        return new MSSQLSERVERTipoPersonaDAO();
    }

    @Override
    public AreaOcupacionDAO getAreaOcupacionDAO() {
        return new MSSQLSERVERAreaOcupacionDAO();
    }

    @Override
    public AreaTematicaDAO getAreaTematicaDAO() {
        return new MSSQLSERVERAreaTematicaDAO();
    }

    @Override
    public ProgramaCapacitacionDAO getProgramaCapacitacionDAO() {
        return new MSSQLSERVERProgramaCapacitacionDAO();
    }

    @Override
    public PersonaDAO getPersonaDAO() {
        return new MSSQLSERVERPersonaDAO();
    }

    @Override
    public AgendaProgramaCapacitacionDAO getAgendaProgramaCapacitacionDAO() {
         return new MSSQLSERVERAgendaProgramaCapacitacionDAO();
    }

}

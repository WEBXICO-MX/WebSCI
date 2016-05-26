/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AreaTematicaDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.ProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.model.ProgramaCapacitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERProgramaCapacitacionDAO implements ProgramaCapacitacionDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;
    AreaTematicaDAO atdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaTematicaDAO();

    @Override
    public boolean saveOrUpdate(ProgramaCapacitacion programa) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO programas_capacitacion (nombre_curso,area_tematica,fecha_registro,activo) VALUES(?,?,?,?)";
        String SQL_UPDATE = "UPDATE programas_capacitacion SET nombre_curso = ?, area_tematica = ?,activo = ? WHERE cve_programa_capacitacion = ?";

        try {
            if (programa.getCve_programa_capacitacion() == 0) {
                ps = cnx.prepareStatement(SQL_INSERT);
                System.out.println(SQL_INSERT);
                ps.setString(1, programa.getNombre_curso());
                ps.setInt(2, programa.getArea_tematica().getCve_area_tematica());
                ps.setTimestamp(3, programa.getFecha_registro());
                ps.setBoolean(4, programa.isActivo());
            } else {
                ps = cnx.prepareStatement(SQL_UPDATE);
                System.out.println(SQL_UPDATE);
                ps.setString(1, programa.getNombre_curso());
                ps.setInt(2, programa.getArea_tematica().getCve_area_tematica());
                //ps.setTimestamp(3, programa.getFecha_registro());
                ps.setBoolean(3, programa.isActivo());
                ps.setInt(4, programa.getCve_programa_capacitacion());
            }

            // execute insert SQL stetement
            int rows = ps.executeUpdate();

            if (rows != 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return success;

    }

    @Override
    public List<ProgramaCapacitacion> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        ProgramaCapacitacion programa = null;
        List programas = new ArrayList();
        String SQL_SELECT = "SELECT * FROM programas_capacitacion";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                programa = new ProgramaCapacitacion();
                programa.setCve_programa_capacitacion(rst.getInt("cve_programa_capacitacion"));
                programa.setNombre_curso(rst.getString("nombre_curso"));
                programa.setArea_tematica(atdao.findById(rst.getInt("area_tematica")));
                programa.setFecha_registro(rst.getTimestamp("fecha_registro"));
                programa.setActivo(rst.getBoolean("activo"));
                programas.add(programa);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return programas;
    }

    @Override
    public ProgramaCapacitacion findById(int cve_programa_capacitacion) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        ProgramaCapacitacion programa = null;
        String SQL_SELECT = "SELECT * FROM programas_capacitacion WHERE cve_programa_capacitacion = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_programa_capacitacion);
            rst = ps.executeQuery();

            while (rst.next()) {
                programa = new ProgramaCapacitacion();
                programa.setCve_programa_capacitacion(rst.getInt("cve_programa_capacitacion"));
                programa.setNombre_curso(rst.getString("nombre_curso"));
                programa.setArea_tematica(atdao.findById(rst.getInt("area_tematica")));
                programa.setFecha_registro(rst.getTimestamp("fecha_registro"));
                programa.setActivo(rst.getBoolean("activo"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return programa;
    }

    @Override
    public boolean delete(int cve_programa_capacitacion) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM programas_capacitacion WHERE cve_programa_capacitacion = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_programa_capacitacion);
            int rows = ps.executeUpdate();
            if (rows != 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return success;
    }

}

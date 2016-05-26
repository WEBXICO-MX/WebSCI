/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AgendaProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.PersonaDAO;
import com.serviciosdecapacitacion.dao.ProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.model.AgendaProgramaCapacitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERAgendaProgramaCapacitacionDAO implements AgendaProgramaCapacitacionDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;
    AgendaProgramaCapacitacion agenda = null;
    List agendas = new ArrayList();
    String SQL_INSERT = "";
    String SQL_UPDATE = "";
    String SQL_SELECT = "";
    String SQL_DELETE = "";
    ProgramaCapacitacionDAO pcdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getProgramaCapacitacionDAO();
    PersonaDAO pdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getPersonaDAO();

    @Override
    public boolean saveOrUpdate(AgendaProgramaCapacitacion agenda) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        SQL_INSERT = "INSERT INTO agendas_programas_capacitacion (cve_programa_capacitacion,fecha_inicio,fecha_fin,horario,duracion_horas,instructor,fecha_registro,activo) VALUES(?,?,?,?,?,?,?)";
        SQL_UPDATE = "UPDATE agendas_programas_capacitacion SET cve_programa_capacitacion= ?,fecha_inicio = ?, fecha_fin = ?,horario = ?,duracion_horas = ?,instructor = ?,activo = ? WHERE cve_agenda = ? and cve_programa_capacitacion = ?";

        try {
            if (agenda.getCve_agenda() == 0) {
                ps = cnx.prepareStatement(SQL_INSERT);
                System.out.println(SQL_INSERT);
                ps.setInt(1, agenda.getCve_programa_capacitacion().getCve_programa_capacitacion());
                ps.setTimestamp(2, agenda.getFecha_inicio());
                ps.setTimestamp(3, agenda.getFecha_fin());
                ps.setString(4, agenda.getHorario());
                ps.setInt(5, agenda.getDuracion_horas());
                ps.setInt(6, agenda.getInstructor().getCve_persona());
                ps.setTimestamp(7, agenda.getFecha_registro());
                ps.setBoolean(8, agenda.isActivo());

            } else {
                ps = cnx.prepareStatement(SQL_UPDATE);
                System.out.println(SQL_UPDATE);
                ps.setInt(1, agenda.getCve_programa_capacitacion().getCve_programa_capacitacion());
                ps.setTimestamp(2, agenda.getFecha_inicio());
                ps.setTimestamp(3, agenda.getFecha_fin());
                ps.setString(4, agenda.getHorario());
                ps.setInt(5, agenda.getDuracion_horas());
                ps.setInt(6, agenda.getInstructor().getCve_persona());
                ps.setBoolean(7, agenda.isActivo());
                ps.setInt(8, agenda.getCve_agenda());
                ps.setInt(9, agenda.getCve_programa_capacitacion().getCve_programa_capacitacion());

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
    public List<AgendaProgramaCapacitacion> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        SQL_SELECT = "SELECT * FROM agendas_programas_capacitacion";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                agenda = new AgendaProgramaCapacitacion();
                agenda.setCve_agenda(rst.getInt("cve_agenda"));
                agenda.setCve_programa_capacitacion(pcdao.findById(rst.getInt("cve_programa_capacitacion")));
                agenda.setFecha_inicio(rst.getTimestamp("fecha_inicio"));
                agenda.setFecha_fin(rst.getTimestamp("fecha_fin"));
                agenda.setHorario(rst.getString("horario"));
                agenda.setDuracion_horas(rst.getInt("duracion_horas"));
                agenda.setInstructor(pdao.findById(rst.getInt("instructor")));
                agenda.setFecha_registro(rst.getTimestamp("fecha_registro"));
                agenda.setActivo(rst.getBoolean("activo"));
                agendas.add(agenda);
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
        return agendas;
    }

    @Override
    public AgendaProgramaCapacitacion findById(int cve_agenda) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        SQL_SELECT = "SELECT * FROM agendas_programas_capacitacion WHERE cve_agenda = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_agenda);
            rst = ps.executeQuery();

            while (rst.next()) {
                agenda = new AgendaProgramaCapacitacion();
                agenda.setCve_agenda(rst.getInt("cve_agenda"));
                agenda.setCve_programa_capacitacion(pcdao.findById(rst.getInt("cve_programa_capacitacion")));
                agenda.setFecha_inicio(rst.getTimestamp("fecha_inicio"));
                agenda.setFecha_fin(rst.getTimestamp("fecha_fin"));
                agenda.setHorario(rst.getString("horario"));
                agenda.setDuracion_horas(rst.getInt("duracion_horas"));
                agenda.setInstructor(pdao.findById(rst.getInt("instructor")));
                agenda.setFecha_registro(rst.getTimestamp("fecha_registro"));
                agenda.setActivo(rst.getBoolean("activo"));
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
        return agenda;
    }

    @Override
    public boolean delete(int cve_agenda) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        SQL_DELETE = "DELETE FROM agendas_programas_capacitacion WHERE cve_agenda = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_agenda);

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

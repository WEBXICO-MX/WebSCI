/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AgendaProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.PersonaDAO;
import com.serviciosdecapacitacion.dao.RegistroParticipanteDAO;
import com.serviciosdecapacitacion.model.RegistroParticipante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERRegistroParticipanteDAO implements RegistroParticipanteDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;
    PersonaDAO pdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getPersonaDAO();
    AgendaProgramaCapacitacionDAO apcdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAgendaProgramaCapacitacionDAO();

    @Override
    public boolean saveOrUpdate(RegistroParticipante registro) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO registros_participantes (participante,cve_agenda,fecha_registro) VALUES(?,?,?)";
        String SQL_UPDATE = "UPDATE registros_participantes SET participante = ?,cve_agenda = ? ,fecha_registro = ? WHERE cve_registro = ?";

        try {
            if (registro.getCve_registro() == 0) {
                ps = cnx.prepareStatement(SQL_INSERT);
                System.out.println(SQL_INSERT);
                ps.setInt(1, registro.getParticipante().getCve_persona());
                ps.setInt(2, registro.getCve_agenda().getCve_agenda());
                ps.setTimestamp(3, registro.getFecha_registro());
            } else {
                ps = cnx.prepareStatement(SQL_UPDATE);
                System.out.println(SQL_UPDATE);
                ps.setInt(1, registro.getParticipante().getCve_persona());
                ps.setInt(2, registro.getCve_agenda().getCve_agenda());
                ps.setTimestamp(3, registro.getFecha_registro());
                ps.setInt(4, registro.getCve_registro());
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
    public List<RegistroParticipante> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        RegistroParticipante registro = null;
        List registros = new ArrayList();
        String SQL_SELECT = "SELECT * FROM registros_participantes";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                registro = new RegistroParticipante();
                registro.setCve_registro(rst.getInt("cve_registro_capacitacion"));
                registro.setParticipante(pdao.findById(rst.getInt("participante")));
                registro.setCve_agenda(apcdao.findById(rst.getInt("cve_agenda")));
                registro.setFecha_registro(rst.getTimestamp("fecha_registro"));
                registros.add(registro);
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
        return registros;
    }

    @Override
    public RegistroParticipante findById(int cve_registro_capacitacion) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        RegistroParticipante registro = null;
        String SQL_SELECT = "SELECT * FROM registros_participantes WHERE cve_registro_capacitacion = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_registro_capacitacion);
            rst = ps.executeQuery();

            while (rst.next()) {
                registro = new RegistroParticipante();
                registro.setCve_registro(rst.getInt("cve_registro_capacitacion"));
                registro.setParticipante(pdao.findById(rst.getInt("participante")));
                registro.setCve_agenda(apcdao.findById(rst.getInt("cve_agenda")));
                registro.setFecha_registro(rst.getTimestamp("fecha_registro"));
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
        return registro;
    }

    @Override
    public boolean delete(int cve_registro_capacitacion) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM registros_participantes WHERE cve_registro = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_registro_capacitacion);
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

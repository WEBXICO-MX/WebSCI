/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AreaOcupacionDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.PersonaDAO;
import com.serviciosdecapacitacion.dao.TipoPersonaDAO;
import com.serviciosdecapacitacion.model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERPersonaDAO implements PersonaDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;
    TipoPersonaDAO tpdao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getTipoPersonaDAO();
    AreaOcupacionDAO aodao = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaOcupacionDAO();

    @Override
    public boolean saveOrUpdate(Persona persona) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO personas (nombre,ap_paterno,ap_materno,rfc,curp,ocupacion_especifica,puesto,tipo,fecha_nacimiento,fecha_registro,ruta_img,activo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        String SQL_UPDATE = "UPDATE personas SET nombre = ?,ap_paterno = ?,ap_materno = ?,rfc = ?,curp = ?,ocupacion_especifica = ?,puesto = ?,tipo = ?,fecha_nacimiento = ?,ruta_img = ?,activo = ? WHERE cve_persona = ?";

        try {
            if (persona.getCve_persona() == 0) {
                System.out.println(SQL_INSERT);
                ps = cnx.prepareStatement(SQL_INSERT);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getAp_paterno());
                ps.setString(3, persona.getAp_materno());
                ps.setString(4, persona.getRfc());
                ps.setString(5, persona.getCurp());
                ps.setInt(6, persona.getOcuapacion_especifica().getCve_area_ocupacion());
                ps.setString(7, persona.getPuesto());
                ps.setInt(8, persona.getTipo().getCve_tipo());
                ps.setTimestamp(9, persona.getFecha_nacimiento());
                ps.setTimestamp(10, persona.getFecha_registro());
                ps.setString(11, persona.getRuta_img());
                ps.setBoolean(12, persona.isActivo());

            } else {
                System.out.println(SQL_UPDATE);
                ps = cnx.prepareStatement(SQL_UPDATE);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getAp_paterno());
                ps.setString(3, persona.getAp_materno());
                ps.setString(4, persona.getRfc());
                ps.setString(5, persona.getCurp());
                ps.setInt(6, persona.getOcuapacion_especifica().getCve_area_ocupacion());
                ps.setString(7, persona.getPuesto());
                ps.setInt(8, persona.getTipo().getCve_tipo());
                ps.setTimestamp(9, persona.getFecha_nacimiento());
                //ps.setTimestamp(10, persona.getFecha_registro());
                ps.setString(10, persona.getRuta_img());
                ps.setBoolean(11, persona.isActivo());
                ps.setInt(12, persona.getCve_persona());
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
    public List<Persona> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        Persona persona = null;
        List personas = new ArrayList();
        String SQL_SELECT = "SELECT * FROM personas";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                persona = new Persona();
                persona.setCve_persona(rst.getInt("cve_persona"));
                persona.setNombre(rst.getString("nombre"));
                persona.setAp_paterno(rst.getString("ap_paterno"));
                persona.setAp_materno(rst.getString("ap_materno"));
                persona.setRfc(rst.getString("rfc"));
                persona.setCurp(rst.getString("curp"));
                persona.setOcuapacion_especifica(aodao.findById(rst.getInt("ocupacion_especifica")));
                persona.setPuesto(rst.getString("puesto"));
                persona.setTipo(tpdao.findById(rst.getInt("tipo")));
                persona.setFecha_nacimiento(rst.getTimestamp("fecha_nacimiento"));
                persona.setFecha_registro(rst.getTimestamp("fecha_registro"));
                persona.setRuta_img(rst.getString("ruta_img"));
                persona.setActivo(rst.getBoolean("activo"));
                personas.add(persona);
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
        return personas;
    }

    @Override
    public Persona findById(int cve_persona) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        Persona persona = null;
        String SQL_SELECT = "SELECT * FROM personas_personas WHERE cve_persona = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_persona);
            rst = ps.executeQuery();

            while (rst.next()) {
                persona = new Persona();
                persona.setCve_persona(rst.getInt("cve_persona"));
                persona.setNombre(rst.getString("nombre"));
                persona.setAp_paterno(rst.getString("ap_paterno"));
                persona.setAp_materno(rst.getString("ap_materno"));
                persona.setRfc(rst.getString("rfc"));
                persona.setCurp(rst.getString("curp"));
                persona.setOcuapacion_especifica(aodao.findById(rst.getInt("ocupacion_especifica")));
                persona.setPuesto(rst.getString("puesto"));
                persona.setTipo(tpdao.findById(rst.getInt("tipo")));
                persona.setFecha_nacimiento(rst.getTimestamp("fecha_nacimiento"));
                persona.setFecha_registro(rst.getTimestamp("fecha_registro"));
                persona.setRuta_img(rst.getString("ruta_img"));
                persona.setActivo(rst.getBoolean("activo"));
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
        return persona;
    }

    @Override
    public boolean delete(int cve_persona) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM personas WHERE cve_persona = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_persona);
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

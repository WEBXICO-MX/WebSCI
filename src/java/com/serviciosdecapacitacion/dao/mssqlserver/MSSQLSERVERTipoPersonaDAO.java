/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.TipoPersonaDAO;
import com.serviciosdecapacitacion.model.TipoPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERTipoPersonaDAO implements TipoPersonaDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;

    @Override
    public boolean saveOrUpdate(TipoPersona tipo) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO tipos_personas (nombre_tipo,activo) VALUES(?,?)";
        String SQL_UPDATE = "UPDATE tipos_personas SET nombre_tipo = ?, activo = ? WHERE cve_tipo = ?";

        try {
            if (tipo.getCve_tipo() == 0) {
                ps = cnx.prepareStatement(SQL_INSERT);
                System.out.println(SQL_INSERT);
                ps.setString(1, tipo.getNombre());
                ps.setBoolean(2, tipo.isActivo());
            } else {
                ps = cnx.prepareStatement(SQL_UPDATE);
                System.out.println(SQL_UPDATE);
                ps.setString(1, tipo.getNombre());
                ps.setBoolean(2, tipo.isActivo());
                ps.setInt(3, tipo.getCve_tipo());
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
    public List<TipoPersona> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        TipoPersona tipo = null;
        List tipos = new ArrayList();
        String SQL_SELECT = "SELECT * FROM tipos_personas";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                tipo = new TipoPersona();
                tipo.setCve_tipo(rst.getInt("cve_tipo"));
                tipo.setNombre(rst.getString("nombre_tipo"));
                tipo.setActivo(rst.getBoolean("activo"));
                tipos.add(tipo);
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
        return tipos;
    }

    @Override
    public TipoPersona findById(int cve_tipo) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        TipoPersona tipo = null;
        String SQL_SELECT = "SELECT * FROM tipos_personas WHERE cve_tipo = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_tipo);
            rst = ps.executeQuery();

            while (rst.next()) {
                tipo = new TipoPersona();
                tipo.setCve_tipo(rst.getInt("cve_tipo"));
                tipo.setNombre(rst.getString("nombre_tipo"));
                tipo.setActivo(rst.getBoolean("activo"));
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
        return tipo;
    }

    @Override
    public boolean delete(int cve_tipo) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM tipos_personas WHERE cve_tipo = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_tipo);
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

/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AreaTematicaDAO;
import com.serviciosdecapacitacion.model.AreaTematica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERAreaTematicaDAO implements AreaTematicaDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;

    @Override
    public boolean saveOrUpdate(AreaTematica area) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO areas_tematicas (nombre_area,clave_del_area,activo) VALUES(?,?,?)";
        String SQL_UPDATE = "UPDATE areas_tematicas SET nombre_area = ?,clave_del_area = ?, activo = ? WHERE cve_area_tematica = ?";
        try {
            if (area.getCve_area_tematica() == 0) {
                System.out.println(SQL_INSERT);
                ps = cnx.prepareStatement(SQL_INSERT);
                ps.setString(1, area.getNombre());
                ps.setString(2, area.getClave_del_area());
                ps.setBoolean(3, area.isActivo());

            } else {
                System.out.println(SQL_UPDATE);
                ps = cnx.prepareStatement(SQL_UPDATE);
                ps.setString(1, area.getNombre());
                ps.setString(2, area.getClave_del_area());
                ps.setBoolean(3, area.isActivo());
                ps.setInt(4, area.getCve_area_tematica());
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
    public List<AreaTematica> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        stmt = null;
        rst = null;
        AreaTematica area = null;
        List areas = new ArrayList();
        String SQL_SELECT = "SELECT * FROM areas_tematicas";

        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                area = new AreaTematica();
                area.setCve_area_tematica(rst.getInt("cve_area_tematica"));
                area.setNombre(rst.getString("nombre_area"));
                area.setClave_del_area(rst.getString("clave_del_area"));
                area.setActivo(rst.getBoolean("activo"));
                areas.add(area);
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
        return areas;
    }

    @Override
    public AreaTematica findById(int cve_area_tematica) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        AreaTematica area = null;
        String SQL_SELECT = "SELECT * FROM areas_tematicas WHERE cve_area_tematica = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_area_tematica);
            rst = ps.executeQuery();

            while (rst.next()) {
                area = new AreaTematica();
                area.setCve_area_tematica(rst.getInt("cve_area_tematica"));
                area.setNombre(rst.getString("nombre_area"));
                area.setClave_del_area(rst.getString("clave_del_area"));
                area.setActivo(rst.getBoolean("activo"));
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
        return area;
    }

    @Override
    public boolean delete(int cve_area_tematica) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM areas_tematicas WHERE cve_area_tematica = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_area_tematica);
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

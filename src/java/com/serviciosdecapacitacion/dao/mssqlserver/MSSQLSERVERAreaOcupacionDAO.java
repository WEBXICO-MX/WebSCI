/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao.mssqlserver;

import com.serviciosdecapacitacion.dao.AreaOcupacionDAO;
import com.serviciosdecapacitacion.model.AreaOcupacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MSSQLSERVERAreaOcupacionDAO implements AreaOcupacionDAO {

    Connection cnx = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rst = null;
    boolean success = false;

    @Override
    public boolean saveOrUpdate(AreaOcupacion area) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_INSERT = "INSERT INTO areas_ocupacionales (nombre_area,clave_area_subarea,activo) VALUES(?,?,?)";
        String SQL_UPDATE = "UPDATE areas_ocupacionales SET nombre_area = ?,clave_area_subarea = ?, activo = ? WHERE cve_area_ocupacional = ?";
        try {
            if (area.getCve_area_ocupacion() == 0) {
                System.out.println(SQL_INSERT);
                ps = cnx.prepareStatement(SQL_INSERT);
                ps.setString(1, area.getNombre());
                ps.setString(2, area.getClave_area_subarea());
                ps.setBoolean(3, area.isActivo());

            } else {
                System.out.println(SQL_UPDATE);
                ps = cnx.prepareStatement(SQL_UPDATE);
                ps.setString(1, area.getNombre());
                ps.setString(2, area.getClave_area_subarea());
                ps.setBoolean(3, area.isActivo());
                ps.setInt(4, area.getCve_area_ocupacion());
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
    public List<AreaOcupacion> findAll() {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        stmt = null;
        rst = null;
        AreaOcupacion area = null;
        List areas = new ArrayList();
        String SQL_SELECT = "SELECT * FROM areas_ocupacionales";
        try {
            stmt = cnx.createStatement();
            rst = stmt.executeQuery(SQL_SELECT);
            while (rst.next()) {
                area = new AreaOcupacion();
                area.setCve_area_ocupacion(rst.getInt("cve_area_ocupacional"));
                area.setNombre(rst.getString("nombre_area"));
                area.setClave_area_subarea(rst.getString("clave_area_subarea"));
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
    public AreaOcupacion findById(int cve_area_ocupacional) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        AreaOcupacion area = null;
        String SQL_SELECT = "SELECT * FROM areas_ocupacionales WHERE cve_area_ocupacional = ?";

        try {
            ps = cnx.prepareStatement(SQL_SELECT);
            ps.setInt(1, cve_area_ocupacional);
            rst = ps.executeQuery();

            while (rst.next()) {
                area = new AreaOcupacion();
                area.setCve_area_ocupacion(rst.getInt("cve_area_ocupacional"));
                area.setNombre(rst.getString("nombre_area"));
                area.setClave_area_subarea(rst.getString("clave_area_subarea"));
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
    public boolean delete(int cve_area_ocupacional) {
        cnx = MSSQLSERVERDAOFactory.createConnection();
        String SQL_DELETE = "DELETE FROM areas_ocupacionales WHERE cve_area_ocupacional = ?";

        try {
            ps = cnx.prepareStatement(SQL_DELETE);
            ps.setInt(1, cve_area_ocupacional);
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

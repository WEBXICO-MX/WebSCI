/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.AgendaProgramaCapacitacion;
import java.util.List;

public interface AgendaProgramaCapacitacionDAO {

    public boolean saveOrUpdate(AgendaProgramaCapacitacion agenda);

    public List<AgendaProgramaCapacitacion> findAll();

    public AgendaProgramaCapacitacion findById(int cve_agenda);

    public boolean delete(int cve_agenda);
}

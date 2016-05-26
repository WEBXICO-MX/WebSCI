/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.AreaOcupacion;
import java.util.List;

public interface AreaOcupacionDAO {

    public boolean saveOrUpdate(AreaOcupacion area);

    public List<AreaOcupacion> findAll();

    public AreaOcupacion findById(int id);

    public boolean delete(int id);
}

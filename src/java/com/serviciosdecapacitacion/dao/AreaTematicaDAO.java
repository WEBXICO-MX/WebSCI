/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.AreaTematica;
import java.util.List;

public interface AreaTematicaDAO {

    public boolean saveOrUpdate(AreaTematica area);

    public List<AreaTematica> findAll();

    public AreaTematica findById(int id);

    public boolean delete(int id);
}

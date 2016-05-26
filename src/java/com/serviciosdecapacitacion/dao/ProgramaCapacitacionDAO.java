/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.ProgramaCapacitacion;
import java.util.List;

public interface ProgramaCapacitacionDAO {

    public boolean saveOrUpdate(ProgramaCapacitacion programa);

    public List<ProgramaCapacitacion> findAll();

    public ProgramaCapacitacion findById(int id);

    public boolean delete(int id);
}

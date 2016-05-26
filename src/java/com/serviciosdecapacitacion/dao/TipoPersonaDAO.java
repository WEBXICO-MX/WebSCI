/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.TipoPersona;
import java.util.List;

public interface TipoPersonaDAO {

    public boolean saveOrUpdate(TipoPersona tipo);

    public List<TipoPersona> findAll();

    public TipoPersona findById(int id);

    public boolean delete(int id);
}

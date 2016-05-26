/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.RegistroParticipante;
import java.util.List;

public interface RegistroParticipanteDAO {

    public boolean saveOrUpdate(RegistroParticipante registro);

    public List<RegistroParticipante> findAll();

    public RegistroParticipante findById(int id);

    public boolean delete(int id);
}

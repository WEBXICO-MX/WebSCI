/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.dao;

import com.serviciosdecapacitacion.model.Persona;
import java.util.List;

public interface PersonaDAO {

    public boolean saveOrUpdate(Persona persona);

    public List<Persona> findAll();

    public Persona findById(int id);

    public boolean delete(int id);
}


package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;




public interface IPersonaService {
    
//Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
//Traer una lista de  personas
 public List<Persona> getPersona();
 //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}

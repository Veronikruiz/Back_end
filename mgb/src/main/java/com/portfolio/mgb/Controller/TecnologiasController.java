/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Entity.Tecnologias;
import com.portfolio.mgb.Interface.ITecnologiasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")

public class TecnologiasController {
@Autowired ITecnologiasService itecnologiasService;
  @GetMapping("tecnologias/traer") 
  public List<Tecnologias> getTecnologias(){
  return itecnologiasService. getTecnologias();
}
  
  @PostMapping("/tecnologias/crear")
  public String createTecnologias(@RequestBody Tecnologias tecnologias ){
        itecnologiasService.saveTecnologias(tecnologias);
        return "La tecnologia fue creado correctamente";
    }
    @DeleteMapping("/tecnologias/borrar/{id}")
    public String deleteTecnologias(@PathVariable Long id){
      itecnologiasService.deleteTecnologias(id);
      return "La tecnologia fue eliminado correctamente";
    }
    
    @PutMapping("/tecnologias/editar/{id}")
    public Tecnologias editTecnologias(@PathVariable Long id,
                @RequestParam("nombredeTecnologias") String nuevoNombredeTecnologias,
                @RequestParam("porcentajedeConocimientos") String nuevoPorcentajedeConocimientos){
            Tecnologias tecnologias = itecnologiasService.findTecnologias(id);
         
            tecnologias.setNombredeTecnologias(nuevoNombredeTecnologias);
            tecnologias.setPorcentajedeConocimientos(nuevoPorcentajedeConocimientos);
            itecnologiasService.saveTecnologias(tecnologias);
            return tecnologias;           
    }
    
    @GetMapping ("/tecnologias/traer/perfil")
    public Tecnologias findTecnologias(){
        return itecnologiasService.findTecnologias((long)1);
    }
}    



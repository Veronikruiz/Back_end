/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Tecnologias;
import java.util.List;

public interface ITecnologiasService {
 public List<Tecnologias> getTecnologias() ;

 
    public void saveTecnologias(Tecnologias tecnologias) ;

    
    public void deleteTecnologias(Long id) ;

    
    public Tecnologias findTecnologias(Long id);
    
}



package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Usuarios;
import java.util.List;

public interface IUsuariosService {
 public List<Usuarios> getUsuarios() ;

 
    public void saveUsuarios(Usuarios usuarios) ;

    
    public void deleteUsuarios(Long id) ;

    
    public Usuarios findUsuarios(Long id);
    
}
    



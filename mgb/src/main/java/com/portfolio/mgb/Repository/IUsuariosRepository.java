
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Long> {

}
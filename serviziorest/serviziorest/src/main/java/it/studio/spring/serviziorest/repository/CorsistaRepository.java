package it.studio.spring.serviziorest.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.studio.spring.serviziorest.entita.Corsista;
/***
 * 
 * @author E002097
 * pppp
 * 
 *
 */
@Repository
public interface CorsistaRepository extends CrudRepository<Corsista, Long>{

}

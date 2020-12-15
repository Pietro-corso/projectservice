package it.studio.spring.serviziorest.service;

import java.util.List;

import it.studio.spring.serviziorest.dto.CorsistaDTO;

public interface CorsistaService {
	CorsistaDTO getEntityById(long id);
	CorsistaDTO insertEntity(CorsistaDTO dto);
	CorsistaDTO updateEntity(CorsistaDTO dto);	
	void deleteEntity(long id);
    List<CorsistaDTO> searchAllEntity();

}

package it.studio.spring.serviziorest.service;

import java.util.List;

import it.studio.spring.serviziorest.dto.CorsistaDTO;



public interface CorsistaService {
	CorsistaDTO getCorsistaId(long id);
	void inserisciCorsista(CorsistaDTO dto);
	void aggiornaCorsista(long id,CorsistaDTO dto);
    void cancellaCorsista(long id);
    List<CorsistaDTO> listaCorsisti();

}

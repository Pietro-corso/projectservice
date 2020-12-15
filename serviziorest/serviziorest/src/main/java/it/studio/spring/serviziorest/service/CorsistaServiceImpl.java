package it.studio.spring.serviziorest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.studio.spring.serviziorest.dto.CorsistaDTO;
import it.studio.spring.serviziorest.entita.Corsista;
import it.studio.spring.serviziorest.repository.CorsistaRepository;

@Service
public class CorsistaServiceImpl implements CorsistaService{
	@Autowired
	private CorsistaRepository corsistaRepository;
	/**
	 * metodo che torna il dto del corsista 
	 * ricercato
	 * id valore chiave 
	 */
	private static final Logger log = LoggerFactory.getLogger(CorsistaServiceImpl.class);


	public CorsistaDTO getEntityById(long id) {
		// TODO Auto-generated method stub	
		CorsistaDTO dto = new CorsistaDTO();
		try {

			dto = corsistaRepository.findById(id).map(a -> convertiEntitaInDto(a)).get();
			dto.setEsisto_response("FOUND");
		}catch(Exception e) {
			log.info(e.getMessage());
			dto.setEsisto_response("ERROR");
		}
		return dto;
	}
	/**
	 * metodo che inserisce un corista
	 * i valori del dto passato memorizzati
	 * 
	 */
	@Override
	public CorsistaDTO insertEntity(CorsistaDTO requestDTO) {
		// TODO Auto-generated method stub
		CorsistaDTO dto = new CorsistaDTO();

		try {			     
			Corsista entita = convertiDtoInEntita(requestDTO);
			corsistaRepository.save(entita);

			dto = getEntityById(entita.getId());
			dto.setEsisto_response("Inserimento effettuato con successo");
		}catch(Exception e) {
			log.info(e.getMessage());			
			dto.setEsisto_response("ERROR");
		}
		return dto;
	}

	@Override
	public CorsistaDTO updateEntity(CorsistaDTO requestDTO) {
		// TODO Auto-generated method stub
		CorsistaDTO dto = new CorsistaDTO();
		Corsista entita = convertiDtoInEntita(requestDTO);

		try {			     
			corsistaRepository.save(entita);

			dto = getEntityById(entita.getId());
			dto.setEsisto_response("Dati aggiornati con successo");
		}catch(Exception e) {
			log.info(e.getMessage());
			dto.setEsisto_response("ERROR");
		}
		return dto;
	}


	@Override
	public void deleteEntity(long id) {
		// TODO Auto-generated method stub
		corsistaRepository.deleteById(id);
	}


	@Override
	public List<CorsistaDTO> searchAllEntity() {
		// TODO Auto-generated method stub
		List<Corsista> allEntity = new ArrayList<>();
		List<CorsistaDTO> allDTO = new ArrayList<>();

		try {
			corsistaRepository.findAll().forEach(entita -> allEntity.add(entita));
			allDTO = allEntity.stream()
					.map(a -> convertiEntitaInDto(a))
					.collect(Collectors.toList());
		}catch(Exception e) {
			log.info(e.getMessage());
			allDTO.clear();
		}
		return allDTO;

	}

	/**
	 * passo i dati da entita a dto
	 * @param corsista
	 * @return
	 */
	private CorsistaDTO convertiEntitaInDto(Corsista corsista) {

		CorsistaDTO dto = new CorsistaDTO();

		dto.setId(corsista.getId());
		dto.setCognome(corsista.getCognome());
		dto.setNome(corsista.getNome());    
		dto.setDateOfBirth(corsista.getDateOfBirth());

		return dto;
	}
	/**
	 * passo dati da dto a entita
	 * @param corsista
	 * @return
	 */
	private Corsista convertiDtoInEntita(CorsistaDTO dto) {

		Corsista entita = new Corsista();
		// 
		if (dto.getId()!=null) entita.setId(dto.getId());

		entita.setCognome(dto.getCognome());
		entita.setNome(dto.getNome());    	
		entita.setDateOfBirth(dto.getDateOfBirth());

		return entita;
	}



}

package it.studio.spring.serviziorest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.studio.spring.serviziorest.dto.CorsistaDTO;
import it.studio.spring.serviziorest.service.CorsistaService;

@RestController
public class CorsistaController {
	@Autowired
	public CorsistaService corepimpl;
	/*
	 * endpoint http:/localhost:8080/dati_corsista/id
	 * torna il corsista in base alla chiave
	 * 
	 */
	@GetMapping(value="/dati_corsista")
	public ResponseEntity<CorsistaDTO> listaAllievi(){
		System.out.println("listaAllievi");
		
		return corepimpl.listaCorsisti();
	}
	@GetMapping(value="/dati_corsista/{id}")
	public ResponseEntity<?> getCorsistaId(@PathVariable("id") long id){

		return corepimpl.getCorsistaId(id);
	}


	@PostMapping("/dati_corsista")
	public ResponseEntity<?> creanuovoAllievo(@RequestBody CorsistaDTO dto){
		System.out.println("creanuovoallievo");
		return	corepimpl.inserisciCorsista(dto);

	}

	@PutMapping("/dati_corsista/{id}")
	public ResponseEntity<?> aggiornaCorsista(@PathVariable("id") long id, @RequestBody CorsistaDTO corsista) {
		System.out.println("aggiornacorsista");
		return corepimpl.aggiornaCorsista(id, corsista.getNome(), corsista.getCognome());

	}

	@DeleteMapping("/dati_corsista/{id}")
	public HttpStatus cancellaAllievo(@PathVariable("id") long id) {
		return corepimpl.cancellaCorsista(id);
	}
}


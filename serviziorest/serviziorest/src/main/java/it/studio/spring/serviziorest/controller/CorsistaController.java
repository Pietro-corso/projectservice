package it.studio.spring.serviziorest.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.studio.spring.serviziorest.dto.CorsistaDTO;
import it.studio.spring.serviziorest.service.CorsistaService;

@RestController
@RequestMapping("/corso")
public class CorsistaController {
	@Autowired
	private CorsistaService corservice;


	@GetMapping("/corsista/{id}")
	public ResponseEntity<CorsistaDTO> findEntityById(@PathVariable("id") long id){

		CorsistaDTO response = corservice.getEntityById(id);
		/**
		 * aggiunto commento al CorsistaController
		 */

		if (response.getEsisto_response().equals("ERROR")) {
			return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

	@PostMapping()	
	public ResponseEntity<CorsistaDTO> insertEntity(@RequestBody CorsistaDTO request_dto){
		CorsistaDTO response = corservice.insertEntity(request_dto);
		if (response.getEsisto_response().equals("ERROR")) {
			return	new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}

	@PutMapping()
	public ResponseEntity<CorsistaDTO> updateEntity(@RequestBody CorsistaDTO request_dto) {
		CorsistaDTO response = corservice.updateEntity(request_dto);
		if (response.getEsisto_response().equals("ERROR")) {
			return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}


	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void  cancellaAllievo(@PathVariable("id") Long id) {
		corservice.deleteEntity(id);		
	}

	@GetMapping()
	public ResponseEntity<List<CorsistaDTO>> searchAll(){
		List<CorsistaDTO> response = new ArrayList<>();
		response = corservice.searchAllEntity();
		if (response.isEmpty()) {
			return	new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else
		{
			return	new ResponseEntity<>(response,HttpStatus.OK);
		}

	}

}


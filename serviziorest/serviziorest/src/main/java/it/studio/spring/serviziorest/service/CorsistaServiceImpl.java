package it.studio.spring.serviziorest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import it.studio.spring.serviziorest.dto.CorsistaDTO;
import it.studio.spring.serviziorest.entita.Corsista;
import it.studio.spring.serviziorest.repository.CorsistaRepository;

@Service
public class CorsistaServiceImpl implements CorsistaService{
	@Autowired
	public CorsistaRepository corep;

	@Override
	public ResponseEntity<CorsistaDTO> getCorsistaId(long id) {
		// TODO Auto-generated method stub
		System.out.println("valore è "+id);
		Optional<Corsista> ricercato = corep.findById(id);

		if (ricercato.isEmpty()) {		

			return new ResponseEntity<>(ricercato.get(), HttpStatus.OK);

		}else
		{
			System.out.println("senza valore");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> inserisciCorsista(String nome, String cognome) {
		// TODO Auto-generated method stub
		try {
			System.out.println("step 2");
			Corsista allievo = 
					corep.save(new Corsista(nome,cognome,LocalDate.now()));
			return new ResponseEntity<>(allievo, HttpStatus.CREATED);

		}catch(Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public List<CorsistaDTO> listaCorsisti() {
		try {
			System.out.println("*********** è questo");
			List<CorsistaDTO> corsisti = new ArrayList<CorsistaDTO>();


			var it = corep.findAll();

			it.forEach(action);
			
			if (corsisti.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(corsisti, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void  aggiornaCorsista(long id, String nome, String cognome) {

		System.out.println("step put");
		Optional<Corsista> trovato = corep.findById(id);

		if (trovato.isPresent()) {
			Corsista allievo = trovato.get();
			allievo.setCognome(cognome);
			allievo.setNome(nome);
			return new ResponseEntity<>(corep.save(allievo), HttpStatus.OK);

		}else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}

	@Override
	public HttpStatus cancellaCorsista(long id) {
		// TODO Auto-generated method stub
		try {
			corep.deleteById(id);
			return HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}


}

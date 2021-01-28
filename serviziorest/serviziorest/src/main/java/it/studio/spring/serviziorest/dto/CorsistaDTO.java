package it.studio.spring.serviziorest.dto;

import java.time.LocalDate;

public class CorsistaDTO {

	private Long Id;
	public Long getId() {
		return Id;
	}
/**
 * aggiunto altro commento in dto
 * @param id
 */
	public void setId(Long id) {
		Id = id;
	}
	private String nome;	
	private String cognome;
	private String esisto_response;
	private LocalDate dateOfBirth;


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEsisto_response() {
		return esisto_response;
	}

	public void setEsisto_response(String esisto_response) {
		this.esisto_response = esisto_response;
	}

	public CorsistaDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


}

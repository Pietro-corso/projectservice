package it.studio.spring.serviziorest.dto;

import java.time.LocalDate;

public class CorsistaDTO {
	

	private String nome;
	private long id;
	private String cognome;
	private LocalDate data_assunzione;
	
	public CorsistaDTO() {
		super();
	}
	public CorsistaDTO(String nome, String cognome, LocalDate data_assunzione) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.data_assunzione = data_assunzione;
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
    public LocalDate getData_assunzione() {
		return data_assunzione;
	}
	public void setData_assunzione(LocalDate data_assunzione) {
		this.data_assunzione = data_assunzione;
	}
	public long getId() {
		return id;
	}
	
}

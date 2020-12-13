package it.studio.spring.serviziorest.entita;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Corsista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cognome;
	private LocalDate data_assunzione;
	private String nome;
	
	public Corsista() {
		
	}
	public Corsista(String nome, String cognome, LocalDate data_assunzione) {

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
	
	public long getId() {
		return id;
	}



}

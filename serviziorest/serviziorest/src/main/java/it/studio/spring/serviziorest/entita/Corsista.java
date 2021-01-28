package it.studio.spring.serviziorest.entita;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;


@Entity
@Audited
public class Corsista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String cognome;	

	@Column(nullable = false)
	private String nome;
    @Column(nullable = false)     
    private LocalDate dateOfBirth;
    /**
     * modificato
     * cccc
     * ffff
     * pppp
     * @return
     */
    
    public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Corsista() {

	}

	public void setId(long id) {
		this.id = id;
	}

	public Corsista(String nome, String cognome) {

		this.nome = nome;
		this.cognome = cognome;

	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public long getId() {
		return id;
	}

}

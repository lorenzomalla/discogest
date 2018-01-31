package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comande database table.
 * 
 */
@Entity
@NamedQuery(name="Comande.findAll", query="SELECT c FROM Comande c")
public class Comande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to CaricoSerate
	@ManyToOne
	@JoinColumn(name="id_carico")
	private CaricoSerate caricoSerate;

	//bi-directional many-to-one association to Prenotazioni
	@ManyToOne
	@JoinColumn(name="id_prenotazione")
	private Prenotazioni prenotazioni;

	public Comande() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CaricoSerate getCaricoSerate() {
		return this.caricoSerate;
	}

	public void setCaricoSerate(CaricoSerate caricoSerate) {
		this.caricoSerate = caricoSerate;
	}

	public Prenotazioni getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(Prenotazioni prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

}
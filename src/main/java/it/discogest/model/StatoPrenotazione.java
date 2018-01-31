package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stato_prenotazione database table.
 * 
 */
@Entity
@Table(name="stato_prenotazione")
@NamedQuery(name="StatoPrenotazione.findAll", query="SELECT s FROM StatoPrenotazione s")
public class StatoPrenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="stato_tavolo")
	private String statoTavolo;

	//bi-directional many-to-one association to Prenotazioni
	@OneToMany(mappedBy="statoPrenotazione")
	private List<Prenotazioni> prenotazioni;

	public StatoPrenotazione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatoTavolo() {
		return this.statoTavolo;
	}

	public void setStatoTavolo(String statoTavolo) {
		this.statoTavolo = statoTavolo;
	}

	public List<Prenotazioni> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazioni addPrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setStatoPrenotazione(this);

		return prenotazioni;
	}

	public Prenotazioni removePrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setStatoPrenotazione(null);

		return prenotazioni;
	}

}
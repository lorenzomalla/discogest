package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prenotazioni database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazioni.findAll", query="SELECT p FROM Prenotazioni p")
public class Prenotazioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nome_tavolo")
	private String nomeTavolo;

	//bi-directional many-to-one association to Comande
	@OneToMany(mappedBy="prenotazioni")
	private List<Comande> comande;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="id_locations")
	private Location location;

	//bi-directional many-to-one association to Serate
	@ManyToOne
	@JoinColumn(name="id_serata")
	private Serate serate;

	//bi-directional many-to-one association to StatoPrenotazione
	@ManyToOne
	@JoinColumn(name="id_stato_tavolo")
	private StatoPrenotazione statoPrenotazione;

	public Prenotazioni() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeTavolo() {
		return this.nomeTavolo;
	}

	public void setNomeTavolo(String nomeTavolo) {
		this.nomeTavolo = nomeTavolo;
	}

	public List<Comande> getComande() {
		return this.comande;
	}

	public void setComande(List<Comande> comande) {
		this.comande = comande;
	}

	public Comande addComande(Comande comande) {
		getComande().add(comande);
		comande.setPrenotazioni(this);

		return comande;
	}

	public Comande removeComande(Comande comande) {
		getComande().remove(comande);
		comande.setPrenotazioni(null);

		return comande;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Serate getSerate() {
		return this.serate;
	}

	public void setSerate(Serate serate) {
		this.serate = serate;
	}

	public StatoPrenotazione getStatoPrenotazione() {
		return this.statoPrenotazione;
	}

	public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}

}
package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nome_location")
	private String nomeLocation;

	@Column(name="x_view")
	private int xView;

	@Column(name="y_view")
	private int yView;

	//bi-directional many-to-one association to Piantine
	@ManyToOne
	@JoinColumn(name="id_piantina")
	private Piantine piantine;

	//bi-directional many-to-one association to Prenotazioni
	@OneToMany(mappedBy="location")
	private List<Prenotazioni> prenotazioni;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeLocation() {
		return this.nomeLocation;
	}

	public void setNomeLocation(String nomeLocation) {
		this.nomeLocation = nomeLocation;
	}

	public int getXView() {
		return this.xView;
	}

	public void setXView(int xView) {
		this.xView = xView;
	}

	public int getYView() {
		return this.yView;
	}

	public void setYView(int yView) {
		this.yView = yView;
	}

	public Piantine getPiantine() {
		return this.piantine;
	}

	public void setPiantine(Piantine piantine) {
		this.piantine = piantine;
	}

	public List<Prenotazioni> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazioni addPrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setLocation(this);

		return prenotazioni;
	}

	public Prenotazioni removePrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setLocation(null);

		return prenotazioni;
	}

}
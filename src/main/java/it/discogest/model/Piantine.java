package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the piantine database table.
 * 
 */
@Entity
@NamedQuery(name="Piantine.findAll", query="SELECT p FROM Piantine p")
public class Piantine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name="mappa_piantina")
	private byte[] mappaPiantina;

	@Column(name="nome_sala")
	private String nomeSala;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="piantine")
	private List<Location> locations;

	public Piantine() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getMappaPiantina() {
		return this.mappaPiantina;
	}

	public void setMappaPiantina(byte[] mappaPiantina) {
		this.mappaPiantina = mappaPiantina;
	}

	public String getNomeSala() {
		return this.nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setPiantine(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setPiantine(null);

		return location;
	}

}
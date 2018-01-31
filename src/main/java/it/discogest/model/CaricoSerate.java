package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carico_serate database table.
 * 
 */
@Entity
@Table(name="carico_serate")
@NamedQuery(name="CaricoSerate.findAll", query="SELECT c FROM CaricoSerate c")
public class CaricoSerate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int carico;

	//bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name="id_prodotto")
	private Prodotti prodotti;

	//bi-directional many-to-one association to Serate
	@ManyToOne
	@JoinColumn(name="id_serata")
	private Serate serate;

	//bi-directional many-to-one association to Comande
	@OneToMany(mappedBy="caricoSerate")
	private List<Comande> comande;

	public CaricoSerate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarico() {
		return this.carico;
	}

	public void setCarico(int carico) {
		this.carico = carico;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

	public Serate getSerate() {
		return this.serate;
	}

	public void setSerate(Serate serate) {
		this.serate = serate;
	}

	public List<Comande> getComande() {
		return this.comande;
	}

	public void setComande(List<Comande> comande) {
		this.comande = comande;
	}

	public Comande addComande(Comande comande) {
		getComande().add(comande);
		comande.setCaricoSerate(this);

		return comande;
	}

	public Comande removeComande(Comande comande) {
		getComande().remove(comande);
		comande.setCaricoSerate(null);

		return comande;
	}

}
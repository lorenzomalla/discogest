package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prodotti database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotti.findAll", query="SELECT p FROM Prodotti p")
public class Prodotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="descrizione_prodotto")
	private String descrizioneProdotto;

	@Column(name="nome_prodotto")
	private String nomeProdotto;

	private double prezzo;

	//bi-directional many-to-one association to CaricoSerate
	@OneToMany(mappedBy="prodotti")
	private List<CaricoSerate> caricoSerate;

	//bi-directional many-to-one association to CategorieProdotti
	@ManyToOne
	@JoinColumn(name="id_categoria_prodotti")
	private CategorieProdotti categorieProdotti;

	public Prodotti() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizioneProdotto() {
		return this.descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public String getNomeProdotto() {
		return this.nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public List<CaricoSerate> getCaricoSerate() {
		return this.caricoSerate;
	}

	public void setCaricoSerate(List<CaricoSerate> caricoSerate) {
		this.caricoSerate = caricoSerate;
	}

	public CaricoSerate addCaricoSerate(CaricoSerate caricoSerate) {
		getCaricoSerate().add(caricoSerate);
		caricoSerate.setProdotti(this);

		return caricoSerate;
	}

	public CaricoSerate removeCaricoSerate(CaricoSerate caricoSerate) {
		getCaricoSerate().remove(caricoSerate);
		caricoSerate.setProdotti(null);

		return caricoSerate;
	}

	public CategorieProdotti getCategorieProdotti() {
		return this.categorieProdotti;
	}

	public void setCategorieProdotti(CategorieProdotti categorieProdotti) {
		this.categorieProdotti = categorieProdotti;
	}

}
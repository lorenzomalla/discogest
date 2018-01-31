package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie_prodotti database table.
 * 
 */
@Entity
@Table(name="categorie_prodotti")
@NamedQuery(name="CategorieProdotti.findAll", query="SELECT c FROM CategorieProdotti c")
public class CategorieProdotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="categoria_prodotto")
	private String categoriaProdotto;

	//bi-directional many-to-one association to Prodotti
	@OneToMany(mappedBy="categorieProdotti")
	private List<Prodotti> prodotti;

	public CategorieProdotti() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoriaProdotto() {
		return this.categoriaProdotto;
	}

	public void setCategoriaProdotto(String categoriaProdotto) {
		this.categoriaProdotto = categoriaProdotto;
	}

	public List<Prodotti> getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(List<Prodotti> prodotti) {
		this.prodotti = prodotti;
	}

	public Prodotti addProdotti(Prodotti prodotti) {
		getProdotti().add(prodotti);
		prodotti.setCategorieProdotti(this);

		return prodotti;
	}

	public Prodotti removeProdotti(Prodotti prodotti) {
		getProdotti().remove(prodotti);
		prodotti.setCategorieProdotti(null);

		return prodotti;
	}

}
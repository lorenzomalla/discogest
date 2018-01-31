package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the serate database table.
 * 
 */
@Entity
@NamedQuery(name="Serate.findAll", query="SELECT s FROM Serate s")
public class Serate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="nome_serata")
	private String nomeSerata;

	//bi-directional many-to-one association to CaricoSerate
	@OneToMany(mappedBy="serate")
	private List<CaricoSerate> caricoSerate;

	//bi-directional many-to-one association to Prenotazioni
	@OneToMany(mappedBy="serate")
	private List<Prenotazioni> prenotazioni;

	public Serate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeSerata() {
		return this.nomeSerata;
	}

	public void setNomeSerata(String nomeSerata) {
		this.nomeSerata = nomeSerata;
	}

	public List<CaricoSerate> getCaricoSerate() {
		return this.caricoSerate;
	}

	public void setCaricoSerate(List<CaricoSerate> caricoSerate) {
		this.caricoSerate = caricoSerate;
	}

	public CaricoSerate addCaricoSerate(CaricoSerate caricoSerate) {
		getCaricoSerate().add(caricoSerate);
		caricoSerate.setSerate(this);

		return caricoSerate;
	}

	public CaricoSerate removeCaricoSerate(CaricoSerate caricoSerate) {
		getCaricoSerate().remove(caricoSerate);
		caricoSerate.setSerate(null);

		return caricoSerate;
	}

	public List<Prenotazioni> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazioni addPrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setSerate(this);

		return prenotazioni;
	}

	public Prenotazioni removePrenotazioni(Prenotazioni prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setSerate(null);

		return prenotazioni;
	}

}
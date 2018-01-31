package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruoli database table.
 * 
 */
@Entity
@NamedQuery(name="Ruoli.findAll", query="SELECT r FROM Ruoli r")
public class Ruoli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ruolo;

	//bi-directional many-to-one association to InfoUser
	@OneToMany(mappedBy="ruoli")
	private List<InfoUser> infoUsers;

	public Ruoli() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public List<InfoUser> getInfoUsers() {
		return this.infoUsers;
	}

	public void setInfoUsers(List<InfoUser> infoUsers) {
		this.infoUsers = infoUsers;
	}

	public InfoUser addInfoUser(InfoUser infoUser) {
		getInfoUsers().add(infoUser);
		infoUser.setRuoli(this);

		return infoUser;
	}

	public InfoUser removeInfoUser(InfoUser infoUser) {
		getInfoUsers().remove(infoUser);
		infoUser.setRuoli(null);

		return infoUser;
	}

}
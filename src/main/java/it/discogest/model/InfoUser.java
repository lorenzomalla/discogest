package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the info_user database table.
 * 
 */
@Entity
@Table(name="info_user")
@NamedQuery(name="InfoUser.findAll", query="SELECT i FROM InfoUser i")
public class InfoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String username;

	//bi-directional many-to-one association to Ruoli
	@ManyToOne
	@JoinColumn(name="id_ruoli")
	private Ruoli ruoli;

	public InfoUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Ruoli getRuoli() {
		return this.ruoli;
	}

	public void setRuoli(Ruoli ruoli) {
		this.ruoli = ruoli;
	}

}
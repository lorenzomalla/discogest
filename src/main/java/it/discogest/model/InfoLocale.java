package it.discogest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the info_locale database table.
 * 
 */
@Entity
@Table(name="info_locale")
@NamedQuery(name="InfoLocale.findAll", query="SELECT i FROM InfoLocale i")
public class InfoLocale implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cap;

	private String citta;

	@Lob
	@Column(name="foto_locale")
	private byte[] fotoLocale;

	private String indirizzo;

	@Column(name="info_supporto_email")
	private String infoSupportoEmail;

	@Column(name="info_tel")
	private String infoTel;

	@Column(name="nome_locale")
	private String nomeLocale;

	@Id
	@Column(name="p_iva")
	private String pIva;

	private String provincia;
	
	private String titolare;

	public InfoLocale() {
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public byte[] getFotoLocale() {
		return this.fotoLocale;
	}

	public void setFotoLocale(byte[] fotoLocale) {
		this.fotoLocale = fotoLocale;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getInfoSupportoEmail() {
		return this.infoSupportoEmail;
	}

	public void setInfoSupportoEmail(String infoSupportoEmail) {
		this.infoSupportoEmail = infoSupportoEmail;
	}

	public String getInfoTel() {
		return this.infoTel;
	}

	public void setInfoTel(String infoTel) {
		this.infoTel = infoTel;
	}

	public String getNomeLocale() {
		return this.nomeLocale;
	}

	public void setNomeLocale(String nomeLocale) {
		this.nomeLocale = nomeLocale;
	}

	public String getPIva() {
		return this.pIva;
	}

	public void setPIva(String pIva) {
		this.pIva = pIva;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTitolare() {
		return this.titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

}
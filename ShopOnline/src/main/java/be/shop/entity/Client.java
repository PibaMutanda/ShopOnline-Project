package be.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Client.findByEmail", query = "select c from Client c where c.email:=email"),
		@NamedQuery(name = "Client.findAll", query = "select c from Client c"),
		@NamedQuery(name = "Client.findByDateInscr", query = "select c from Client c where c.dateInscription=:dateInscr") })
public class Client {

	@Id
	@GeneratedValue
	private Long id;

	private String nom;
	private String prenom;
	private String login;
	private String password;

	private String email;
	private String rue;
	private String cp;
	private String localite;

	private Boolean indesirable;

	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String image;

	@OneToMany(mappedBy = "client")
	List<Achat> achats = new ArrayList<Achat>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public Boolean getIndesirable() {
		return indesirable;
	}

	public void setIndesirable(Boolean indesirable) {
		this.indesirable = indesirable;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Long getId() {
		return id;
	}

}

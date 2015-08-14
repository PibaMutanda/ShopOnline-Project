package be.shop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Achats")
@NamedQueries({
		@NamedQuery(name = "Achat.findByDate", query = "select ac from Achat ac where ac.dateAchat=:date"),
		@NamedQuery(name = "Achat.findAll", query = "select a from Achat a"),
		@NamedQuery(name = "Achat.findByClient", query = "select a from Achat a where a.client=:client") })
public class Achat {

	@GeneratedValue
	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	@ManyToOne
	@JoinColumn
	private Client client;
    
	@ManyToOne
	@JoinColumn
	private Commande commande;


	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Long getId() {
		return id;
	}

}

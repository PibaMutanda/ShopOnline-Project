package be.shop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Achat.findByDate", query = "select a from Achat where a.dateAchat=:date"),
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

	public Long getId() {
		return id;
	}

}

package be.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	@ManyToOne
	@JoinColumn
	private Client client;
    
	@OneToMany(mappedBy="achat")
	private List<Commande> commandes = new ArrayList<Commande>();
	
    private double totalAchat;
    
    private int quantiteAchat;

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
    
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public void addCommande(Commande commande){
		this.commandes.add(commande);
	}
	public double getTotalAchat() {
		return totalAchat;
	}

	public void setTotalAchat(double totalAchat) {
		this.totalAchat = totalAchat;
	}
    
	public int getQuantiteAchat() {
		return quantiteAchat;
	}

	public void setQuantiteAchat(int quantiteAchat) {
		this.quantiteAchat = quantiteAchat;
	}

	public Long getId() {
		return id;
	}

}

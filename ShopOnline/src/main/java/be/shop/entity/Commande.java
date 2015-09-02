package be.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Commandes")
@NamedQueries({
		@NamedQuery(name = "Commande.findByClientAndDate", query = "select c from Commande c where c.dateCommande=:dateCommande and c.client=:client"),
		@NamedQuery(name = "Commande.findAll", query = "select c from Commande c"),
		@NamedQuery(name = "Commande.findByArticle", query = "select c from Commande c join c.articles a where a.id=:id"),
		@NamedQuery(name = "Commande.findByAchat", query = "select c from Commande c where c.achat=:achat"),
		@NamedQuery(name="Commande.findAllWithoutPurchase", query="select c from Commande c where c.achat is null"),
		@NamedQuery(name="Commande.findTenPurchaseOfClient", query="select c from Commande c where c.client=:client")})
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Achat achat;

	@OneToMany(mappedBy = "commande", fetch=FetchType.EAGER)
	private List<Article> articles = new ArrayList<Article>();

	private int quantite;

	private double totalCommande;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@ManyToOne
	private Client client;

	public Achat getAchat() {
		return achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void addArticle(Article article) {
		this.articles.add(article);
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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

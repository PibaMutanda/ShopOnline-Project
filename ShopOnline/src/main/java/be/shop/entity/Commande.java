package be.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Commandes")
@NamedQueries({
		@NamedQuery(name = "Commande.findAll", query = "select c from Commande c"),
		@NamedQuery(name = "Commande.findByArticle", query = "select c from Commande c join c.articles a where a.id=:id"),
		@NamedQuery(name = "Commande.findByAchat", query = "select c from Commande c where c.achat=:achat") })
public class Commande {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Achat achat;
	
	@OneToMany(mappedBy="commande")
	private List<Article> articles = new ArrayList<Article>();

	private int quantite;
	
	private double totalCommande;
	
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

	public void addArticle(Article article){
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

	public Long getId() {
		return id;
	}

}

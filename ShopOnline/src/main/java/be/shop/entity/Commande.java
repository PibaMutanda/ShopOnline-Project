package be.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "Commande.findAll", query = "select c from Commande c"),
		@NamedQuery(name = "Commande.findByArticle", query = "select c from Commande c join c.articles a where a.id=:id"),
		@NamedQuery(name = "Commande.findByAchat", query = " select c from Commande c where c.achat=:achat") })
public class Commande {

	@Id
	@GeneratedValue
	private Long id;
	@JoinColumn
	private Achat achat;
	@OneToMany
	private List<Article> articles = new ArrayList<Article>();

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

	public Long getId() {
		return id;
	}

}

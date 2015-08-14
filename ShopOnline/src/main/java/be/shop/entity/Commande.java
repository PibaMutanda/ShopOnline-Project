package be.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
		@NamedQuery(name = "Commande.findByAchat", query = "select c from Commande c join c.achats ca where ca.id =:achat") })
public class Commande {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="commande")
	private List<Achat> achats = new ArrayList<Achat>();
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Article> articles = new ArrayList<Article>();

	private int quantite;

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	
	public void addAchat(Achat achat){
		achats.add(achat);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

}

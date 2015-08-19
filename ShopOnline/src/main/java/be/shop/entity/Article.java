package be.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Articles")
@NamedQueries({
	    @NamedQuery(name = "Article.findByCommande", query = "select a from Article a where a.commande=:commande"),
		@NamedQuery(name = "Article.findByCateg", query = "select a from Article a where a.categ=:categ"),
		@NamedQuery(name = "Article.findAll", query = "select a from Article a") })
public class Article {

	@Id
	@GeneratedValue
	private Long id;

	private String denomination;
	private Double prix;
	private char enVente;
	
	@ManyToOne
	@JoinColumn
	private Commande commande;
	
	/*
	 * Quantité totale en stock pour un article*/
	private int qteTotale;
	
	

	@ManyToOne
	@JoinColumn
	private Categorie categ;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public char getEnVente() {
		return enVente;
	}

	public void setEnVente(char enVente) {
		this.enVente = enVente;
	}

	public Categorie getCateg() {
		return categ;
	}

	public void setCateg(Categorie categ) {
		this.categ = categ;
	}

	public int getQteTotale() {
		return qteTotale;
	}

	public void setQteTotale(int qteTotale) {
		this.qteTotale = qteTotale;
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

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
		@NamedQuery(name = "ArticleRepository.findByCateg", query = "select a from ArticleRepository a where a.categ=:categ"),
		@NamedQuery(name = "ArticleRepository.findAll", query = "select a from ArticleRepository a") })
public class Article {

	@Id
	@GeneratedValue
	private Long id;

	private String denomination;
	private Double prix;
	private Boolean enVente;

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

	public Boolean getEnVente() {
		return enVente;
	}

	public void setEnVente(Boolean enVente) {
		this.enVente = enVente;
	}

	public Categorie getCateg() {
		return categ;
	}

	public void setCateg(Categorie categ) {
		this.categ = categ;
	}

	public Long getId() {
		return id;
	}

}

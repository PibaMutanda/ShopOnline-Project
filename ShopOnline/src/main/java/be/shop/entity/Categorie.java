package be.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
@NamedQueries({
@NamedQuery(name = "Categorie.findAll", query = "select c from Categorie c"),
@NamedQuery(name = "Categorie.findByName", query = "select c from Categorie c where c.nom=:nom")})
public class Categorie {

	@Id
	@GeneratedValue
	private Long id;
    
	@Column(unique=true)
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

}

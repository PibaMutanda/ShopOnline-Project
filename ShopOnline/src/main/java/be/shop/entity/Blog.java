package be.shop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Blogs")
@NamedQueries({
		@NamedQuery(name = "Blog.findAll", query = "select b from Blog b"),
		@NamedQuery(name = "Blog.findByTitre", query = "select b from Blog b where b.titre like '%titre%'"), })
public class Blog {

	@Id
	@GeneratedValue
	private Long id;

	private String titre;

	private String texte;

	@Temporal(TemporalType.DATE)
	private Date dateBlog;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getDateBlog() {
		return dateBlog;
	}

	public void setDateBlog(Date dateBlog) {
		this.dateBlog = dateBlog;
	}

	public Long getId() {
		return id;
	}

}

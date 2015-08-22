package be.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CommentaireBlogs")
@NamedQuery(name = "CommentaireBlog.findByClient", query = "select cb from CommentaireBlog cb join cb.clients cl  where cl.id=:id")
public class CommentaireBlog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateComment;
	private String texteComment;
	@ManyToOne
	private Blog blog;
	@OneToMany
	List<Client> clients = new ArrayList<Client>();

	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public String getTexteComment() {
		return texteComment;
	}

	public void setTexteComment(String texteComment) {
		this.texteComment = texteComment;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Long getId() {
		return id;
	}

}

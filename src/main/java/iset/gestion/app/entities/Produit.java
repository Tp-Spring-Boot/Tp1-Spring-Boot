package iset.gestion.app.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit implements Serializable {
	@Id
	private String reference;
	private String designation;
	private double prix;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="codeClient")
	Client Client;
}

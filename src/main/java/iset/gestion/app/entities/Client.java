package iset.gestion.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor 
public class Client implements Serializable {
	    //private static final long serialVersionUID = 1L;
		@GeneratedValue (strategy = GenerationType.AUTO)
		@Id
		private Long idclient;
		private String nom;
		private String adresse;
		@OneToMany
		private Collection<Produit> produits;
}

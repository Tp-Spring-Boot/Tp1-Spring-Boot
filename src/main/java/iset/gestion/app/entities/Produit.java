package iset.gestion.app.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit implements Serializable {
	@Id
	@NotBlank(message = "reference is required")
	@Size(min = 4, max = 10)
	private String reference;
    @NotBlank(message = "designation is required")
	@Size(min = 4, max = 10)
	private String designation;
   	@Min(1)
	private double prix;
	@Min(1)
	private int quantite;
	@ManyToOne
	@JoinColumn(name="codeClient")
	Client Client;
}

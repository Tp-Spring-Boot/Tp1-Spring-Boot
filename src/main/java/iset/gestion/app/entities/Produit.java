package iset.gestion.app.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import groovyjarjarpicocli.CommandLine.Help.Ansi.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
	//private static final long serialVersionUID = 1L;
	@Id
	@NotBlank(message = "reference is required")
	@Size(min = 4, max = 10)
	private String reference;
	@NotBlank(message = "designation is required")
	@Size(min = 4, max = 10, message = "Designation required")
	private String designation;
	@Min(1)
	private double prix;
	@Column(columnDefinition = "longtext")
	private String photo_shema;
	@Min(1)
	private int quantite;
	  @ManyToOne
	  @JoinColumn(name = "Code_Client")
	  private Client client;
}

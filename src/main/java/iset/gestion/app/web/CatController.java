package iset.gestion.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iset.gestion.app.dao.ProduitRepository;
import iset.gestion.app.entities.Produit;

@RestController
public class CatController {
	@Autowired
	ProduitRepository produitRepository;
	@GetMapping(value="/")
	public String home() { return "Hello Spring Boot"; }
	
	
	@PostMapping(value="produit")
	public Produit AddProduit(@RequestBody Produit p) {
			return produitRepository.save(p);
	}

}

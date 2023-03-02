package iset.gestion.app.web;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iset.gestion.app.dao.ClientRepository;
import iset.gestion.app.dao.ProduitRepository;
import iset.gestion.app.entities.Client;
import iset.gestion.app.entities.Produit;

@Controller
public class CatController {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@GetMapping("/")
	public String search_produit(Model model,
			@RequestParam(name="search",defaultValue = "") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="per_page",defaultValue="2") int size,
			@RequestParam(name="message",defaultValue = "") String message) {
		
		Page<Produit> Produits=produitRepository.findByDesignationContains(mc,PageRequest.of(page, size));
		int totale=Produits.getTotalPages();
		int [] count_page=new int [totale];
		for(int i=0;i<totale;i++) {
			count_page[i]=i;
		}
		
		
		model.addAttribute("pages",count_page);
		model.addAttribute("page_current", page);
		model.addAttribute("search",mc);
		model.addAttribute("size",size);
		model.addAttribute("count_products", produitRepository.CountProducts());
		model.addAttribute("list_products", Produits);
		model.addAttribute("message_succes", message);
		return "pages/index";
	}
	
	@GetMapping(value="/delete_produit")
	public String deleteProduit(String id,int page,String search,int per_page) {
		produitRepository.deleteById(id);
		String message_succes="Delete with succes";
		return "redirect:/?search="+search+"&page="+page+"&per_page="+per_page+"&message="+message_succes;
	}
	
	@GetMapping(value="/addProduct")
	public String AddProduct(Model model) {
		Produit produit=new Produit();
		model.addAttribute("list_client", clientRepository.findAll());
		model.addAttribute("produit", produit);
		return "pages/addProduct";
	}
	
	@GetMapping(value="/updateView")
	public String updateView(String id,Model model) {
	    @SuppressWarnings("deprecation")
		Produit produit=produitRepository.getById(id);
		model.addAttribute("list_client", clientRepository.findAll());
		model.addAttribute("produit", produit);
		return "pages/UpdateProduct";
	}
	
	@PostMapping(value="/Addproduit")
	public String AddProduit(@ModelAttribute("produit") @Valid Produit p,
			BindingResult bindingResult) throws ParseException{
			if (bindingResult.hasErrors()) {
				 return "pages/addProduct";
			}
			produitRepository.save(p);
			String message_succes="Add Product with succes";
			return "redirect:/?message="+message_succes;
	}
	
	@PostMapping(value="/UpdateProduct")
	public String UpdateProduct(@ModelAttribute("produit") @Valid Produit p, BindingResult bindingResult) throws ParseException{
		if (bindingResult.hasErrors()) {
			return "pages/UpdateProduct";
		}	
		    produitRepository.save(p);
			String message_succes="Update Product with succes";
			return "redirect:/?message="+message_succes;
	}
	
	@GetMapping(value="ProductWithRef")
	public List<Produit> GetProduit(@RequestParam(name="ref") String ref) {
		return produitRepository.getproduct(ref);
	}
	
	@GetMapping(value="clientId")
	public List<Client> getclient(@RequestParam(name="id")long id){
		return clientRepository.getClient(id);
	}
	
	@GetMapping(value="allclient")
	public List<Client> allclient(){
		return clientRepository.findAll();
	}
	
	
	@GetMapping(value="productByPrix")
	public List<Produit> getAllProducts_prix(@RequestParam(name="prix") double prix){
		return produitRepository.getproduct_prix(prix);
	}
	
	@DeleteMapping(value="deleteClient")
	public void deleteClient(@RequestParam(name="id")long id) {
		clientRepository.deleteById(id);
	}
	
	@DeleteMapping(value="deleteProduit")
	public void deleteProduit(@RequestParam(name="ref")String id) {
		produitRepository.deleteById(id);
	}

}

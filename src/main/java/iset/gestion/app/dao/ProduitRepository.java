package iset.gestion.app.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Produit;
@EnableJpaRepositories
@RestResource
public interface ProduitRepository extends JpaRepository<Produit,String> {
	/*@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercherProduit(@Param("x") String mc,Pageable pageable);*/

	
    @Query("SELECT count(*) FROM Produit")
	int CountProducts();
    
	Page<Produit> findByDesignationContains(String mc,Pageable pageable);
	
	@Query(value="SELECT * FROM produit where reference=:ref",nativeQuery=true)
	List<Produit> getproduct(String ref);
	
	@Query(value="SELECT * from produit WHERE prix=:prix_choisit",nativeQuery = true)
	List<Produit> getproduct_prix(double prix_choisit);
	
}


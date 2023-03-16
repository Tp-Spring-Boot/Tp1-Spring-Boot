package iset.gestion.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Produit;
@EnableJpaRepositories

public interface ProduitRepository extends JpaRepository<Produit,String> {
	/*@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercherProduit(@Param("x") String mc,Pageable pageable);*/

    @Query("SELECT count(*) FROM Produit")
	int CountProducts();
    
    @Query("select max(prix)  from Produit")
    double max_produit();
    
    @Query("select min(prix)  from Produit")
    double min_produit();
 
	Page<Produit> findByDesignationContains(String mc,Pageable pageable);
	
	Page<Produit> findByPrixGreaterThan(double prix,Pageable pageable);
	
	@Query(value="SELECT * FROM produit where reference=:ref",nativeQuery=true)
	List<Produit> getproduct(String ref);
	
	@Query(value="SELECT * from produit order by prix DESC",nativeQuery = true)
	Page<Produit> OdrerByFields(@Param("x") String champ,Pageable pageable);
	
}


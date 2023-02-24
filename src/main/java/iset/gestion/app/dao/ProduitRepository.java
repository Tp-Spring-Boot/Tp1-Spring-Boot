package iset.gestion.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit,String> {
	/*@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercherProduit(@Param("x") String mc,Pageable pageable);
	public Page<Produit> findByDesignationContains(String mc,Pageable pageable);*/
}


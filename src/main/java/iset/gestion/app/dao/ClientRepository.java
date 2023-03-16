package iset.gestion.app.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iset.gestion.app.entities.Client;
import iset.gestion.app.entities.Produit;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface ClientRepository extends JpaRepository<Client,Long> {
	@Query(value="SELECT * FROM client WHERE idclient=:id",nativeQuery=true)
	List<Client> getClient(long id);
}

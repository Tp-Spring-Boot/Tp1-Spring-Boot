package iset.gestion.app.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Client;


@RestResource
public interface ClientRepository extends JpaRepository<Client,String> {
	//public Page<Client> findbyName(String mc,Pageable pageable);
}

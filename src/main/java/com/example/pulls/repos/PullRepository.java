package com.example.pulls.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.pulls.entities.Categorie;
import com.example.pulls.entities.Pull;

@RepositoryRestResource(path = "rest")
public interface PullRepository extends JpaRepository<Pull, Long> {
	List<Pull> findByNomPull(String nom);
	List<Pull> findByNomPullContains(String nom); 
	
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Pull> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Produit p where p.categorie = ?1")
	List<Pull> findByCategorie (Categorie categorie);
	
	List<Pull> findByCategorieIdCat(Long id);
	
	List<Pull> findByOrderByNomPullAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Pull> trierPullsNomsPrix ();

}

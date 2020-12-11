package com.example.pulls.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.pulls.entities.Categorie;
import com.example.pulls.entities.Pull;

public interface PullService {
	Pull savePull(Pull p);
	Pull updatePull(Pull p);
	void deletePull(Pull p);
	void deletePullById(Long id);
	Pull getPull(Long id);
	List<Pull> getAllPulls();
	List<Pull> findByNomPull(String nom);
	List<Pull> findByNomPullContains(String nom);
	List<Pull> findByNomPrix (String nom, Double prix);
	List<Pull> findByCategorie (Categorie categorie);
	List<Pull> findByCategorieIdCat(Long id);
	List<Pull> findByOrderByNomPullAsc();
	List<Pull> trierPullsNomsPrix();


}


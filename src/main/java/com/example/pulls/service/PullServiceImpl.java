package com.example.pulls.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pulls.entities.Categorie;
import com.example.pulls.entities.Pull;
import com.example.pulls.repos.PullRepository;

@Service
public class PullServiceImpl implements PullService{
	
	@Autowired
	PullRepository pullRepository; 

	@Override
	public Pull savePull(Pull p) {
		return pullRepository.save(p);
	}

	@Override
	public Pull updatePull(Pull p) {
		return pullRepository.save(p);
	}

	@Override
	public void deletePull(Pull p) {
		pullRepository.delete(p);
		
	}

	@Override
	public void deletePullById(Long id) {
		pullRepository.deleteById(id);
		
	}

	@Override
	public Pull getPull(Long id) {
		return pullRepository.findById(id).get();
	}

	@Override
	public List<Pull> getAllPulls() {
		return pullRepository.findAll();
	}
	
	public Page<Pull> getAllPullsParPage(int page, int size) {
	return pullRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Pull> findByNomPull(String nom) {
		return pullRepository.findByNomPull(nom);
	}
	@Override
	public List<Pull> findByNomPullContains(String nom) {
		return pullRepository.findByNomPullContains(nom);
	}
	@Override
	public List<Pull> findByNomPrix(String nom, Double prix) {
		return pullRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Pull> findByCategorie(Categorie categorie) {
		return pullRepository.findByCategorie(categorie);
	}
	@Override
	public List<Pull> findByCategorieIdCat(Long id) {
		return pullRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Pull> findByOrderByNomPullAsc() {
		return pullRepository.findByOrderByNomPullAsc();
	}
	@Override
	public List<Pull> trierPullsNomsPrix() {
		return pullRepository.trierPullsNomsPrix();
	}

}

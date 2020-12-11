package com.example.pulls;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.pulls.entities.Categorie;
import com.example.pulls.entities.Pull;
import com.example.pulls.repos.PullRepository;
import com.example.pulls.service.PullService;

@SpringBootTest
	class PullsApplicationTests {
@Autowired
	private PullRepository pullRepository;
@Test
	public void testCreatePull() {
	Pull p = new Pull("Puma",80.00,new Date(),"Cotton");
	pullRepository.save(p);
	}
	
@Test
	public void testFindpull(){
		Pull p = pullRepository.findById(1L).get();
		System.out.println(p);
	}
	
@Test
	public void testUpdatepull(){
		Pull p = pullRepository.findById(6L).get();
		p.setPrixPull(70.0);
		pullRepository.save(p);
	}
	
@Test
	public void testDeletepull(){
		pullRepository.deleteById(3L);;
	}

@Test
	public void testListerTouspulls(){
		List<Pull> prods = pullRepository.findAll();
			for (Pull p : prods){
					System.out.println(p);
			}
	}
@Test
	public void testFindByNomPullContains(){
		List<Pull> prods=pullRepository.findByNomPullContains("D&G");
		for (Pull p : prods)
		{
		System.out.println(p);
		} }
	/*ou bien
	for (Pull p : prods)
	{
	System.out.println(p);
	} */
	
	
@Test
	 public void testFindByNomPull(){
	 List<Pull> prods = pullRepository.findByNomPull("iphone X");
	 	for (Pull p : prods)
	 	{
	 		System.out.println(p);
	 	}
	 }
	 
@Test
	 public void testfindByNomPrix(){
	 List<Pull> prods = pullRepository.findByNomPrix("iphone X", 1000.0);
	 	for (Pull p : prods)
	 		{
	 			System.out.println(p);
	 		}
	 }
	 
@Test
	 public void testfindByCategorie(){
		 Categorie cat = new Categorie();
		 cat.setIdCat(1L);
		 List<Pull> prods = pullRepository.findByCategorie(cat);
		 	for (Pull p : prods){
		 		System.out.println(p);
		 	}
	}
	 
	 @Test
	 public void findByCategorieIdCat(){
		 List<Pull> prods = pullRepository.findByCategorieIdCat(1L);
		 for (Pull p : prods){
		 	System.out.println(p);
		 }
	  }
	 
@Test
	 public void testfindByOrderByNomPullAsc(){
	 	List<Pull> prods =
	 	pullRepository.findByOrderByNomPullAsc();
	 	for (Pull p : prods){
	 		System.out.println(p);
	 	}
	 }

@Test
	public void testTrierPullsNomsPrix(){
		List<Pull> prods = pullRepository.trierPullsNomsPrix();
		for (Pull p : prods){
			System.out.println(p);
		}
	}



}

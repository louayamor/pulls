package com.louay.pulls.restcontrollers;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.pulls.entities.Pull;
import com.example.pulls.service.PullService;
import com.fasterxml.jackson.annotation.JsonIgnore;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class PullRESTController {
@Autowired
	PullService PullService;
@RequestMapping(method = RequestMethod.GET)
	public List<Pull> getAllPulls() {
		return PullService.getAllPulls();
	}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Pull getPullById(@PathVariable("id") Long id) {
	return PullService.getPull(id);
	}

@RequestMapping(method = RequestMethod.POST)
	public Pull createPull(@RequestBody Pull pull) {
		return PullService.savePull(pull);
	}

@RequestMapping(method = RequestMethod.PUT)
	public Pull updatePull(@RequestBody Pull pull) {
		return PullService.updatePull(pull);
	}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deletePull(@PathVariable("id") Long id){
	PullService.deletePullById(id);
	}

@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Pull> getPullsByCatId(@PathVariable("idCat") Long idCat) {
		return PullService.findByCategorieIdCat(idCat);
	}
}
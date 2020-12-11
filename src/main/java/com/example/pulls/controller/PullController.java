package com.example.pulls.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pulls.entities.Pull;
import com.example.pulls.service.PullService;
import com.sun.el.parser.ParseException;

@Controller
public class PullController {
	
	
	@Autowired
	PullService PullService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap){
	modelMap.addAttribute("pull", new Pull());
		return "formPull";
	}


	@RequestMapping("/savePull")
	public String savePull(@Valid Pull pull,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formPull";

	PullService.savePull(pull);
	return "formProduit";
	}


	
	@RequestMapping("/ListePulls")
	public String listePulls(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size){
		Page<Pull> prods = PullService.getAllPullsParPage(page, size);
		modelMap.addAttribute("Pulls", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
			return "listePulls";
	}

	
	@RequestMapping("/supprimerpull")
	public String supprimerpull(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size){
		PullService.deletePullById(id);
		Page<Pull> prods = PullService.getAllPullsParPage(page, size);
		modelMap.addAttribute("pulls", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
			return "listepulls";
	}
	
	@RequestMapping("/savePull")
	public String savePull(@ModelAttribute("Pull") Pull pull){
		PullService.savePull(pull);
		return "createPull";
	}

	@RequestMapping("/updatepull")
	public String updatepull(@ModelAttribute("pull") Pull pull,
	@RequestParam("date") String date,
		ModelMap modelMap) throws ParseException, java.text.ParseException{
			//conversion de la date
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateFabrication = dateformat.parse(String.valueOf(date));
			pull.setDateFabrication(dateFabrication);

			PullService.updatePull(pull);
			List<Pull> prods = PullService.getAllPulls();
			modelMap.addAttribute("pulls", prods);
	 			return "listepulls";
		}	


}
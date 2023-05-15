package es.dsrroma.school.springboot.reuniones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dsrroma.school.springboot.reuniones.services.ReunionService;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {
	
	@Autowired
	private ReunionService reunionService;
	
	@GetMapping
	public String getAllReuniones(Model model) {
		model.addAttribute("reuniones", reunionService.getAllReuniones());
		return "reuniones";
	}
}

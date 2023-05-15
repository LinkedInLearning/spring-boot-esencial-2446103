package es.dsrroma.school.springboot.reuniones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dsrroma.school.springboot.reuniones.models.Persona;
import es.dsrroma.school.springboot.reuniones.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {
	
	private PersonaService personaService;

	public PersonaRestController(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@GetMapping
	public List<Persona> getAllPersonas() {
		return personaService.getAllPersonas();
	}

}

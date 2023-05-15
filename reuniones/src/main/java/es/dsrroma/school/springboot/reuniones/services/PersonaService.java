package es.dsrroma.school.springboot.reuniones.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.dsrroma.school.springboot.reuniones.models.Persona;

@Service
public class PersonaService {

	private static final List<Persona> personas = new ArrayList<>();

	static {
		for (int i = 0; i < 5; i++) {
			Persona persona = new Persona(i, "Nombre " + i, "Apellido " + i);
			personas.add(persona);
		}
	}

	public List<Persona> getAllPersonas() {
		return personas;
	}
}

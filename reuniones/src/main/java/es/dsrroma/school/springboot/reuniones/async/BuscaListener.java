package es.dsrroma.school.springboot.reuniones.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.dsrroma.school.springboot.reuniones.models.Persona;
import es.dsrroma.school.springboot.reuniones.models.Reunion;
import es.dsrroma.school.springboot.reuniones.services.PersonaService;
import es.dsrroma.school.springboot.reuniones.services.ReunionService;

@Component
public class BuscaListener {
	private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

	private final ObjectMapper mapper;
	private final PersonaService personaService;
	private final ReunionService reunionService;

	public BuscaListener(ObjectMapper mapper, PersonaService personaService, 
			ReunionService reunionService) {
		this.mapper = mapper;
		this.personaService = personaService;
		this.reunionService = reunionService;
	}

	public void recibirMensaje(String mensaje) {
		try {
			InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
			Persona persona = personaService.getById(info.getIdAsistente());
			Reunion reunion = reunionService.getById(info.getIdReunion());
			LOG.info("{} {} tiene una reunión a las {}", 
					persona.getNombre(), 
					persona.getApellidos(),
					reunion.getFecha());
		} catch (JsonProcessingException e) {
			LOG.warn("Mensaje incorrecto", e);
		}
	}
}
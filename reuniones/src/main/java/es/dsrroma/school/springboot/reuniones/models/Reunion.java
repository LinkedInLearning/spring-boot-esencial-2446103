package es.dsrroma.school.springboot.reuniones.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reunion {
	private long id;
	private String asunto;
	private ZonedDateTime fecha;
	private List<Persona> asistentes = new ArrayList<>();
	
	public Reunion() {
	}

	public Reunion(long id, String asunto, ZonedDateTime fecha) {
		this.id = id;
		this.asunto = asunto;
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public ZonedDateTime getFecha() {
		return fecha;
	}

	public void setFecha(ZonedDateTime fecha) {
		this.fecha = fecha;
	}
	
	public List<Persona> getAsistentes() {
		return asistentes;
	}
	
	public void addAsistente(Persona asistente) {
		asistentes.add(asistente);
	}
}
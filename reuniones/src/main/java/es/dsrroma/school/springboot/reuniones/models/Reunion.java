package es.dsrroma.school.springboot.reuniones.models;

import java.time.ZonedDateTime;

public class Reunion {
	private long id;
	private String asunto;
	private ZonedDateTime fecha;
	
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
}
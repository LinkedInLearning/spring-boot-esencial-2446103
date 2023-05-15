package es.dsrroma.school.springboot.reuniones.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String asunto;
	private ZonedDateTime fecha;
	
	@ManyToMany
	@JoinTable(name="asistente",
			joinColumns= {@JoinColumn(name="reunion_id")},
			inverseJoinColumns = {@JoinColumn(name="persona_id")})
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

	@Override
	public String toString() {
		return "Reunion [id=" + id + ", asunto=" + asunto + ", fecha=" + fecha + "]";
	}
}
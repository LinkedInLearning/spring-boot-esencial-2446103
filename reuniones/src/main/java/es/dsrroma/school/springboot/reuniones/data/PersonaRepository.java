package es.dsrroma.school.springboot.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dsrroma.school.springboot.reuniones.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}

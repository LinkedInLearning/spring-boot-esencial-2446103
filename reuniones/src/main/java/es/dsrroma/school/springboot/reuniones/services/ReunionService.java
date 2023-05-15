package es.dsrroma.school.springboot.reuniones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dsrroma.school.springboot.reuniones.data.ReunionRepository;
import es.dsrroma.school.springboot.reuniones.models.Reunion;

@Service
public class ReunionService {

	private final ReunionRepository reunionRepository;

	public ReunionService(ReunionRepository reunionRepository) {
		this.reunionRepository = reunionRepository;
	}

	public List<Reunion> getAllReuniones() {
		return reunionRepository.findAll();
	}
}

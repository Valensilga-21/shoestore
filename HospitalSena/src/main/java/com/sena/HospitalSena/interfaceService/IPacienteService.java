package com.sena.HospitalSena.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.HospitalSena.models.paciente;

public interface IPacienteService {
	
	public String save(paciente paciente);
	public List<paciente> findAll();
	public List<paciente> filtroPaciente(String filtro);
	public List<paciente> filtroDocumentoPaciente(String doc_paciente);
	public Optional<paciente> findOne(String id);
	public int delete(String id);
	
	
}



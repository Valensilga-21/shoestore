package com.sena.HospitalSena.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.HospitalSena.models.medico;

@Service
public interface IMedicoService {
	
	public String save(medico medico);
	public List<medico> findAll();
	public List<medico> filtroDocumentoMedico(String doc_medico);
	public Optional<medico> findOne(String id_medico);
	public int delete(String id_medico);
	List<medico> filtroMedico(String filtro);
	
	
}



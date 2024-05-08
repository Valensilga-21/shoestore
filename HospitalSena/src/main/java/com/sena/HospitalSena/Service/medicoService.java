package com.sena.HospitalSena.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.HospitalSena.interfaceService.IMedicoService;
import com.sena.HospitalSena.interfaces.IMedico;
import com.sena.HospitalSena.models.medico;


@Service
public class medicoService implements IMedicoService{
	@Autowired
	private IMedico data;

	@Override
	public String save(medico medico) {
		data.save(medico);
		return medico.getId_medico();
	}

	@Override
	public List<medico> findAll() {
		List<medico> listaMedico=
				(List<medico>) data.findAll();
		//(List<paciente>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <paciente>
		//- se convierte a list <paciente>
		return listaMedico;
	}
	
	@Override
	public List<medico> filtroMedico(String filtro) {
		List<medico> listaMedico=data.filtroMedico(filtro);
		return listaMedico;
	}
	
	@Override
	public Optional<medico> findOne(String id) {
		Optional<medico> medico=data.findById(id);
		return medico;

	}

	@Override
	public List<medico>filtroDocumentoMedico(String doc_medico ) {
		List<medico>listaMedico=data.filtroDocumentoMedico(doc_medico);
		return listaMedico;
	}


	@Override
	public int delete(String id_medico) {
		var medico=data.findById(id_medico).get();
		medico.setEstado_medico("Inactivo"); 
        data.save(medico); 
		return 0;
	}
}



package com.sena.HospitalSena.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.HospitalSena.interfaceService.IPacienteService;
import com.sena.HospitalSena.interfaces.IPaciente;
import com.sena.HospitalSena.models.paciente;


@Service
public class pacienteService implements IPacienteService{
	@Autowired
	private IPaciente data;

	@Override
	public String save(paciente paciente) {
		data.save(paciente);
		return paciente.getId_paciente();
	}

	@Override
	public List<paciente> findAll() {
		List<paciente> listaPaciente=
				(List<paciente>) data.findAll();
		//(List<paciente>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <paciente>
		//- se convierte a list <paciente>
		return listaPaciente;
	}

	@Override
	public List<paciente> filtroPaciente(String filtro) {
		List<paciente> listaPaciente=data.filtroPaciente(filtro);
		return listaPaciente;
	}
	

	@Override
	public Optional<paciente> findOne(String id) {
		Optional<paciente> paciente=data.findById(id);
		return paciente;

	}
	
	@Override
	public List<paciente>filtroDocumentoPaciente(String doc_paciente ) {
		List<paciente>ListaPaciente=data.filtroDocumentoPaciente(doc_paciente);
		return ListaPaciente;
	}

	@Override
	public int delete(String id_paciente) {
		var paciente=data.findById(id_paciente).get();
		paciente.setEstado_paciente("Inactivo"); 
        data.save(paciente); 
		return 0;
	}

}




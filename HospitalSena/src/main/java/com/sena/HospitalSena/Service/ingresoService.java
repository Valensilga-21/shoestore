package com.sena.HospitalSena.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.HospitalSena.interfaceService.IIngresoService;
import com.sena.HospitalSena.interfaces.IIngreso;
import com.sena.HospitalSena.models.ingreso;
import com.sena.HospitalSena.models.medico;


@Service
public class ingresoService implements IIngresoService{
	@Autowired
	private IIngreso data;

	@Override
	public String save(ingreso ingreso) {
		data.save(ingreso);
		return ingreso.getId_ingreso();
	}

	@Override
	public List<ingreso> findAll() {
		List<ingreso> listaIngreso=
				(List<ingreso>) data.findAll();
		//(List<paciente>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <paciente>
		//- se convierte a list <paciente>
		return listaIngreso;
	}
	
	@Override
	public List<ingreso> filtroIngreso(String filtro) {
		List<ingreso> ListaIngreso=data.filtroIngreso(filtro);
		return ListaIngreso;	
	}
	
	@Override
	public List<ingreso> filtroFecha_ingre(Date fecha_ingre) {
		List<ingreso> ListaIngreso=data.filtroFecha_ingre(fecha_ingre);
		return ListaIngreso;	
	}

	@Override
	public Optional<ingreso> findOne(String id) {
		Optional<ingreso> ingreso=data.findById(id);
		return ingreso;

	}

	@Override
	public List<ingreso> filtroCama (String cama, String habitacion) {
		List<ingreso>ListaIngreso=data.filtroCama(cama, habitacion);
		return ListaIngreso;
	}
	
	@Override
	public int delete(String id_ingreso) {
		var ingreso=data.findById(id_ingreso).get();
		ingreso.setEstado("Inactivo"); 
        data.save(ingreso); 
		return 0;
	}
	
	//almacena registros
	@Override
	public List<ingreso> filtroEstado(String id_paciente) {
		List<ingreso>ListaIngreso=data.filtroEstado(id_paciente);
		return ListaIngreso;
	}

}


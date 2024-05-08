package com.sena.HospitalSena.interfaceService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.HospitalSena.models.ingreso;
@Service
public interface IIngresoService {
	
	public String save(ingreso ingreso);
	public List<ingreso> findAll();
	public List<ingreso> filtroIngreso(String filtro);
	public List<ingreso> filtroFecha_ingre(Date fecha_ingre);
	public Optional<ingreso> findOne(String id);
	public int delete(String id_ingreso);
	public List<ingreso> filtroCama(String cama, String habitacion);
	public List<ingreso> filtroEstado(String id_paciente);
	
}


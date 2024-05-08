package com.sena.HospitalSena.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.HospitalSena.interfaceService.IIngresoService;
import com.sena.HospitalSena.models.ingreso;
import com.sena.HospitalSena.models.paciente;

import consultorio.com.consultorio.models.Ingreso;


@RequestMapping("/api/hospital/ingreso")
@RestController
@CrossOrigin
public class ingresoController {
	
	@Autowired
	private IIngresoService ingresoService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save( @ModelAttribute("Ingreso") ingreso Ingreso) {
        var listaIngreso = ingresoService.findAll()
                .stream().filter(ingreso -> ingreso.getCama()
                        .equals(Ingreso.getCama())).
                        filter(ingreso->ingreso.getHabitacion().equals(Ingreso.getHabitacion())).
                        filter(ingreso->ingreso.getEstado().equals("Activo"));
        if (listaIngreso.count() != 0) {
            return new ResponseEntity<>("La cama está ocupada", HttpStatus.BAD_REQUEST);
        }
        listaIngreso = ingresoService.findAll()
                .stream().filter(ingreso -> ingreso.getPaciente()
                        .equals(Ingreso.getPaciente())).
                        filter(ingreso->ingreso.getPaciente().equals(Ingreso.getPaciente())).
                        filter(ingreso->ingreso.getEstado().equals("Activo"));
        if (listaIngreso.count() != 0) {
        return new ResponseEntity<>("El paciente ya se encuentra en el sistema", HttpStatus.BAD_REQUEST);
        }  
        
        
        if (Ingreso.getHabitacion().equals("")) {

            return new ResponseEntity<>("La habitación es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Ingreso.getCama().equals("")) {
            
            return new ResponseEntity<>("La cama es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Ingreso.getFecha_ingreso().equals("")) {
            
            return new ResponseEntity<>("La fecha de ingreso es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Ingreso.getFecha_salida().equals("")) {
            
            return new ResponseEntity<>("La fecha de salida es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Ingreso.getEstado().equals("")) {
            
            return new ResponseEntity<>("El estado es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        ingresoService.save(Ingreso);
        return new ResponseEntity<>(Ingreso, HttpStatus.OK);

    }

	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var ListaIngreso=ingresoService.findAll();
		return new ResponseEntity<>(ListaIngreso,HttpStatus.OK);
	}

	@GetMapping("/busqueda/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		
		
	
	      Date  fechaFiltro=null;
	      try {
	    	  fechaFiltro=Date.valueOf(filtro);  
	      }catch (Exception e) {
		
		}
	         
		if(fechaFiltro!=null) {
			var ListaIngreso=ingresoService.filtroFecha_ingre(fechaFiltro);
			return new ResponseEntity<>(ListaIngreso,HttpStatus.OK);		
		}
		
		
	var ListaIngreso=ingresoService.filtroIngreso(filtro);
	return new ResponseEntity<>(ListaIngreso,HttpStatus.OK);
	}


	
	@GetMapping("/{id_ingreso}")
	public ResponseEntity<Object> findOne(@PathVariable String id_ingreso){
		var ingreso=ingresoService.findOne(id_ingreso);
		return new ResponseEntity<>(ingreso,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_ingreso}")
	public ResponseEntity<Object> delete(@PathVariable String id_ingreso){
		ingresoService.delete(id_ingreso);
		return new ResponseEntity<>("Registro Deshabilitado",HttpStatus.OK);
	}
	
	@PutMapping("/{id_ingreso}")
	public ResponseEntity<Object> update(@PathVariable String id_ingreso, @ModelAttribute("ingreso") ingreso ingresoUpdate){
		var ingreso=ingresoService.findOne(id_ingreso).get();
		if (ingreso != null) {
			ingreso.setHabitacion(ingresoUpdate.getHabitacion());
			ingreso.setCama(ingresoUpdate.getCama());
			ingreso.setPaciente(ingresoUpdate.getPaciente());
			ingreso.setMedico(ingresoUpdate.getMedico());
			ingreso.setFecha_ingreso(ingresoUpdate.getFecha_ingreso());
			ingreso.setFecha_salida(ingresoUpdate.getFecha_salida());
			ingreso.setEstado(ingresoUpdate.getEstado());

			ingresoService.save(ingreso);
			return new ResponseEntity<>(ingreso,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error ingreso no encontrado",HttpStatus.BAD_REQUEST);
		}
	}

}


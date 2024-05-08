package com.sena.HospitalSena.controller;

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

import com.sena.HospitalSena.interfaceService.IMedicoService;
import com.sena.HospitalSena.models.medico;


@RequestMapping("/api/hospital/medico")
@RestController
@CrossOrigin
public class medicoController {
	
	
	@Autowired
	private IMedicoService medicoService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("Medico") medico Medico) {

        // verificar que no exista el documento de identidad
        var listaMedico = medicoService.findAll()
                .stream().filter(medico -> medico.getDoc_medico()
                        .equals(Medico.getDoc_medico()));
        if (listaMedico.count() != 0) {
            return new ResponseEntity<>("El medico ya existe", HttpStatus.BAD_REQUEST);
        }
        listaMedico = medicoService.findAll()
                .stream().filter(medico -> medico.getCorreo_medico()
                        .equals(Medico.getCorreo_medico()));
        if (listaMedico.count() != 0) {
            return new ResponseEntity<>("El correo ya existe", HttpStatus.BAD_REQUEST);
        }
        //verificar que el campo documento de identidad sea diferente vacio
        //Añadir campos obligatorios
        //no cambiar nada
        if (Medico.getDoc_medico().equals("")) {

            return new ResponseEntity<>("El documento de identidad es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Medico.getPrimer_nombre_medico().equals("")) {
            
            return new ResponseEntity<>("El primer nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Medico.getPrimer_apellido_medico().equals("")) {
            
            return new ResponseEntity<>("El primer apellido es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Medico.getTelefono_medico().equals("")) {
            
            return new ResponseEntity<>("El numero de celular es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Medico.getCorreo_medico().equals("")) {
            
            return new ResponseEntity<>("La direccion de correo es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Medico.getEstado_medico().equals("")) {
            
            return new ResponseEntity<>("El estado es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        
        // todo bien
        medicoService.save(Medico);
        return new ResponseEntity<>(Medico, HttpStatus.OK);

    }

	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
	var ListaMedico=medicoService.findAll();
	return new ResponseEntity<>(ListaMedico,HttpStatus.OK);
	}


@GetMapping("/busqueda/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
	var ListaMedico=medicoService.filtroMedico(filtro); 
	return new ResponseEntity<>(ListaMedico,HttpStatus.OK);
	}
	
	@GetMapping("/{id_medico}")
	public ResponseEntity<Object> findOne(@PathVariable String id_medico){
		var medico=medicoService.findOne(id_medico);
		return new ResponseEntity<>(medico,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_medico}")
	public ResponseEntity<Object> delete(@PathVariable String id_medico){
		medicoService.delete(id_medico);
		return new ResponseEntity<>("Registro Dehabilitado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("medico") medico medicoUpdate){
		var medico=medicoService.findOne(id).get();
		if (medico != null) {
			medico.setDoc_medico(medicoUpdate.getDoc_medico());
			medico.setPrimer_nombre_medico(medicoUpdate.getPrimer_nombre_medico());
			medico.setSegundo_nombre_medico(medicoUpdate.getSegundo_nombre_medico());
			medico.setPrimer_apellido_medico(medicoUpdate.getPrimer_apellido_medico());
			medico.setSegundo_apellido_medico(medicoUpdate.getSegundo_apellido_medico());
			medico.setTelefono_medico(medicoUpdate.getTelefono_medico());
			medico.setCorreo_medico(medicoUpdate.getCorreo_medico());
			medico.setEstado_medico(medicoUpdate.getEstado_medico());

			medicoService.save(medico);
			return new ResponseEntity<>(medico,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error medico no encontrado",HttpStatus.BAD_REQUEST);
		}
	}

}



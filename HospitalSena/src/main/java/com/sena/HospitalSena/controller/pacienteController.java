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

import com.sena.HospitalSena.interfaceService.IPacienteService;

import com.sena.HospitalSena.models.paciente;




@RequestMapping("/api/hospital/paciente")
@RestController
@CrossOrigin
public class pacienteController {
	
	@Autowired
	private IPacienteService pacienteService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("Paciente") paciente Paciente) {

        // verificar que no exista el documento de identidad
        var listaPaciente = pacienteService.findAll()
                .stream().filter(paciente -> paciente.getDoc_paciente()
                        .equals(paciente.getDoc_paciente()));
        if (listaPaciente.count() != 0) {
            return new ResponseEntity<>("El paciente ya existe", HttpStatus.BAD_REQUEST);
        }
        
        
        if (Paciente.getDoc_paciente().equals("")) {

            return new ResponseEntity<>("El documento de identidad es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Paciente.getPrimer_nombre_paciente().equals("")) {
            
            return new ResponseEntity<>("El primer nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Paciente.getPrimer_apellido_paciente().equals("")) {
            
            return new ResponseEntity<>("El primer apellido es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Paciente.getTelefono_paciente().equals("")) {
            
            return new ResponseEntity<>("El numero de celular es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Paciente.getCorreo_paciente().equals("")) {
            
            return new ResponseEntity<>("La direccion de correo es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Paciente.getNombre_percontac().equals("")) {
            
            return new ResponseEntity<>("El nombre de la persona de contacto es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Paciente.getTel_percontac().equals("")) {
            
            return new ResponseEntity<>("El numero de celular de la persona de contacto es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Paciente.getEstado_paciente().equals("")) {
            
            return new ResponseEntity<>("El numero de celular de la persona de contacto es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        pacienteService.save(Paciente);
        return new ResponseEntity<>(Paciente, HttpStatus.OK);

    }

	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var ListaPaciente=pacienteService.findAll();
		return new ResponseEntity<>(ListaPaciente,HttpStatus.OK);
	}
	
	@GetMapping("/busqueda/{filtro}")
	public ResponseEntity<Object> findfiltro(@PathVariable String filtro){
	var ListaPaciente=pacienteService.filtroPaciente(filtro);
	return new ResponseEntity<>(ListaPaciente,HttpStatus.OK);
	}

	@GetMapping("/{id_paciente}")
	public ResponseEntity<Object> findOne(@PathVariable String id_paciente){
		var paciente=pacienteService.findOne(id_paciente);
		return new ResponseEntity<>(paciente,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_paciente}")
	public ResponseEntity<Object> delete(@PathVariable String id_paciente){
		pacienteService.delete(id_paciente);
		return new ResponseEntity<>("Registro Deshabilitado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("paciente") paciente pacienteUpdate){
		var paciente=pacienteService.findOne(id).get();
		if (paciente != null) {
			paciente.setDoc_paciente(pacienteUpdate.getDoc_paciente());
			paciente.setPrimer_nombre_paciente(pacienteUpdate.getPrimer_nombre_paciente());
			paciente.setSegundo_nombre_paciente(pacienteUpdate.getSegundo_nombre_paciente());
			paciente.setPrimer_apellido_paciente(pacienteUpdate.getPrimer_apellido_paciente());
			paciente.setSegundo_apellido_paciente(pacienteUpdate.getSegundo_apellido_paciente());
			paciente.setTelefono_paciente(pacienteUpdate.getTelefono_paciente());
			paciente.setCorreo_paciente(pacienteUpdate.getCorreo_paciente());
			paciente.setNombre_percontac(pacienteUpdate.getNombre_percontac());
			paciente.setTel_percontac(pacienteUpdate.getTel_percontac());
			paciente.setEstado_paciente(pacienteUpdate.getEstado_paciente());

			pacienteService.save(paciente);
			return new ResponseEntity<>(paciente,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error paciente no encontrado",HttpStatus.BAD_REQUEST);
		}
	}

}



package com.sena.shoestore.controller;

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

import com.sena.shoestore.InterfaceService.IClienteService;
import com.sena.shoestore.models.clientes;


@RequestMapping("/api/shoestore/cliente")
@RestController
@CrossOrigin
public class clienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("clientes") clientes clientes) {

        if (clientes.getTipo_identificacion().equals("")) {

            return new ResponseEntity<>("El tipo de indetificacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (clientes.getIdentificacion().equals("")) {
            
            return new ResponseEntity<>("El numero de identificacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (clientes.getNombre_cliente().equals("")) {
            
            return new ResponseEntity<>("El nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (clientes.getApellido_cliente().equals("")) {
            
            return new ResponseEntity<>("El apellido es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (clientes.getTelefono().equals("")) {
            
            return new ResponseEntity<>("La numero de telefono es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (clientes.getDireccion().equals("")) {
            
            return new ResponseEntity<>("La direccion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (clientes.getCiudad().equals("")) {
            
            return new ResponseEntity<>("La ciudad es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (clientes.getCorreo_electronico().equals("")) {
            
            return new ResponseEntity<>("El correo electronico es un capo obligatorio es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        clienteService.save(clientes);
        return new ResponseEntity<>(clientes, HttpStatus.OK);

    }


	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
	var ListaCliente=clienteService.findAll();
	return new ResponseEntity<>(ListaCliente,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_cliente}")
	public ResponseEntity<Object> findOne(@PathVariable String id_cliente){
		var clientes=clienteService.findOne(id_cliente);
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_cliente}")
	public ResponseEntity<Object> delete(@PathVariable String id_cliente){
		clienteService.delete(id_cliente);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("clientes") clientes clientesUpdate){
		var clientes=clienteService.findOne(id).get();
		if (clientes != null) {
			clientes.setTipo_identificacion(clientesUpdate.getTipo_identificacion());
			clientes.setIdentificacion(clientesUpdate.getIdentificacion());
			clientes.setNombre_cliente(clientesUpdate.getNombre_cliente());
			clientes.setApellido_cliente(clientesUpdate.getApellido_cliente());
			clientes.setTelefono(clientesUpdate.getTelefono());
			clientes.setDireccion(clientesUpdate.getDireccion());
			clientes.setCiudad(clientesUpdate.getCiudad());
			clientes.setCorreo_electronico(clientesUpdate.getCorreo_electronico());
			clientes.setEstado(clientesUpdate.getEstado());

			clienteService.save(clientes);
			return new ResponseEntity<>(clientes,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error cliente no encontrado",HttpStatus.BAD_REQUEST);
		}
	}

}

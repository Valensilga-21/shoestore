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

import com.sena.shoestore.InterfaceService.IProductoService;
import com.sena.shoestore.models.productos;

@RequestMapping("/api/shoestore/producto")
@RestController
@CrossOrigin
public class productoController{
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("productos") productos productos) {

        if (productos.getNombre_producto().equals("")) {

            return new ResponseEntity<>("El nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (productos.getDescripcion().equals("")) {
            
            return new ResponseEntity<>("El numero de identificacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (productos.getCantidad().equals("")) {
            
            return new ResponseEntity<>("La cantidad es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (productos.getPrecio().equals("")) {
            
            return new ResponseEntity<>("El precio es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (productos.getPorcentaje_iva().equals("")) {
            
            return new ResponseEntity<>("El porcentaje de iva es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (productos.getEstado().equals("")) {
            
            return new ResponseEntity<>("El estado es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        productoService.save(productos);
        return new ResponseEntity<>(productos, HttpStatus.OK);

    }


	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
	var ListaProductos=productoService.findAll();
	return new ResponseEntity<>(ListaProductos,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_producto}")
	public ResponseEntity<Object> findOne(@PathVariable String id_producto){
		var productos=productoService.findOne(id_producto);
		return new ResponseEntity<>(productos,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_producto}")
	public ResponseEntity<Object> delete(@PathVariable String id_producto){
		productoService.delete(id_producto);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("productos") productos productosUpdate){
		var productos=productoService.findOne(id).get();
		if (productos != null) {
			productos.setNombre_producto(productosUpdate.getNombre_producto());
			productos.setDescripcion(productosUpdate.getDescripcion());
			productos.setCantidad(productosUpdate.getCantidad());
			productos.setPrecio(productosUpdate.getPrecio());
			productos.setPorcentaje_iva(productosUpdate.getPorcentaje_iva());
			productos.setPorcentaje_descuento(productosUpdate.getPorcentaje_descuento());
			productos.setEstado(productosUpdate.getEstado());

			productoService.save(productos);
			return new ResponseEntity<>(productos,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error producto no encontrado",HttpStatus.BAD_REQUEST);
		}
	}

}
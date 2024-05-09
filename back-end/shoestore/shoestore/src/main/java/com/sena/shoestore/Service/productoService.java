<<<<<<< HEAD
package com.sena.shoestore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.InterfaceService.IProductoService;
import com.sena.shoestore.Interfaces.IProductos;
import com.sena.shoestore.models.productos;

@Service
public class productoService implements IProductoService{
	
	@Autowired
	private IProductos data;

	@Override
	public String save(productos productos) {
		data.save(productos);
		return productos.getId_producto();
	}
	
	@Override
	public List<productos> findAll() {
		List<productos> listaProducto=
		(List<productos>) data.findAll();
		return listaProducto;
	}
	
	@Override
	public Optional<productos> findOne(String id) {
		Optional<productos> productos=data.findById(id);
		return productos;

	}

	@Override
	public int delete(String id_producto) {
	    try {
	        data.deleteById(id_producto);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
}
=======
package com.sena.shoestore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.InterfaceService.IProductoService;
import com.sena.shoestore.Interfaces.IProductos;
import com.sena.shoestore.models.productos;

@Service
public class productoService implements IProductoService{
	
	@Autowired
	private IProductos data;

	@Override
	public String save(productos productos) {
		data.save(productos);
		return productos.getId_producto();
	}
	
	@Override
	public List<productos> findAll() {
		List<productos> listaProducto=
		(List<productos>) data.findAll();
		return listaProducto;
	}
	
	@Override
	public Optional<productos> findOne(String id) {
		Optional<productos> productos=data.findById(id);
		return productos;

	}

	@Override
	public int delete(String id_producto) {
		return 0;
	}
}
>>>>>>> a8788167102ed202bea9d6fd6c60e9091c3ce0ac

<<<<<<< HEAD
package com.sena.shoestore.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.shoestore.models.productos;

public interface IProductoService {
	
	public String save(productos productos);
	public List<productos> findAll();
	public Optional<productos> findOne(String id_productos);
	public int delete(String id_productos);

}
=======
package com.sena.shoestore.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.shoestore.models.productos;

public interface IProductoService {
	
	public String save(productos productos);
	public List<productos> findAll();
	public Optional<productos> findOne(String id_productos);
	public int delete(String id_productos);

}
>>>>>>> a8788167102ed202bea9d6fd6c60e9091c3ce0ac

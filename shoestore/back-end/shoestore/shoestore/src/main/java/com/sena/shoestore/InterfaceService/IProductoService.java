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

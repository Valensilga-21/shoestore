package com.sena.shoestore.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.sena.shoestore.models.clientes;

@Repository
public interface IClientes extends CrudRepository<clientes, String>{
	
	@Query("SELECT c FROM clientes c WHERE c.nombre_cliente LIKE %?1% OR c.ciudad LIKE %?1% OR c.estado LIKE %?1%")
	
	List<clientes> filtroClientes(String filtro);


}

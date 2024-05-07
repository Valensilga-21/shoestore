package com.sena.shoestore.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.shoestore.models.clientes;

public interface IClienteService {

	public String save(clientes clientes);
	public List<clientes> findAll();
	public Optional<clientes> findOne(String id_cliente);
	public int delete(String id_cliente);

}

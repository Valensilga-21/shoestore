package com.sena.shoestore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.InterfaceService.IClienteService;
import com.sena.shoestore.Interfaces.IClientes;
import com.sena.shoestore.models.clientes;

@Service
public class clienteService implements IClienteService{

	@Autowired
	private IClientes data;
	
	@Override
	public String save(clientes clientes) {
		data.save(clientes);
		return clientes.getId_cliente();
	}
	
	@Override
	public List<clientes> findAll() {
		List<clientes> listaClientes=
		(List<clientes>) data.findAll();
		return listaClientes;
	}
	
	@Override
	public Optional<clientes> findOne(String id) {
		Optional<clientes> clientes=data.findById(id);
		return clientes;

	}

	@Override
	public int delete(String id_cliente) {
	    try {
	        data.deleteById(id_cliente);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

}

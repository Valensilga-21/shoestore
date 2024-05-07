package com.sena.shoestore.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.shoestore.models.clientes;

@Repository
public interface IClientes extends CrudRepository<clientes, String>{

}

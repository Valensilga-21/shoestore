package com.sena.shoestore.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.shoestore.models.productos;

@Repository
public interface IProductos extends CrudRepository<productos, String> {

}

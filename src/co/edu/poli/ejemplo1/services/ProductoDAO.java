package co.edu.poli.ejemplo1.services;

import java.util.List;

import co.edu.poli.ejemplo1.model.Producto;

public interface ProductoDAO {

	List<Producto> findByPriceGreaterThan(double price) throws Exception;

}
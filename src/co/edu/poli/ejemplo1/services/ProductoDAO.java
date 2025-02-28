package co.edu.poli.ejemplo1.services;

import java.util.List;
import co.edu.poli.ejemplo1.model.Producto;

// Interfaz que define un método para buscar productos por precio
public interface ProductoDAO {
	List<Producto> findByPriceGreaterThan(double price) throws Exception;
}
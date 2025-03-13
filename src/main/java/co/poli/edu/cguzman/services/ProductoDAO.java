package co.poli.edu.cguzman.services;

import java.util.List;

import co.poli.edu.cguzman.modelo.Producto;


// Interfaz que define un método para buscar productos por precio
public interface ProductoDAO extends GenericDAO<Producto, String> {
	List<Producto> findByPriceGreaterThan(double price) throws Exception;
}
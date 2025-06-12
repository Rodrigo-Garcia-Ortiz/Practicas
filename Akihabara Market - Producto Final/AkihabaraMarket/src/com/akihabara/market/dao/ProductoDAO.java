package com.akihabara.market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.akihabara.market.model.ProductoOtaku;

public class ProductoDAO {
	
	private DatabaseConnection conectar;
	
	
	public ProductoDAO() {
		conectar = new DatabaseConnection();
	}


	public void agregarProducto(ProductoOtaku producto) { //Registra un nuevo producto en la base de datos
		
		try { 
			
			String sql = "INSERT INTO producto (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			stmt.setString(1, producto.getNombre());
			stmt.setString(2, producto.getCategoria());
			stmt.setDouble(3, producto.getPrecio());
			stmt.setInt(4, producto.getStock());
			
			stmt.executeUpdate();		
			
			stmt.close();
			
			System.out.println("Producto agregado correctamente");
			
		} catch (Exception e) { 
			
			System.out.println("Error al registrar el producto: " + e.getMessage());
		}
		
	}
	
	public ProductoOtaku obtenerProductoPorId(int id) { //Busca un producto concreto sabiendo su id
		
        try { 
			
			String sql = "Select * from producto where id = ?";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			ProductoOtaku resultado;
			
			if (rs.next()) {
				
				resultado = new ProductoOtaku(rs.getInt("id"), rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"));
			}
			
			else {
				
				resultado = null;
			}
			
			rs.close();
			stmt.close();
			
			return resultado;
			
		} catch (Exception e) { 
			
			System.out.println("Error al buscar el producto: " + e.getMessage());
			
			return null;
		}
	}
	
	public List<ProductoOtaku> obtenerTodosLosProductos() { //Busca todos los productos registrados
		
        try { 
        	
        	List<ProductoOtaku> productos = new ArrayList<>();
        	
			String sql = "Select * from producto";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			ProductoOtaku producto;
			
			while (rs.next()) {
				
				producto = new ProductoOtaku(rs.getInt("id"), rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"));
				
				productos.add(producto);
			}
			
			rs.close();
			stmt.close();
			
			return productos;
			
		} catch (Exception e) { 
			
			System.out.println("Error al buscar los productos: " + e.getMessage());
			
			return null;
		}
	}
	
	public boolean actualizarProducto(ProductoOtaku producto) { //Actualiza los datos de un producto indicado
		
		try { 
			
			String sql = "update producto set nombre = ?, categoria = ?, precio = ?, stock = ? where id = ?";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			stmt.setString(1, producto.getNombre());
			stmt.setString(2, producto.getCategoria());
			stmt.setDouble(3, producto.getPrecio());
			stmt.setInt(4, producto.getStock());
			stmt.setInt(5, producto.getID());
			
			stmt.executeUpdate();		
			
			stmt.close();
			
			System.out.println("Producto actualizado correctamente");
			
			return true;
			
		} catch (Exception e) { 
			
			System.out.println("Error al actualizar el producto: " + e.getMessage());
			
			return false;
		}
	}
	
	public boolean eliminarProducto(int id) { //Elimina el producto indicado
		
		try { 
			
			String sql = "delete from producto where id = ?";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.executeUpdate();		
			
			stmt.close();
			
			System.out.println("Producto eliminado correctamente");
			return true;
			
		} catch (Exception e) { 
			
			System.out.println("Error al eliminar el producto: " + e.getMessage());
			
			return false;
		}
	}
	
	public List<ProductoOtaku> buscarProductosPorNombre(String nombre) { //Devuelve los productos cuyo nombre contenga el texto indicado
		
		try { 
			
			List<ProductoOtaku> productos = new ArrayList<>();
			
			String sql = "Select * from producto where nombre like ?";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			stmt.setString(1, nombre);
			
			ResultSet rs = stmt.executeQuery();
			
			ProductoOtaku resultado;
			
			while (rs.next()) {
				
				resultado = new ProductoOtaku(rs.getInt("id"), rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"));
				productos.add(resultado);
			}
			
			rs.close();
			stmt.close();
			
			return productos;
			
		} catch (Exception e) { 
			
			System.out.println("Error al buscar los productos: " + e.getMessage());
			
			return null;
		}
	}
	
	public List<ProductoOtaku> buscarProductoPorCategoria(String categoria) { //Devuelve los productos de la categoria indicada
		
    try { 
        	
        	List<ProductoOtaku> productos = new ArrayList<>();
        	
			String sql = "Select * from producto where categoria = ?";
			PreparedStatement stmt = conectar.getConexion().prepareStatement(sql);
			
			stmt.setString(1, categoria);
			
			ResultSet rs = stmt.executeQuery();
			
			ProductoOtaku producto;
			
			while (rs.next()) {
				
				producto = new ProductoOtaku(rs.getInt("id"), rs.getString("nombre"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"));
				
				productos.add(producto);
			}
			
			rs.close();
			stmt.close();
			
			return productos;
			
		} catch (Exception e) { 
			
			System.out.println("Error al buscar los productos: " + e.getMessage());
			
			return null;
		}
	}
}

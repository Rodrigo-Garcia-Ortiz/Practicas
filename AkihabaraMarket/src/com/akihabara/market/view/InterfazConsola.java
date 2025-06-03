package com.akihabara.market.view;

import java.util.List;
import java.util.Scanner;
import com.akihabara.market.model.*;
import com.akihabara.market.dao.*;

public class InterfazConsola {
	
	static String saltoDeLinea;
	
	ProductoDAO funciones = new ProductoDAO();
	
	Scanner obj = new Scanner(System.in);
	
	public int menu() { //Muestra el menú principal
		
		System.out.println("1. Registrar producto");
		System.out.println("2. Buscar producto por ID");
		System.out.println("3. Listar productos");
		System.out.println("4. Buscar productos por nombre");
		System.out.println("5. Buscar productos por categoria");
		System.out.println("6. Actualizar producto");
		System.out.println("7. Eliminar producto");
		System.out.println("8. Salir");
		System.out.println();
		
		System.out.println("Escoge una opción:");
		int opcion = obj.nextInt();
		System.out.println();
		saltoDeLinea = obj.nextLine();
		
		return opcion;
	}
	
	public ProductoOtaku registrar() { //Recoge los datos para registrar un nuevo producto
		
		System.out.println("Introduce el ID del producto:");
		int id = obj.nextInt();
		System.out.println();
		saltoDeLinea = obj.nextLine();
		
		System.out.println("Introduce el nombre del producto:");
		String nombre = obj.nextLine();
		System.out.println();
		saltoDeLinea = obj.nextLine();
		
		System.out.println("Introduce la categoria del producto:");
		String categoria = obj.nextLine();
		System.out.println();
		
		System.out.println("Introduce el precio del producto:");
		double precio = obj.nextDouble();
		System.out.println();
		
		System.out.println("Introduce el stock del producto:");
		int stock = obj.nextInt();
		System.out.println();
		
		ProductoOtaku producto = new ProductoOtaku(id, nombre, categoria, precio, stock);
		return producto;
	}
	
	public ProductoOtaku buscarPorId() { //Recoge un producto con un id indicado
		
		System.out.println("Introduce el ID del producto:");
		int id = obj.nextInt();
		System.out.println();
		
		ProductoOtaku producto =funciones.obtenerProductoPorId(id);
		
		return producto;
	}
	
	public List<ProductoOtaku> mostrarProductos() { //Recoge todos los productos
		
		List<ProductoOtaku> productos = funciones.obtenerTodosLosProductos();
		
		return productos;
		
	}
	
	public List<ProductoOtaku> buscarPorNombre() { //ReCoge todos los productos cuyo nombre contenga una cadena de texto concreta
		
		System.out.println("Introduce el nombre buscado:");
		String nombre = obj.nextLine();
		System.out.println();
		
		String nombreBuscado = "%"+ nombre+ "%";
		
		List<ProductoOtaku> productos =funciones.buscarProductosPorNombre(nombreBuscado);
		
		return productos;
	}
	
    public List<ProductoOtaku> buscarPorCategoria() { //Recoge todos los productos de una categoria indicada
		
		System.out.println("Introduce la categoria buscada:");
		String categoria = obj.nextLine();
		System.out.println();
		
		List<ProductoOtaku> productos =funciones.buscarProductoPorCategoria(categoria);
		
		return productos;
	}
    
    public ProductoOtaku actualizar() { //Recoge los datos para actualizar un producto
    	
    	System.out.println("Introduce el ID del producto a actualizar:");
		int id = obj.nextInt();
		System.out.println();
		saltoDeLinea = obj.nextLine();
		
		System.out.println("Introduce el nuevo nombre del producto:");
		String nombre = obj.nextLine();
		System.out.println();
		saltoDeLinea = obj.nextLine();
		
		System.out.println("Introduce la nueva categoria del producto:");
		String categoria = obj.nextLine();
		System.out.println();
		
		System.out.println("Introduce el nuevo precio del producto:");
		double precio = obj.nextDouble();
		System.out.println();
		
		System.out.println("Introduce el nuevo stock del producto:");
		int stock = obj.nextInt();
		System.out.println();
		
		ProductoOtaku producto = new ProductoOtaku(id, nombre, categoria, precio, stock);
		return producto;
    	
    }
    
    public int eliminar() { //Recoge el id de un producto para eliminarlo
    	
    	System.out.println("Introduce el ID del producto a eliminar:");
		int id = obj.nextInt();
		System.out.println();
		
		return id;
    	
    }	
}

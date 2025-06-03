
import com.akihabara.market.view.*;

import java.util.InputMismatchException;

import com.akihabara.market.dao.*;
import com.akihabara.market.model.ProductoOtaku;

public class Main {

	public static void main(String[] args) {
		
		InterfazConsola interfaz = new InterfazConsola();
		ProductoDAO funciones = new ProductoDAO();
		
		try {
			
			do {
				
				int opcion = interfaz.menu();
					
				if (opcion == 1) {
					
					funciones.agregarProducto(interfaz.registrar());
					System.out.println();
						
				} else if (opcion == 2) {
						
					System.out.println(interfaz.buscarPorId());
					System.out.println();
						
				} else if (opcion == 3) {
					
					for (ProductoOtaku producto : interfaz.mostrarProductos()) {
						
						System.out.println(producto);
					}
					
					System.out.println();
						
				} else if (opcion == 4) {
						
					for (ProductoOtaku producto : interfaz.buscarPorNombre()) {
						
						System.out.println(producto);
					}
					
					System.out.println();
						
				} else if (opcion == 5) {
					
					for (ProductoOtaku producto : interfaz.buscarPorCategoria()) {
						
						System.out.println(producto);
					}
					
					System.out.println();
						
						
				} else if (opcion == 6) {
						
					funciones.actualizarProducto(interfaz.actualizar());
					System.out.println();
						
				} else if (opcion == 7) {
						
					funciones.eliminarProducto(interfaz.eliminar());
					System.out.println();
						
				} else if (opcion == 8) {
						
					System.out.println("Cerrando el programa");
					break;
						
				} else {
						
					System.out.println("Opción no válida");
					System.out.println();
				}
						
			} while(true);
			
		} catch (InputMismatchException e) {
			
			System.out.println("Tipo de dato erróneo");
		}
	}
}

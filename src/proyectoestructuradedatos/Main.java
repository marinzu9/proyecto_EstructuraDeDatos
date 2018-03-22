/*
 * Proyecto de estructura de datos, Universidad Fidélitas. 
 * Software de inventario para uso comercial.
 */

package proyectoestructuradedatos;

/**
 *
 * @author gabriel
 */
public class Main {

    public static void main(String[] args) {
        
        ListaProductos lista = new ListaProductos();
        lista.agregarProducto(new Producto("Gabriel",10,10,10,10));
        lista.mostrarProductos();
        lista.editarProducto(0);
        lista.editarProducto(10);
        lista.mostrarProductos();
    }
    
}

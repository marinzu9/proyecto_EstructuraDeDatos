/*
 * Proyecto de estructura de datos, Universidad Fidélitas. 
 * Software de inventario para uso comercial.
 */

package Main;

//importar los productos
import Productos.*;

/**
 *
 * @author gabriel
 */
public class Main {

    public static void main(String[] args) {
        
        // lista para pruebas
        ListaProductos lista = new ListaProductos();
        lista.agregarProducto(new Producto("1",10,10,10,10));//
        lista.agregarProducto(new Producto("2",11,10,10,10));//
        lista.agregarProducto(new Producto("3",1,10,10,10));//
        lista.agregarProducto(new Producto("4",2,10,10,10));//
        lista.agregarProducto(new Producto("5",12,10,10,10));//
        lista.agregarProducto(new Producto("6",16,10,10,10));//
        lista.agregarProducto(new Producto("7",19,10,10,10));//
        
    }
    
}

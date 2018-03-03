package proyectoestructuradedatos;

/**
 * Clase lista que mantendra todas las operaciones
 * a realizar con los productos
 * @author gabriel
 */
public class ListaProductos {
    private Nodo inicio;
    private Nodo ultimo;
    
    public boolean listaVacia(){
        return inicio == null;
    }
    
    public void agregarProducto(Producto producto){
        // revisar si la lista esta vacia
        if(listaVacia()){
            inicio = new Nodo(producto);
            ultimo = inicio;
        }
        // revisar si el codigo del nuevo producto es menor al codigo que esta en inicio
        else if(producto.getCodigo()<inicio.getDato().getCodigo()){
            Nodo aux = new Nodo(producto);
            aux.setSiguiente(inicio);
            inicio = aux;
        }
        // revisar si es mayor al codigo del ultimo producto
        else if(producto.getCodigo()>ultimo.getDato().getCodigo()){
            ultimo.setSiguiente(new Nodo(producto));
            ultimo = ultimo.getSiguiente();
        }
        // si no, el producto va en el medio, buscar en el medio de cuales. 
        else{
            Nodo aux = inicio.getSiguiente();
            Nodo temp = new Nodo(producto);
            while(aux.getSiguiente().getDato().getCodigo()<temp.getDato().getCodigo()){
                aux = aux.getSiguiente();
            }
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
        ultimo.setSiguiente(inicio);
    }
    
    
}

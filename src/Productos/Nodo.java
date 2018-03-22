package Productos;

/**
 * La aplicacion no contara con acceso a BD
 * por lo cual se estara usando una lista circular para guardar los elementos
 * @author gabriel
 */
public class Nodo {
    private Producto dato; // crea un nuevo producto con todos sus atributos 
    private Nodo siguiente; // puntero hacia el siguiente nodo

    public Nodo(Producto dato){
        this.dato = dato;
    }
    
    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}

package proyectoestructuradedatos;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Clase lista simple circular que mantendra todas las operaciones
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
    
    public void mostrarProductos(){
        if(!listaVacia()){
            Nodo aux = inicio;
            String s = "Datos en lista: \n";
            s+="Nombre del producto: "+aux.getDato().getNombre()+
                    "\nCantidad en bodega: "+aux.getDato().getCantidadEnBodega()+"\nCodigo: "+aux.getDato().getCodigo()+
                    "\nPrecio de compra: "+aux.getDato().getPrecioCompra()+"\nPrecio de venta: "+aux.getDato().getPrecioVenta()
                    +"\n==========================\n";
            aux = aux.getSiguiente();
            while(aux!=inicio){
                s+="Nombre del producto: "+aux.getDato().getNombre()+
                    "\nCantidad en bodega: "+aux.getDato().getCantidadEnBodega()+"\nCodigo: "+aux.getDato().getCodigo()+
                    "\nPrecio de compra: "+aux.getDato().getPrecioCompra()+"\nPrecio de venta: "+aux.getDato().getPrecioVenta()
                    +"\n==========================\n";
                aux = aux.getSiguiente();
            }
            System.out.println(s);
        }
    }
    
    public void editarProducto(int codigo){
        if(!listaVacia()){
            Nodo aux = existe(codigo);
            if(aux!=null){
                int opc = 0;
                String s ="******** EDITAR ********\n1. Codigo\n2. Nombre del producto\n3. Precio de compra\n4. Precio de venta\n"
                        + "5. Cantidad en bodega\n6. No editar.\n\nIngrese su opcion: ";
                    opc = Integer.parseInt(JOptionPane.showInputDialog(null,s));
                switch(opc){
                    case 1:
                        JOptionPane.showMessageDialog(null, "El codigo no se puede editar. Por favor borre el producto "
                            + "e ingreselo de nuevo.");
                        break;
                    case 2:
                        String nuevoNombre = JOptionPane.showInputDialog(null,"Digite el nuevo nombre: ");
                        JOptionPane.showMessageDialog(null, "Cambiando nombre de "+aux.getDato().getNombre()+
                            " a "+nuevoNombre+".");
                        aux.getDato().setNombre(nuevoNombre);
                        break;
                    case 3:
                        int nuevoPrecioCompra = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el nuevo precio de compra: "));
                        JOptionPane.showMessageDialog(null, "Cambiando precio de compra de "+aux.getDato().getPrecioCompra()+
                            " a "+nuevoPrecioCompra+".");
                        aux.getDato().setPrecioCompra(nuevoPrecioCompra);
                        break;
                    case 4:
                        int nuevoPrecioVenta = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el nuevo precio de venta: "));
                        JOptionPane.showMessageDialog(null, "Cambiando precio de venta de "+aux.getDato().getPrecioVenta()+
                            " a "+nuevoPrecioVenta+".");
                        aux.getDato().setPrecioVenta(nuevoPrecioVenta);
                        break;
                    case 5:
                        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite nueva cantidad: "));
                        JOptionPane.showMessageDialog(null, "Cambiando cantidad de "+aux.getDato().getCantidadEnBodega()+
                            " a "+nuevaCantidad+".");
                        aux.getDato().setCantidadEnBodega(nuevaCantidad);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "No se edito ningun detalle.");
                        break;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Codigo no existe.");
        }
    }
    
    public Nodo existe(int codigo){
        Nodo existe = null;
        if(!listaVacia()){
            Nodo aux = inicio;
            Nodo aux2 = ultimo;
            // es el primer nodo?
            if(aux.getDato().getCodigo() == codigo){
                existe = aux;
            }
            // es el ultimo?
            else if(aux2.getDato().getCodigo()==codigo){
                existe = aux2;
            }
            // esta en el medio?
            else{
                aux = aux.getSiguiente();
                while(aux!=ultimo){
                    if(aux.getDato().getCodigo() == codigo){
                        existe = aux;
                        break;
                    }
                    else{
                        aux = aux.getSiguiente();
                    }
                }
            }
            return existe;
        }
        else{
            System.out.println("Lista vacia. ");
            return existe;
        }
    }
    
    
}

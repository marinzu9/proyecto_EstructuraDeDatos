package Productos;

import javax.swing.JOptionPane;
/**
 * Clase lista simple circular que mantendra todas las operaciones
 * a realizar con los productos. CRUD. 
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
            JOptionPane.showMessageDialog(null, s);
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay productos en lista.");
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
    
    public void eliminarProducto(int codigo){
        if(!listaVacia()){
            Nodo aux = existe(codigo);
            if(aux!=null){
                // revisar si es el ultimo dato en la lista
                if(ultimo == inicio){
                    aux.setDato(null);
                    inicio = null;
                    ultimo = null;
                    JOptionPane.showMessageDialog(null, "Ultimo dato en lista eliminado");
                }
                // si no, proceder normal
                else{
                    // es el primer dato en lista?
                    if(aux==inicio){
                        inicio = aux.getSiguiente(); // pasar el inicio al siguiente (existe me devuelve el nodo con el puntero)
                        ultimo.setSiguiente(inicio); // actualizar el ultimo porque el primero acaba de cambiar
                        JOptionPane.showMessageDialog(null, aux.getDato().getNombre()+" eliminado.");
                        aux.setDato(null); // pongo ese dato en null
                    }
                    // es el ultimo en la lista?
                    else if(aux == ultimo){
                        Nodo temp = inicio;
                        // obtener al que esta antes del ultimo ya que este sera el nuevo ultimo
                        while(temp.getSiguiente()!=ultimo){
                            temp = temp.getSiguiente();
                        }
                        ultimo = temp; // temp tiene el nodo que estaba antes del ultimo, actualizo
                        ultimo.setSiguiente(inicio); // le actualizo el puntero
                        JOptionPane.showMessageDialog(null, aux.getDato().getNombre()+" eliminado.");
                        aux.setDato(null); // pongo ese dato en null
                    }
                    // esta en el medio
                    else{
                        Nodo temp = inicio;
                        // obtener al que esta antes del que queremos eliminar
                        while(temp.getSiguiente()!=aux){
                            temp = temp.getSiguiente();
                        }
                        temp.setSiguiente(aux.getSiguiente()); // le pongo al que esta antes del que vamos a eliminar el puntero hacia el
                        //siguiente del que estamos eliminando
                        JOptionPane.showMessageDialog(null, aux.getDato().getNombre()+" eliminado.");
                        aux.setDato(null); // pongo ese dato en null
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Codigo no pertenece a ningun producto. ");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Lista vacia");
        }
    }
    
    public void buscar(int codigo){
        if(!listaVacia()){
            Nodo existe = existe(codigo);
            if(existe!=null){
                JOptionPane.showMessageDialog(null, "\n====================\nDatos del producto:\n"
                        + "Codigo: "+existe.getDato().getCodigo()+"\nNombre: "+existe.getDato().getNombre()+
                        "\nPrecio de compra: "+existe.getDato().getPrecioCompra()+"\nPrecio de venta: "+existe.getDato().getPrecioVenta()
                +"\nCantidad en bodega: "+existe.getDato().getCantidadEnBodega()+"\n====================\n");
            }
            else{
                JOptionPane.showMessageDialog(null,"Codigo no pertenece a ningun producto. ");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Lista vacia");
        }
    }
    
    //Facturacion Temporal
    
     public void mostrarBodega(){
        if(!listaVacia()){
            Nodo aux = inicio;
            String s = "Productos en Bodega: \n";
            s+="\nNombre del producto: "+aux.getDato().getNombre()+"\nCantidad en Stock: "
                    +aux.getDato().getCantidadEnBodega()+
                    "\n==========================\n";
            aux = aux.getSiguiente();
            while(aux!=inicio){
                 s+="\nNombre del producto: "+aux.getDato().getNombre()+
                         "\nCantidad en Stock: "+aux.getDato().getCantidadEnBodega()+
                         "\n==========================\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, s);
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay productos en lista.");
        }
    }
     
     
     public void mostrarProductosBajos(){
           if(!listaVacia()){
            Nodo aux = inicio;
            String s = "Productos bajos en stock: \n";
            if(aux.getDato().getCantidadEnBodega()<=5){
                  s+="\nNombre del producto: "+aux.getDato().getNombre()+"\nCantidad en Stock: "
                    +aux.getDato().getCantidadEnBodega()+
                    "\n==========================\n";
            } 
              aux = aux.getSiguiente();
            while(aux!=inicio){
                  if(aux.getDato().getCantidadEnBodega()<=5){
                  s+="\nNombre del producto: "+aux.getDato().getNombre()+"\nCantidad en Stock: "
                    +aux.getDato().getCantidadEnBodega()+
                    "\n==========================\n";
            }
              aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, s);
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay productos en lista.");
        }
     }
     
     
     public void facturaCliente(){
         
     }
     
     
    
    
}

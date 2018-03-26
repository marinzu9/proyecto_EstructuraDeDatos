package Ventas;

import javax.swing.JOptionPane;

public class Pila {

   private Dato inicio;
    private int tam;

    public Pila() {
        inicio = null; 
        tam = 0;
    }

    public boolean esVacia() {
        return inicio == null;

    }

    public void agregar(int dato, String info, String nombre, int codigo, int cantidadEnBodega, int precioCompra, int precioVenta) {
        Dato nuevo = new Dato(); 
       nuevo.setDato(dato);
       nuevo.setCantidadEnBodega(cantidadEnBodega);
       nuevo.setCodigo(codigo);
       nuevo.setInfo(info);
       nuevo.setNombre(nombre);
       nuevo.setPrecioCompra(precioCompra);
       nuevo.setPrecioVenta(precioVenta);
       

        if (esVacia()) {
            inicio = nuevo;

        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        tam++;
    }
public void mostrarPila(){
    
}
    public void extraer() {
        if (!esVacia()) {

            inicio = inicio.getSiguiente();
            tam--;
        }

    }
    public boolean buscar(int busca){
        Dato aux = inicio;
        boolean existe = false;
        
        while(existe != true && aux != null){
            
            if (busca == aux.getValor()) {
                existe = true;
                JOptionPane.showMessageDialog(null,"Lo encontré");
            }
            else{
              
                aux = aux.getSiguiente();
            }
        }
        
        return existe;
    }
    
    public void editar(int codigo){
        if (buscar(codigo)) {
            Dato aux = inicio; 
	      while(aux != null){
                if(aux.getCodigo()==codigo){
		   	int nuevoCodigo=Integer.parseInt(	
			JOptionPane.showInputDialog(null,"Digite el nuevo codigo:"));
                        int precioCompra=Integer.parseInt(	
			JOptionPane.showInputDialog(null,"Digite el nuevo precio de compra:"));
                         int precioVenta=Integer.parseInt(	
			JOptionPane.showInputDialog(null,"Digite el nuevo precio de veta:"));
                        int cantidadEnBodega =Integer.parseInt(	
			JOptionPane.showInputDialog(null,"Digite la cantidad en bodega:"));
                        String info
                        
                   aux.setDato(nuevoCodigo);
                }
                aux=aux.getSiguiente();
            }
        }
    }



    public void EliminarTodo() {
        inicio = null;
        tam = 0;
    }

    public void listar() {
        String s = " ";
        Dato aux = inicio;

        while (aux != null) {
            s = s + "\n" + aux.getNombre();
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "La pila contiene: \n" + s);
    }




}

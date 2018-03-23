/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import javax.swing.JOptionPane;

/**
 *
 * @author Alonso
 */
public class Factura {
    ListaProductos l=new ListaProductos();
    private Nodo inicio;
    private Nodo ultimo;
    
    
     public void mostrarBodega(){
        if(!l.listaVacia()){
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
           if(!l.listaVacia()){
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
}

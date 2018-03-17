/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructuradedatos;

/**
 *
 * @author Alonso
 */
public class Dato {
    private String valor;
    private Dato siguiente;

    public Dato() {
        valor="";
        siguiente=null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Dato getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Dato siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}

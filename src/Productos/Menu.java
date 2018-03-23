/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

/**
 *
 * @author Alonso
 */
public class Menu {
    public void menu(){
        int opc=0; int id=0; String nombre="";
        ListaProductos l=new ListaProductos();
        while(opc!=19){
            opc=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("MENU\n"
                    + "1.Agregar Producto\n"
                    + "2.Mostrar Producto\n"
                    + "3.Editar Producto\n"
                    + "4.Eliminar Producto\n"
                    + "5.Salir\n"));
            switch(opc){
                case 1:
                   nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.agregarProducto(new Producto(nombre, id));
                    break;
                case 2:
                    l.mostrarProductos();
                    break;
                case 3:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.editarProducto(id);
                    break;
                case 4:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.eliminarProducto(id);
                    break;
            
                case 15:
                    System.exit(0);
                    break;
            }
        }
    }
}

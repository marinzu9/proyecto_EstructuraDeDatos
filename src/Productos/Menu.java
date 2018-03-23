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
        int opc=0; int id=0, cantBodega=0, precioCompra=0, precioVenta=0; String nombre="";
        ListaProductos l=new ListaProductos(); Factura f=new Factura();
        while(opc!=7){
            opc=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("MENU\n"
                    + "1.Agregar Producto\n"
                    + "2.Mostrar Producto\n"
                    + "3.Editar Producto\n"
                    + "4.Eliminar Producto\n"
                    + "5.Mostrar Productos en Bodega\n"
                    + "6.Mostrar Productos Bajos en Stock\n"
                    + "7.Salir\n"));
            switch(opc){
                case 1:
                   nombre=javax.swing.JOptionPane.showInputDialog("Nombre Producto");
                    id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Codigo Producto"));
                    cantBodega=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Cantidad en Bodega"));
                    precioCompra=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Precio de Compra"));
                    precioVenta=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Precio de Venta"));
                    
                    l.agregarProducto(new Producto(nombre, id, cantBodega, precioCompra, precioVenta));
                    break;
                case 2:
                    l.mostrarProductos();
                    break;
                case 3:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Codigo de producto"));
                    l.editarProducto(id);
                    break;
                case 4:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Codigo de producto"));
                    l.eliminarProducto(id);
                    break;
                case 5:
                    l.mostrarBodega();
                    break;
                case 6:
                    l.mostrarProductosBajos();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}

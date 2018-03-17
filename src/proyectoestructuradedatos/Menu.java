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
public class Menu {
    public void menu(){
        int opc=0; int id=0; String nombre="";
        ListaProductos l=new ListaProductos();
        while(opc!=19){
            opc=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("MENU\n"
                    + "1.Insertar en Pila\n"
                    + "2.Mostrar Pila\n"
                    + "3.Llenar Cola\n"
                    + "4.Mostrar Cola\n"
                    + "5.Llenar Lista Simple\n"
                    + "6.Mostrar Lista SImple\n"
                    + "7.Llenar Lista Circular\n"
                    + "8.Mpstrar Lista Circular\n"
                    + "9.Llenar Lista Doble\n"
                    + "10.Mostrar Lista Doble\n"
                    + "11.Existe Lista Simple\n"
                    + "12.Modifica Lista Simple\n"
                    + "13.Elimina Lista SImple\n"
                    + "14.Extrae Lista Simple\n"
                    + "15.Existe Circilar\n"
                    + "16.Modifica Circilar\n"
                    + "17.Elimina Circilar\n"
                    + "18.Extrae Circilar\n"
                    + "19.Salir\n"));
            switch(opc){
                case 1:
                   nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.metePila(nombre);
                    break;
                case 2:
                    l.mPila();
                    break;
                case 3:
                    nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.meteColas(new NodoC(nombre));
                    break;
                case 4:
                    l.mColas();
                    break;
                case 5:
                      id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                      nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.meteSimple(new Producto(nombre, id));
                    break;
                case 6:
                    l.mSimple();
                    break;
                case 7:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                      nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.meteCircular(new Producto(nombre, id));
                    break;
                case 8:
                    l.mostrarLista();
                    break;
                case 9:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                      nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.meteDoble(new Producto(nombre, id));
                    break;
                case 10:
                    l.mDoble();
                    break;
                case 11:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    System.out.println(l.existeSimple(id));
                    break;
                case 12:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                       nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.modificaSimple(new Producto(nombre, id));
                    break;
                case 13:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.eliminaSimple(id);
                    break;
                case 14:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.extraeSimple(id);
                    break;
                case 15:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    System.out.println(l.existeCircular(id));
                    break;
                case 16:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                        nombre=javax.swing.JOptionPane.showInputDialog("Nombre");
                    l.modificaCircular(new Producto(nombre, id));
                    break;
                case 17:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.eliminaCircular(id);
                    break;
                case 18:
                     id=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID"));
                    l.extraeCircular(id);
                    break;
                case 19:
                    System.exit(0);
                    break;
            }
        }
    }
}

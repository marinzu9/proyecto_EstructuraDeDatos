
package Ventas;

import javax.swing.JOptionPane;


public class Rutinas {
    public void menu() { 
        Pila pila = new Pila();
        int opc = 0, dato = 0;
        while (opc != 6) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "<<-- Ejemplo de Pila -->>\n\n"
                    + "\nMenú Principal\n"
                    + "\n1.Agregar dato\n"
                    + "\n2.Editar dato\n"
                    + "\n3.Eliminar dato\n"
                    + "\n4.Eliminar toda la pila\n"
                    + "\n5.Mostrar pila\n"
                    + "\n6.Salir del sistema\n"
                    + "\nDigite su opción:\n"));
            switch (opc) {
                case 1: {
                    dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un número"));
//                    pila.agregar(dato);
                    break;
                }
                case 2: {
                    int buscado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor buscado:"));
//                    pila.buscar(buscado);
//                    pila.editar(dato);
                    break;
                }
                case 3: {
                    pila.extraer();
                    break;
                }
                case 4: {
                    pila.EliminarTodo();
                    break;
                }
                case 5: {
                    pila.listar();
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }
            }
        }
    }
    
}

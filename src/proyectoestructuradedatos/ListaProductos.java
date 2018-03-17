package proyectoestructuradedatos;

import javax.swing.JOptionPane;

/**
 * Clase que mantendra todas las operaciones
 * a realizar con los productos.
 * @author gabriel y Alonso
 */
public class ListaProductos {
    
    //Lista
    private Nodo inicio;
    private Nodo ultimo;
    //Cola
    private NodoC frente;
    private NodoC ultimoC;
    //Pila
    private int tam;
    private Dato inicioP;
    
    
    //Lista Circular
    
     public void meteCircular(Producto p){
      if(inicio==null){
         inicio=new Nodo(p); 
         ultimo=inicio;
         ultimo.setSiguiente(inicio); 
      }else if(p.getCodigo()<inicio.getDato().getCodigo()){
         Nodo aux=new Nodo(p);
         aux.setSiguiente(inicio);
         inicio=aux;
         ultimo.setSiguiente(inicio);   
      }else if(ultimo.getDato().getCodigo()<=p.getCodigo()){
         Nodo aux=new Nodo(p); 
         ultimo.setSiguiente(aux);
         ultimo=ultimo.getSiguiente();
         ultimo.setSiguiente(inicio);
      }else{
         Nodo aux=inicio; 
         while(aux.getSiguiente().getDato().getCodigo()<p.getCodigo()){ 
            aux=aux.getSiguiente();     
         }
         Nodo temp=new Nodo(p); 
         temp.setSiguiente(aux.getSiguiente());
         aux.setSiguiente(temp); 
                                
      }
      ultimo.setSiguiente(inicio);
   }
   public void mostrarLista(){
      Nodo aux=inicio;
      String s="";
      if(aux!=null){
         s=s+aux.getDato().getCodigo()+" "+aux.getDato().getNombre()+"--";
         aux=aux.getSiguiente();
         while(aux!=inicio){//En vista de que es una lista circular, se debe detener cuando
           s=s+aux.getDato().getCodigo()+" "+aux.getDato().getNombre()+"--";    //aux regrese a inicio 
           aux=aux.getSiguiente();
         }  
      }else{
            s=s+"Lista vacía";      
           }
      JOptionPane.showMessageDialog(null,"La lista contiene:\n"+s);
      }
   
   
   
   public boolean existeCircular(int id){
       boolean esta=false;
      
       if(inicio!=null){
           if(id>= inicio.getDato().getCodigo() && id<= ultimo.getDato().getCodigo()){
                Nodo aux=inicio;
                while(aux!=ultimo &&aux.getDato().getCodigo()< id){
                    aux=aux.getSiguiente();
                }
                     esta=(aux.getDato().getCodigo()==id);
           }
      
       }
       return esta;
   }
   
    public void modificaCircular(Producto p) {
        if (inicio != null) {
            if (p.getCodigo() >= inicio.getDato().getCodigo() && p.getCodigo() <= ultimo.getDato().getCodigo()) {
                Nodo aux = inicio;
                while (aux != ultimo && aux.getDato().getCodigo() < p.getCodigo()) {
                    aux = aux.getSiguiente();
                }
                if (aux.getDato().getCodigo() == p.getCodigo()) {
                    aux.getDato().setNombre(p.getNombre());
                }

            }
        }
    }
   
   public void eliminaCircular (int id){
       if(inicio!=null){
           if(inicio.getDato().getCodigo()<=id && id <= ultimo.getDato().getCodigo()){
               if(inicio.getDato().getCodigo()==id){
                    inicio=inicio.getSiguiente();
                    ultimo.setSiguiente(inicio);
               }
               else{
               Nodo aux=inicio;
               while(aux.getSiguiente()!=inicio && aux.getSiguiente().getDato().getCodigo()< id){
                   aux=aux.getSiguiente();
               }
               
               if(aux.getSiguiente().getDato().getCodigo()==id){
                   if(aux.getSiguiente()==ultimo){
                       ultimo=aux;
                   }
                   aux.setSiguiente(aux.getSiguiente().getSiguiente());
               }
           } 
           }
       }
   }
   
    public Producto extraeCircular(int id) {
        Producto p = null;
        if (inicio != null) {
            if (inicio.getDato().getCodigo() <= id && id <= ultimo.getDato().getCodigo()) {
                if (inicio.getDato().getCodigo() == id) {
                    p = inicio.getDato();
                    inicio = inicio.getSiguiente();
                    ultimo.setSiguiente(inicio);
                } else {
                    Nodo aux = inicio;
                    while (aux.getSiguiente() != inicio && aux.getSiguiente().getDato().getCodigo()< id) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente().getDato().getCodigo()== id) {
                        p = aux.getSiguiente().getDato();
                        if (aux.getSiguiente() == ultimo) {
                            ultimo = aux;
                        }
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    }
                }
            }
        }
        return p;
    }
    
    
     //Pila
    
    public void metePila(String valor){
        Dato nuevo=new Dato();
        nuevo.setValor(valor);
        if(inicioP==null){
            inicioP=nuevo;
        } else{
            nuevo.setSiguiente(inicioP);
            inicioP=nuevo;
        }
        tam++;
    }
    
    public void mPila(){
        String s="";
        Dato aux=inicioP;
        while(aux!=null){
            s+=aux.getValor()+"\n";
            aux=aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "Contiene\n"+s);
    }
    
    //Cola
    
    public void meteColas(NodoC d){
        if(frente==null){
            frente=d;
            ultimoC=d;
        }else{
            ultimoC.setAtras(d);
            ultimoC=d;
        }
    }
    
    public void mColas(){
         String s="";
        NodoC aux=frente;
        while(aux!=null){
            s+=aux.getDato()+"--";
            aux=aux.getAtras();
        }
        JOptionPane.showMessageDialog(null, "Contiene\n"+s);
    }
    
    
    //Lista SImple
    
    public void meteSimple(Producto p){
        if(inicio==null){
            inicio=new Nodo(p);           
        } else if(inicio.getDato().getCodigo()>p.getCodigo()){
            Nodo aux=new Nodo(p);
            aux.setSiguiente(inicio);
            inicio=aux;
        } else if(inicio.getSiguiente()==null){
            inicio.setSiguiente(new Nodo(p));
        } else{
            Nodo aux=inicio;
            while(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCodigo()<p.getCodigo()){
                aux=aux.getSiguiente();
            }
            Nodo temp=new Nodo(p);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
    }
    
    
    public void mSimple(){
          String s="";
        Nodo aux=inicio;
        while(aux!=null){
            s+=aux.getDato().getCodigo()+"  "+aux.getDato().getNombre()+"--";
            aux=aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "Contiene\n"+s);
    }
    
    public boolean existeSimple(int id){
        boolean esta=false;
          if(inicio!=null){
              Nodo aux=inicio;
              while(aux!=null && aux.getDato().getCodigo()<id){
                  aux=aux.getSiguiente();
              }
              esta=(aux!=null && aux.getDato().getCodigo()==id);
          }
          return esta;
    }
    
    public void modificaSimple(Producto p){
        if(inicio!=null){
            Nodo aux=inicio;
            while(aux!=null && aux.getDato().getCodigo()<p.getCodigo()){
                  aux=aux.getSiguiente();
              }
            if(aux!=null && aux.getDato().getCodigo()==p.getCodigo()){
                aux.getDato().setNombre(p.getNombre());
            }
        }
    }
    
    public void eliminaSimple(int id){
        if(inicio!=null){
          if(inicio.getDato().getCodigo()==id){
             inicio=inicio.getSiguiente();
          } else{
              Nodo aux=inicio;
               while(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCodigo()<id){
                   aux=aux.getSiguiente();
               }
               if(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCodigo()==id){
                   aux.setSiguiente(aux.getSiguiente().getSiguiente());
               }
          }
           
        }
    }
    
      public Producto extraeSimple(int id){
          Producto p=null;
        if(inicio!=null){
          if(inicio.getDato().getCodigo()==id){
             inicio=inicio.getSiguiente();
          } else{
              Nodo aux=inicio;
               while(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCodigo()<id){
                   aux=aux.getSiguiente();
               }
               if(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCodigo()==id){
                   p=aux.getSiguiente().getDato();
                   aux.setSiguiente(aux.getSiguiente().getSiguiente());
               }
          }
           
        }
        return p;
    }
    
       //Lista Doble 
    
    public void meteDoble(Producto p){
          if(inicio==null){
            inicio=new Nodo(p); 
            ultimo=inicio;
            ultimo.setSiguiente(inicio);
            inicio.setAnterior(ultimo);
        } else if(inicio.getDato().getCodigo()>p.getCodigo()){
            Nodo aux=new Nodo(p);
            aux.setSiguiente(inicio);
            inicio=aux;
            ultimo.setSiguiente(inicio);
            inicio.setAnterior(ultimo);
        } else if(ultimo.getDato().getCodigo()<=p.getCodigo()){
            Nodo aux=new Nodo(p);
            ultimo.setSiguiente(aux);
            ultimo=aux;
            ultimo.setSiguiente(inicio);
            inicio.setAnterior(ultimo);
        } else{
            Nodo aux=inicio;
            while(aux.getSiguiente().getDato().getCodigo()<p.getCodigo()){
                aux=aux.getSiguiente();
            }
            Nodo temp=new Nodo(p);
            temp.setSiguiente(aux.getSiguiente());
            temp.setAnterior(aux);
            aux.setSiguiente(temp);
        }
    }
    
    public void mDoble() {
        String s = "";
        Nodo aux = inicio;
        if (aux != null) {
            s += aux.getDato().getCodigo() + "  " + aux.getDato().getNombre()+"--";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s += aux.getDato().getCodigo() + "  " + aux.getDato().getNombre()+"--";
                aux = aux.getSiguiente();
            }
        } else {
            s += "Lista Vacia";
        }
        JOptionPane.showMessageDialog(null, "Contiene\n" + s);
    }
    
    
  
    
    
}

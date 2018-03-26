package Ventas;

public class Dato {

    private int dato;
    private String info;
    private String nombre; // mantener el nombre del producto
    private int codigo, cantidadEnBodega, precioCompra, precioVenta;
    private Dato siguiente;

    public void Dato() {
        this.dato = 0;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadEnBodega() {
        return cantidadEnBodega;
    }

    public void setCantidadEnBodega(int cantidadEnBodega) {
        this.cantidadEnBodega = cantidadEnBodega;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Dato getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Dato siguiente) {
        this.siguiente = siguiente;
    }

}

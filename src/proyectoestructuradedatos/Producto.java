package proyectoestructuradedatos;

/**
 * Clase producto que contendra todo lo relevate a
 * los productos del cliente
 * @author gabriel
 */
public final class Producto {
    private String nombre; // mantener el nombre del producto
    private int codigo, cantidadEnBodega, precioCompra, precioVenta; // mantener codigos, cantidad en bodega y precios
    
    public Producto(String nombre, int codigo, int cantidadEnBodega, int precioCompra, int precioVenta){
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadEnBodega = cantidadEnBodega;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }
    
    // constructor para crear objetos sin parametros
    public Producto (){}
    
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
    
}

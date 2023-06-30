package Pojo;

public class Carrito {
    private String nombreProducto;
    private String marca;
    private String cantidad;
    private String descripcion;
    private String precio;
    private String departamento;

    public Carrito(String nombreProducto, String marca, String cantidad, String descripcion, String precio, String departamento) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.departamento = departamento;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return  " Nombre: " + nombreProducto +
                " Precio: " + precio;
    }
}

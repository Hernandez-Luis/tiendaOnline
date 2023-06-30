package Pojo;

public class Pedido {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String edad;
    private String direccion;
    private String telefono;
    private String ine;
    private String numTarjeta;
    private String fechaCaducidad;
    private String ccv;

    public Pedido(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String direccion, String telefono, String ine, String numTarjeta, String fechaCaducidad, String ccv) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
        this.numTarjeta = numTarjeta;
        this.fechaCaducidad = fechaCaducidad;
        this.ccv = ccv;
    }

    @Override
    public String toString() {
        return  "  Nombre='" + nombre +
                "  ApellidoPaterno='" + apellidoPaterno +
                "  ApellidoMaterno='" + apellidoMaterno +
                "  Direccion='" + direccion +
                "  Telefono='" + telefono;
    }
}

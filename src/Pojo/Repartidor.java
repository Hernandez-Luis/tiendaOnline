package Pojo;

public class Repartidor {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String edad;
    private String direccion;
    private String telefono;
    private String ine;
    private String numEmpleado;
    private String nombreCargo;
    private String descanso;

    public Repartidor(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String direccion, String telefono, String ine, String numEmpleado, String nombreCargo, String descanso) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
        this.numEmpleado = numEmpleado;
        this.nombreCargo = nombreCargo;
        this.descanso = descanso;
    }
}

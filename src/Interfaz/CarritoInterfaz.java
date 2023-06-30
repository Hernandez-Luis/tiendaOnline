package Interfaz;

import Pojo.Carrito;
import Pojo.Pedido;
import Pojo.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarritoInterfaz extends JFrame {
    private JPanel panelContainer,panelBotones,panelListas,panelDatos,panel1,panel2,panel3,panel4;
    private JButton eliminar,regresar,pagar,actualizar;
    private JLabel precio,titulo,vacio1,vacio2,vacio3,vacio4,nombre,apellidoPaterno,apellidoMaterno,edad,direccion,telefono,ine,numeroTarjeta,fechaCaducidad,ccv;
    private JTextField nombreEntrada, apellidPEntrada,apellidoMEntrada,edadEntrada,direccionEntrada,telefonoEntrada,ineEntrada,numeroTarjetaEntrada,fechaCaducidadEntrada,ccvEntrada;
    private JList<Carrito> carritoL;
    private DefaultListModel<Carrito> elemento1;
    public static ArrayList<Pedido> listaPedido = new ArrayList<>();
    public ArrayList<Carrito> listaCarrito = Inicio.getElementCarrito();

    EventClick eventClick = new EventClick();
    public CarritoInterfaz(){
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
        configLista();
        total();
    }

    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(500, 500);
    }

    private void initControl(){

        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelListas = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();


        nombre = new JLabel("Nombre ");
        apellidoPaterno = new JLabel("Apellido paterno ");
        apellidoMaterno = new JLabel("Apellido Materno ");
        edad = new JLabel("Edad ");
        direccion = new JLabel(" Direccion");
        telefono = new JLabel(" Telefono");
        ine = new JLabel(" INE");
        titulo = new JLabel("Datos del usuario");
        numeroTarjeta = new JLabel("Numero de tarjeta");
        fechaCaducidad = new JLabel("Fecha de caducidad ");
        ccv = new JLabel("CCV");

        nombreEntrada = new JTextField();
        apellidPEntrada = new JTextField();
        apellidoMEntrada = new JTextField();
        edadEntrada = new JTextField();
        direccionEntrada = new JTextField();
        telefonoEntrada = new JTextField();
        ineEntrada = new JTextField();
        numeroTarjetaEntrada = new JTextField();
        fechaCaducidadEntrada = new JTextField();
        ccvEntrada = new JTextField();

        eliminar = new JButton();
        regresar = new JButton();
        pagar = new JButton();
        actualizar = new JButton();
        carritoL = new JList<>();

        vacio1 = new JLabel(" ");
        vacio2 = new JLabel(" ");
        vacio3 = new JLabel(" ");
        vacio4 = new JLabel(" ");
        precio = new JLabel();
    }

    private void setControl(){
        eliminar.setText("Eliminar");
        regresar.setText("Regresar");
        pagar.setText("Pagar");
        actualizar.setText("Actualizar");

    }

    private void configPanel(){
        panelListas.setLayout(new GridLayout(1,1));
        panelListas.setPreferredSize(new Dimension(150,200));
        panelListas.add(carritoL);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(regresar);
        panelBotones.add(eliminar);
        pagar.addActionListener(eventClick);
        panelBotones.add(pagar);
        panelBotones.add(actualizar);

        panel1.setLayout(new GridLayout(5,1));
        panel1.add(nombre);
        panel1.add(apellidoPaterno);
        panel1.add(apellidoMaterno);
        panel1.add(edad);
        panel1.add(numeroTarjeta);


        panel2.setLayout(new GridLayout(5,1));
        panel2.add(nombreEntrada);
        panel2.add(apellidPEntrada);
        panel2.add(apellidoMEntrada);
        panel2.add(edadEntrada);
        panel2.add(numeroTarjetaEntrada);


        panel3.setLayout(new GridLayout(5,1));
        panel3.add(direccion);
        panel3.add(telefono);
        panel3.add(ine);
        panel3.add(ccv);
        panel3.add(fechaCaducidad);


        panel4.setLayout(new GridLayout(5,1));
        panel4.add(direccionEntrada);
        panel4.add(telefonoEntrada);
        panel4.add(ineEntrada);
        panel4.add(ccvEntrada);
        panel4.add(fechaCaducidadEntrada);

        panelDatos.setLayout(new GridLayout(1,4));
        panelDatos.add(panel1);
        panelDatos.add(panel2);
        panelDatos.add(panel3);
        panelDatos.add(panel4);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelListas);
        panelContainer.add(vacio1);
        panelContainer.add(precio);
        panelContainer.add(vacio3);
        panelContainer.add(panelBotones);
        panelContainer.add(titulo);
        panelContainer.add(vacio4);
        panelContainer.add(panelDatos);

        add(panelContainer);
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombree = nombreEntrada.getText();
            String apelliP = apellidPEntrada.getText();
            String apellidoM = apellidoMEntrada.getText();
            int nedad   = -1;
            String edadd = edadEntrada.getText();
            while(nedad==-1){
                try{
                    nedad = Integer.parseInt(edadd);
                    if (nedad<=0){
                        edadd = JOptionPane.showInputDialog(null,"Ingresa una edad numerica");
                        nedad=-1;
                    }
                } catch (NumberFormatException a){
                    edadd = JOptionPane.showInputDialog(null,"Ingresa una edad numerica");
                }
            }
            String direccion  = direccionEntrada.getText();
            int ntelefono = -1;
            String telefono = telefonoEntrada.getText();
            while(ntelefono==-1){
                try{
                    ntelefono = Integer.parseInt(telefono);
                    if (ntelefono<=0){
                        telefono = JOptionPane.showInputDialog(null,"Ingresa un telefono numerica");
                        ntelefono=-1;
                    }
                } catch (NumberFormatException a){
                    telefono = JOptionPane.showInputDialog(null,"Ingresa un telefono numerica");
                }
            }
            String ine = ineEntrada.getText();
            int nTar = -1;
            String numTarj = numeroTarjetaEntrada.getText();
            while(nTar==-1){
                try{
                    nTar = Integer.parseInt(numTarj);
                    if (nTar<=0){
                        numTarj = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                        nTar=-1;
                    }
                } catch (NumberFormatException a){
                    numTarj = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                }
            }
            String fecha = fechaCaducidadEntrada.getText();
            int ncv = -1;
            String ccv = ccvEntrada.getText();
            while(ncv==-1){
                try{
                    ncv = Integer.parseInt(ccv);
                    if (ncv<=0){
                        ccv = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                        ncv=-1;
                    }
                } catch (NumberFormatException a){
                    ccv = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                }
            }

            listaPedido.add(new Pedido(nombree,apelliP,apellidoM,edadd,direccion,telefono,ine,numTarj,fecha,ccv));

            nombreEntrada.setText(" ");
            apellidPEntrada.setText(" ");
            apellidoMEntrada.setText(" ");
            edadEntrada.setText(" ");
            direccionEntrada.setText(" ");
            telefonoEntrada.setText(" ");
            ineEntrada.setText(" ");
            numeroTarjetaEntrada.setText(" ");
            fechaCaducidadEntrada.setText(" ");
            ccvEntrada.setText(" ");

        }
    }
    public static ArrayList<Pedido> getElementPedido(){
        return listaPedido;
    }

    private void total(){
        if(listaCarrito.isEmpty()){
            precio.setText("$0");
            return;
        }
        int suma = 0;
        for (Carrito carrito : listaCarrito){
            int cant = Integer.parseInt(carrito.getCantidad());
            double precio = Double.parseDouble(carrito.getPrecio());
            double total = cant * precio;
            suma += total;
        }
        precio.setText("$" + suma);
}

    private void acciones(){
        regresar.addActionListener(e -> {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        });

        actualizar.addActionListener(e -> {
            new CarritoInterfaz();
            this.setVisible(false);
        });

        pagar.addActionListener(e -> {
            eliminarTodo();
        });

        eliminar.addActionListener(e -> {
            eliminar();
        });
    }

    private void eliminar(){
        int indice = carritoL.getSelectedIndex();

        String nombre = listaCarrito.get(indice).getNombreProducto();
        String marca = listaCarrito.get(indice).getMarca();
        String cantidad = listaCarrito.get(indice).getCantidad();
        String descripcion = listaCarrito.get(indice).getDescripcion();
        String precio = listaCarrito.get(indice).getPrecio();
        String departamento = listaCarrito.get(indice).getDepartamento();

        switch (departamento) {
            case "Abarrotes" -> {
                int tam = RegistrarProducto.listaAbarrote.size();
                RegistrarProducto.listaAbarrote.add(tam, new Productos(nombre, marca, cantidad, descripcion, precio, departamento));
            }
            case "Lacteos" -> {
                int tam = RegistrarProducto.listaLacteo.size();
                RegistrarProducto.listaLacteo.add(tam, new Productos(nombre, marca, cantidad, descripcion, precio, departamento));
            }
            case "Articulos de limpieza" -> {
                int tam = RegistrarProducto.listaArticulos.size();
                RegistrarProducto.listaArticulos.add(tam, new Productos(nombre, marca, cantidad, descripcion, precio, departamento));
            }
            case "Embutidos" -> {
                int tam = RegistrarProducto.listaEmbutidos.size();
                RegistrarProducto.listaEmbutidos.add(tam, new Productos(nombre, marca, cantidad, descripcion, precio, departamento));
            }
            case "Linea blanca" -> {
                int tam = RegistrarProducto.listaBlanca.size();
                RegistrarProducto.listaBlanca.add(tam, new Productos(nombre, marca, cantidad, descripcion, precio, departamento));
            }
        }

        if (indice>=0){
            int a = listaCarrito.indexOf(elemento1.get(indice));
            listaCarrito.remove(a);
        }
    }

    private void eliminarTodo(){
        listaCarrito.clear();
    }

    private void configLista() {
        elemento1 = new DefaultListModel<>();
        for (Carrito elemento : Inicio.getElementCarrito()) {
            elemento1.addElement(elemento);
        }
        carritoL.setModel(elemento1);
    }
}

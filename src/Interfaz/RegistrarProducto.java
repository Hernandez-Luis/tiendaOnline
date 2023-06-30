package Interfaz;

import Pojo.Productos;
import Titulos.Departamentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistrarProducto extends JFrame implements ItemListener {
    private JPanel panelContainer,panelDatos,panel1,panel2,panelBotones;
    private JButton regUsuario,regresar;
    private JLabel precio,vacio1,titulo,nombre,marca,cantidad,descripcion,departamento;
    private JTextField nombreEntrada,marcaEntrada,cantidadEntrada,descripcionEntrada,precioEntrada,departamentoEntrada;
    private JComboBox<String> opcionesDepartamento;
    public static ArrayList<Productos> listaAbarrote = new ArrayList<>();
    public static ArrayList<Productos> listaLacteo = new ArrayList<>();
    public static ArrayList<Productos> listaArticulos = new ArrayList<>();
    public static ArrayList<Productos> listaEmbutidos = new ArrayList<>();
    public static ArrayList<Productos> listaBlanca = new ArrayList<>();
    public static final String[] listaCarreras = Departamentos.nombres;
    EventClick eventClick = new EventClick();
    public RegistrarProducto(){
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
        llenarValoresOpciones();
    }

    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 250);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();

        vacio1 = new JLabel(" ");
        titulo = new JLabel();
        nombre = new JLabel();
        marca = new JLabel();
        cantidad = new JLabel();
        descripcion = new JLabel();
        precio = new JLabel();
        departamento = new JLabel();

        nombreEntrada = new JTextField();
        marcaEntrada = new JTextField();
        cantidadEntrada = new JTextField();
        descripcionEntrada = new JTextField();
        precioEntrada = new JTextField();
        departamentoEntrada = new JTextField();

        regUsuario = new JButton();
        regresar = new JButton();

        opcionesDepartamento = new JComboBox<>();
    }

    private void setControl(){
        regUsuario.setText("Registrar producto");
        regresar.setText("Regresar");
        titulo.setText("REGISTRAR PRODUCTO");

        nombre.setText("Nombre: ");
        marca.setText("Marca: ");
        cantidad.setText("Cantidad: ");
        descripcion.setText("Descripcion: ");
        precio.setText("Precio: ");
        departamento.setText("Departamento: ");
    }

    private void configPanel(){

        panel1.setLayout(new GridLayout(6,1));
        panel1.add(nombre);
        panel1.add(marca);
        panel1.add(cantidad);
        panel1.add(descripcion);
        panel1.add(precio);
        panel1.add(departamento);

        panel2.setLayout(new GridLayout(6,1));
        panel2.add(nombreEntrada);
        panel2.add(marcaEntrada);
        panel2.add(cantidadEntrada);
        panel2.add(descripcionEntrada);
        panel2.add(precioEntrada);
        panel2.add(opcionesDepartamento);

        panelDatos.setLayout(new GridLayout(1,3));
        panelDatos.add(panel1);
        panelDatos.add(vacio1);
        panelDatos.add(panel2);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(regUsuario);
        regUsuario.addActionListener(eventClick);
        panelBotones.add(regresar);


        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(titulo);
        panelContainer.add(panelDatos);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    private void acciones(){
        regresar.addActionListener(e -> {
            Administrador administrador = new Administrador();
            administrador.setVisible(true);
            this.setVisible(false);
        });

        opcionesDepartamento.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == opcionesDepartamento){
            String item = (String) opcionesDepartamento.getSelectedItem();
            departamentoEntrada.setText(item);
        }
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombree = nombreEntrada.getText();
            String  marcaa = marcaEntrada.getText();
            int ncant =-1;
            String cant = cantidadEntrada.getText();
            while(ncant==-1){
                try{
                    ncant = Integer.parseInt(cant);
                    if (ncant<=0){
                        cant = JOptionPane.showInputDialog(null,"Ingresa una cantidad numerica");
                        ncant=-1;
                    }
                } catch (NumberFormatException a){
                    cant = JOptionPane.showInputDialog(null,"Ingresa una cantidad numerica");
                }
            }
            String desc = descripcionEntrada.getText();
            int nprec = -1;
            String prec = precioEntrada.getText();
            while(nprec==-1){
                try{
                    nprec = Integer.parseInt(prec);
                    if (nprec<=0){
                        prec = JOptionPane.showInputDialog(null,"Ingresa una cantidad numerica");
                        nprec=-1;
                    }
                } catch (NumberFormatException a){
                    prec = JOptionPane.showInputDialog(null,"Ingresa un precio numerico");
                }
            }
            String departamentos = departamentoEntrada.getText();

            switch (departamentos) {
                case "Abarrotes" -> listaAbarrote.add(new Productos(nombree, marcaa, cant, desc, prec, departamentos));
                case "Lacteos" -> listaLacteo.add(new Productos(nombree, marcaa, cant, desc, prec, departamentos));
                case "Articulos de limpieza" -> listaArticulos.add(new Productos(nombree, marcaa, cant, desc, prec, departamentos));
                case "Embutidos" -> listaEmbutidos.add(new Productos(nombree, marcaa, cant, desc, prec, departamentos));
                case "Linea blanca" -> listaBlanca.add(new Productos(nombree, marcaa, cant, desc, prec, departamentos));
            }

            nombreEntrada.setText(" ");
            marcaEntrada.setText(" ");
            cantidadEntrada.setText("");
            descripcionEntrada.setText(" ");
            precioEntrada.setText("");
            departamentoEntrada.setText(" ");

        }
    }

    private void llenarValoresOpciones(){
        for (String s: listaCarreras) {
            opcionesDepartamento.addItem(s);
        }
    }

    public static ArrayList<Productos> getElementAbarrotes(){
        return listaAbarrote;
    }
    public static ArrayList<Productos> getElementLacteos(){
        return listaLacteo;
    }
    public static ArrayList<Productos> getElementArticulos(){
        return listaArticulos;
    }
    public static ArrayList<Productos> getElementEmbutidos(){
        return listaEmbutidos;
    }
    public static ArrayList<Productos> getElementBlancas(){
        return listaBlanca;
    }
}










package Interfaz;

import Imagen.MiImagen;
import Pojo.Carrito;
import Pojo.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Inicio extends JFrame{
    private JPanel panelContainer,panelBotones,panelListas,panelLista2,panelLista3,panelLista4,panelLista5,panelDatos,panel1,panel2,panel3,panel4;
    private JButton agregar,login,carrito,actualizar;
    private JLabel vacio1,vacio2,abarrotes,lacteos,articulos,embutidos,blanca,nombre,marca,cantidad,descripcion,precio,departamento;
    private JTextField nombreEntrada,marcaEntrada,cantidadEntrada,descripcionEntrada,precioEntrada,departamentoEntrada;
    private JList<Productos> abarrotesL,lacteosL,articulosL,embutidosL,blancaL;
    private DefaultListModel<Productos> elemento1,elemento2,elemento3,elemento4,elemento5;
    public static ArrayList<Carrito> listaCarrito = new ArrayList<>();
    public ArrayList<Productos> listaAbarrote = RegistrarProducto.getElementAbarrotes();
    public ArrayList<Productos> listaLacteos = RegistrarProducto.getElementLacteos();
    public ArrayList<Productos> listaArticulos = RegistrarProducto.getElementArticulos();
    public ArrayList<Productos> listaEmbutidos = RegistrarProducto.getElementEmbutidos();
    public ArrayList<Productos> listaBlanca = RegistrarProducto.getElementBlancas();
    EventClick eventClick = new EventClick();
    public Inicio(){
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
        configLista();
    }

    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 700);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelListas = new JPanel();
        panelLista2 = new JPanel();
        panelLista3 = new JPanel();
        panelLista4 = new JPanel();
        panelLista5 = new JPanel();
        panelDatos = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        agregar = new JButton();
        login = new JButton();
        carrito = new JButton();
        actualizar = new JButton();

        abarrotes = new JLabel();
        lacteos = new JLabel();
        articulos = new JLabel();
        embutidos = new JLabel();
        blanca = new JLabel();
        nombre = new JLabel();
        marca = new JLabel();
        cantidad = new JLabel();
        descripcion = new JLabel();
        precio = new JLabel();
        departamento = new JLabel();
        vacio1 = new JLabel(" ");
        vacio2 = new JLabel(" ");

        nombreEntrada = new JTextField();
        marcaEntrada = new JTextField();
        cantidadEntrada = new JTextField();
        descripcionEntrada = new JTextField();
        precioEntrada = new JTextField();
        departamentoEntrada = new JTextField();

        abarrotesL = new JList<>();
        lacteosL = new JList<>();
        articulosL = new JList<>();
        embutidosL = new JList<>();
        blancaL = new JList<>();

        elemento1 = new DefaultListModel<>();
        elemento2 = new DefaultListModel<>();
        elemento3 = new DefaultListModel<>();
        elemento4 = new DefaultListModel<>();
        elemento5 = new DefaultListModel<>();
    }

    private void setControl(){
        agregar.setText("Agregar");
        login.setText("Login");
        carrito.setText("Carrito");
        actualizar.setText("Actualizar");
        abarrotes.setText("ABARROTES");
        lacteos.setText("LACTEOS");
        articulos.setText("ARTICULOS");
        embutidos.setText("EMBUTIDOS");
        blanca.setText("LINEA BLANCA");
        nombre.setText("Nombre del producto:");
        marca.setText("Marca:");
        cantidad.setText("Cantidad:");
        descripcion.setText("Descripcion:");
        precio.setText("Precio");
        departamento.setText("Departamento");
    }

    private void configPanel(){

        panelListas.setLayout(new GridLayout(2,1));
        panelListas.setPreferredSize(new Dimension(100,90));
        panelListas.add(abarrotes);
        panelListas.add(abarrotesL);

        panelLista2.setLayout(new GridLayout(2,1));
        panelLista2.setPreferredSize(new Dimension(100,90));
        panelLista2.add(lacteos);
        panelLista2.add(lacteosL);

        panelLista3.setLayout(new GridLayout(2,1));
        panelLista3.setPreferredSize(new Dimension(100,90));
        panelLista3.add(articulos);
        panelLista3.add(articulosL);

        panelLista4.setLayout(new GridLayout(2,1));
        panelLista4.setPreferredSize(new Dimension(100,90));
        panelLista4.add(embutidos);
        panelLista4.add(embutidosL);

        panelLista5.setLayout(new GridLayout(2,1));
        panelLista5.setPreferredSize(new Dimension(100,90));
        panelLista5.add(blanca);
        panelLista5.add(blancaL);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(agregar);
        agregar.addActionListener(eventClick);
        panelBotones.add(login);
        panelBotones.add(carrito);
        panelBotones.add(actualizar);


        panel1.setLayout(new GridLayout(3,1));
        panel1.add(nombre);
        panel1.add(marca);
        panel1.add(cantidad);

        panel2.setLayout(new GridLayout(3,1));
        panel2.add(nombreEntrada);
        panel2.add(marcaEntrada);
        panel2.add(cantidadEntrada);

        panel3.setLayout(new GridLayout(3,1));
        panel3.add(descripcion);
        panel3.add(precio);
        panel3.add(departamento);

        panel4.setLayout(new GridLayout(3,1));
        panel4.add(descripcionEntrada);
        panel4.add(precioEntrada);
        panel4.add(departamentoEntrada);

        panelDatos.setLayout(new GridLayout(1,4));
        panelDatos.add(panel1);
        panelDatos.add(panel2);
        panelDatos.add(panel3);
        panelDatos.add(panel4);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelListas);
        panelContainer.add(panelLista2);
        panelContainer.add(panelLista3);
        panelContainer.add(panelLista4);
        panelContainer.add(panelLista5);
        panelContainer.add(vacio1);
        panelContainer.add(panelBotones);
        panelContainer.add(vacio2);
        panelContainer.add(panelDatos);

        add(panelContainer);
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!nombreEntrada.getText().isEmpty()){
                String nombree = nombreEntrada.getText();
                String marcaa = marcaEntrada.getText();
                String cant = cantidadEntrada.getText();
                String desc = descripcionEntrada.getText();
                String prec = precioEntrada.getText();
                String departamentos = departamentoEntrada.getText();

                listaCarrito.add(new Carrito(nombree, marcaa, cant, desc, prec, departamentos));

                nombreEntrada.setText(" ");
                marcaEntrada.setText(" ");
                cantidadEntrada.setText(" ");
                descripcionEntrada.setText(" ");
                precioEntrada.setText(" ");
                departamentoEntrada.setText(" ");
            }
        }
    }

    public static ArrayList<Carrito> getElementCarrito(){
        return listaCarrito;
    }

    private void acciones(){
        login.addActionListener(e -> {
            Login login1 = new Login();
            login1.setVisible(true);
            this.setVisible(false);
        });

        carrito.addActionListener(e -> {
            CarritoInterfaz carritoInterfaz = new CarritoInterfaz();
            carritoInterfaz.setVisible(true);
            this.setVisible(false);
        });

        agregar.addActionListener(e -> {
            eliminar();
        });

        actualizar.addActionListener(e -> {
            new Inicio();
            this.setVisible(false);
        });

        abarrotesL.addListSelectionListener(e -> {
            consulta();
        });

        lacteosL.addListSelectionListener(e -> {
            consulta();
        });

        articulosL.addListSelectionListener(e -> {
            consulta();
        });

        embutidosL.addListSelectionListener(e -> {
            consulta();
        });

        blancaL.addListSelectionListener(e -> {
            consulta();
        });
    }

    private void configLista(){
        elemento1 = new DefaultListModel<>();
        for (Productos elemento : RegistrarProducto.getElementAbarrotes()) {
            elemento1.addElement(elemento);
        }
        abarrotesL.setModel(elemento1);


        elemento2 = new DefaultListModel<>();
        for (Productos elemento : RegistrarProducto.getElementLacteos()) {
            elemento2.addElement(elemento);
        }
        lacteosL.setModel(elemento2);


        elemento3 = new DefaultListModel<>();
        for (Productos elemento : RegistrarProducto.getElementArticulos()) {
            elemento3.addElement(elemento);
        }
        articulosL.setModel(elemento3);


        elemento4 = new DefaultListModel<>();
        for (Productos elemento : RegistrarProducto.getElementEmbutidos()) {
            elemento4.addElement(elemento);
        }
        embutidosL.setModel(elemento4);


        elemento5 = new DefaultListModel<>();
        for (Productos elemento : RegistrarProducto.getElementBlancas()) {
            elemento5.addElement(elemento);
        }
        blancaL.setModel(elemento5);
    }

    private void eliminar(){
        int indice = abarrotesL.getSelectedIndex();
        int indice2 = lacteosL.getSelectedIndex();
        int indice3 = articulosL.getSelectedIndex();
        int indice4 = embutidosL.getSelectedIndex();
        int indice5 = blancaL.getSelectedIndex();

        if (indice>=0){
            int a = listaAbarrote.indexOf(elemento1.get(indice));
            listaAbarrote.remove(a);
        }

        if (indice2>=0){
            int b = listaLacteos.indexOf(elemento2.get(indice2));
            listaLacteos.remove(b);
        }

        if (indice3>=0){
            int c = listaArticulos.indexOf(elemento3.get(indice3));
            listaArticulos.remove(c);
        }

        if (indice4>=0){
            int d = listaEmbutidos.indexOf(elemento4.get(indice4));
            listaEmbutidos.remove(d);
        }

        if (indice5>=0){
            int e = listaBlanca.indexOf(elemento5.get(indice5));
            listaBlanca.remove(e);
        }
    }

    public void consulta(){
        int x =abarrotesL.getSelectedIndex();
        int y =lacteosL.getSelectedIndex();
        int z =articulosL.getSelectedIndex();
        int a =embutidosL.getSelectedIndex();
        int b =blancaL.getSelectedIndex();


        if (x>=0){
            nombreEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getNombreProducto());
            marcaEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getMarca());
            cantidadEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getCantidad());
            descripcionEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getDescripcion());
            precioEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getPrecio());
            departamentoEntrada.setText(RegistrarProducto.getElementAbarrotes().get(x).getDepartamento());
        }

        if (y>=0){
            nombreEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getNombreProducto());
            marcaEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getMarca());
            cantidadEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getCantidad());
            descripcionEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getDescripcion());
            precioEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getPrecio());
            departamentoEntrada.setText(RegistrarProducto.getElementLacteos().get(y).getDepartamento());
        }

        if (z>=0){
            nombreEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getNombreProducto());
            marcaEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getMarca());
            cantidadEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getCantidad());
            descripcionEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getDescripcion());
            precioEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getPrecio());
            departamentoEntrada.setText(RegistrarProducto.getElementArticulos().get(z).getDepartamento());
        }

        if (a>=0){
            nombreEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getNombreProducto());
            marcaEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getMarca());
            cantidadEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getCantidad());
            descripcionEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getDescripcion());
            precioEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getPrecio());
            departamentoEntrada.setText(RegistrarProducto.getElementEmbutidos().get(a).getDepartamento());
        }

        if (b>=0){
            nombreEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getNombreProducto());
            marcaEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getMarca());
            cantidadEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getCantidad());
            descripcionEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getDescripcion());
            precioEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getPrecio());
            departamentoEntrada.setText(RegistrarProducto.getElementBlancas().get(b).getDepartamento());
        }
    }
}

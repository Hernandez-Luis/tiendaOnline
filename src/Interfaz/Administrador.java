package Interfaz;

import Imagen.MiImagen;

import javax.swing.*;
import java.awt.*;

public class Administrador extends JFrame {
    private JPanel panelContainer,panelBotones,imagen;
    private JButton registrarAdministrador,registrarProducto,modificarProducto,regresar;
    private MiImagen miImagen;

    public Administrador(){
        MiImagen miImagen = new MiImagen();
        this.miImagen = miImagen;
        initFrame();
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
    }

    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miImagen, BorderLayout.CENTER);
        setSize(400,600);
        setVisible(true);

    }

    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 550);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        imagen = new JPanel();

        registrarAdministrador = new JButton();
        registrarProducto = new JButton();
        modificarProducto = new JButton();
        regresar = new JButton();
    }

    private void setControl(){
        registrarAdministrador.setText("Registrar administrador");
        registrarProducto.setText("Registrar Producto");
        modificarProducto.setText("Modificar Producto");
        regresar.setText("Regresar");
    }

    private void configPanel(){
        panelBotones.setLayout(new GridLayout(4,1));
        panelBotones.setPreferredSize(new Dimension(100, 100));
        panelBotones.add(registrarAdministrador);
        panelBotones.add(registrarProducto);
        panelBotones.add(modificarProducto);
        panelBotones.add(regresar);

        imagen.setLayout(new GridLayout(1,1));
        imagen.setPreferredSize(new Dimension(250,250));
        imagen.add(miImagen);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        //panelContainer.setPreferredSize(new Dimension(150,450));
        panelContainer.add(imagen);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    private void acciones(){
        registrarAdministrador.addActionListener(e -> {
            RegistrarRepartidor registrarRepartidor = new RegistrarRepartidor();
            registrarRepartidor.setVisible(true);
            this.setVisible(false);
        });

        registrarProducto.addActionListener(e -> {
            RegistrarProducto registrarProducto1 = new RegistrarProducto();
            registrarProducto1.setVisible(true);
            this.setVisible(false);
        });

        modificarProducto.addActionListener(e -> {
            ModificarProducto modificarProducto1 = new ModificarProducto();
            modificarProducto1.setVisible(true);
            this.setVisible(false);
        });

        regresar.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });

    }
}

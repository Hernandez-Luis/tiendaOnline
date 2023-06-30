package Interfaz;

import Imagen.MiImagen;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel panelContainer,panelBotones,imagen;
    private JButton admin,repartidor,regresar;
    private MiImagen miImagen;


    public Login(){
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
        setSize(400, 500);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        imagen = new JPanel();

        admin = new JButton();
        repartidor = new JButton();
        regresar = new JButton();
    }

    private void setControl(){
        admin.setText("Administrador");
        repartidor.setText("Repartidor");
        regresar.setText("Regresar");
    }

    private void configPanel(){
        panelBotones.setLayout(new GridLayout(3,1));
        panelBotones.setPreferredSize(new Dimension(100, 100));
        panelBotones.add(admin);
        panelBotones.add(repartidor);
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
        admin.addActionListener(e -> {
            ValidarAdmin validarAdmin = new ValidarAdmin();
            validarAdmin.setVisible(true);
            this.setVisible(false);
        });

        repartidor.addActionListener(e -> {
            ValidRepartidor validRepartidor = new ValidRepartidor();
            validRepartidor.setVisible(true);
            this.setVisible(false);
        });

        regresar.addActionListener(e -> {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        });

    }
}

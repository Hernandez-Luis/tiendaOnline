package Interfaz;

import Imagen.MiImagen;

import javax.swing.*;
import java.awt.*;

public class RepartidorInterfaz extends JFrame {
    private JPanel panelContainer,panelBotones;
    private JButton registrar,entregas,regresar;

    public RepartidorInterfaz() {
        configFrame();
        initControl();
        setControl();
        configPanel();
        acciones();
    }

    private void configFrame(){
        setTitle("Inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(300, 150);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();

        registrar = new JButton();
        entregas = new JButton();
        regresar = new JButton();
    }

    private void setControl(){
        entregas.setText("Entregas");
        regresar.setText("Regresar");
        registrar.setText("Registrar repartidor");
    }

    private void configPanel(){
        panelBotones.setLayout(new GridLayout(3,1));
        panelBotones.add(registrar);
        panelBotones.add(entregas);
        panelBotones.add(regresar);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    private void acciones(){
        entregas.addActionListener(e -> {
            Entregas entregas1 = new Entregas();
            entregas1.setVisible(true);
            this.setVisible(false);
        });

        registrar.addActionListener(e -> {
            RegistrarRepartidor registrarRepartidor = new RegistrarRepartidor();
            registrarRepartidor.setVisible(true);
            this.setVisible(false);
        });

        regresar.addActionListener(e -> {
           Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });
    }
}

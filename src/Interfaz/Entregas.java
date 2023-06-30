package Interfaz;

import Pojo.Pedido;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Entregas extends JFrame {
    private JPanel panelContainer,panelBotones,panelListas,panelDatos;
    private JButton entregado,regresar,actualizar;
    private JLabel vacio1,vacio4;
    private JList<Pedido> pedidoL;
    private DefaultListModel<Pedido> elemento1;
    public ArrayList<Pedido> listaPedido = CarritoInterfaz.getElementPedido();

    public Entregas(){
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
        setSize(800, 350);
    }

    private void initControl(){
        panelContainer = new JPanel();
        panelBotones = new JPanel();
        panelListas = new JPanel();
        panelDatos = new JPanel();


        entregado = new JButton();
        regresar = new JButton();
        actualizar = new JButton();
        pedidoL = new JList<>();

        vacio1 = new JLabel(" ");
        vacio4 = new JLabel(" ");
    }

    private void setControl(){
        entregado.setText("Entregado");
        regresar.setText("Regresar");
        actualizar.setText("Actualizar");

    }

    private void configPanel(){
        panelListas.setLayout(new GridLayout(1,1));
        panelListas.setPreferredSize(new Dimension(750,250));
        panelListas.add(pedidoL);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(regresar);
        panelBotones.add(entregado);
        panelBotones.add(actualizar);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelListas);
        panelContainer.add(vacio1);
        panelContainer.add(panelBotones);
        panelContainer.add(vacio4);
        panelContainer.add(panelDatos);

        add(panelContainer);
    }

    private void acciones(){
        regresar.addActionListener(e -> {
            RepartidorInterfaz repartidorInterfaz = new RepartidorInterfaz();
            repartidorInterfaz.setVisible(true);
            this.setVisible(false);
        });

        actualizar.addActionListener(e -> {
            new Entregas();
            this.setVisible(false);
        });

        entregado.addActionListener(e -> {
            eliminar();
        });
    }

    private void eliminar(){
        int indice = pedidoL.getSelectedIndex();

        if (indice>=0){
            int a = listaPedido.indexOf(elemento1.get(indice));
            listaPedido.remove(a);
        }
    }

    private void configLista() {
        elemento1 = new DefaultListModel<>();
        for (Pedido elemento : CarritoInterfaz.getElementPedido()) {
            elemento1.addElement(elemento);
        }
        pedidoL.setModel(elemento1);
    }
}

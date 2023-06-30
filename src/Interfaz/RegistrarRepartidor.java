package Interfaz;

import Pojo.Carrito;
import Pojo.Pedido;
import Pojo.Repartidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarRepartidor extends JFrame {
    private JPanel panelContainer,panelBotones,panelListas,panelDatos,panel1,panel2,panel3,panel4;
    private JButton guardar,regresar;
    private JLabel titulo,vacio1,vacio2,vacio3,vacio4,nombre,apellidoPaterno,apellidoMaterno,edad,direccion,telefono,ine,numeroEmpleado,nombreCargo,diaDescanso;
    private JTextField nombreEntrada, apellidPEntrada,apellidoMEntrada,edadEntrada,direccionEntrada,telefonoEntrada,ineEntrada,numeroEmpleadoEntrada,nombreCargoEntrada,diaDescansoEntrada;
    public static ArrayList<Repartidor> listaRepartidores = new ArrayList<>();
    EventClick eventClick = new EventClick();
    public RegistrarRepartidor(){
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
        setSize(700, 300);
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
        titulo = new JLabel("REGISTRO");
        numeroEmpleado = new JLabel("Numero de empleado");
        nombreCargo = new JLabel("Nombre del cargo que ocupa");
        diaDescanso = new JLabel("Dia de descanso");

        nombreEntrada = new JTextField();
        apellidPEntrada = new JTextField();
        apellidoMEntrada = new JTextField();
        edadEntrada = new JTextField();
        direccionEntrada = new JTextField();
        telefonoEntrada = new JTextField();
        ineEntrada = new JTextField();
        numeroEmpleadoEntrada = new JTextField();
        nombreCargoEntrada = new JTextField();
        diaDescansoEntrada = new JTextField();

        guardar = new JButton();
        regresar = new JButton();

        vacio1 = new JLabel(" ");
        vacio2 = new JLabel(" ");
        vacio3 = new JLabel(" ");
        vacio4 = new JLabel(" ");
    }

    private void setControl(){
        guardar.setText("Guardar");
        regresar.setText("Regresar");

    }

    private void configPanel(){
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(regresar);
        guardar.addActionListener(eventClick);
        panelBotones.add(guardar);

        panel1.setLayout(new GridLayout(5,1));
        panel1.add(nombre);
        panel1.add(apellidoPaterno);
        panel1.add(apellidoMaterno);
        panel1.add(edad);
        panel1.add(numeroEmpleado);


        panel2.setLayout(new GridLayout(5,1));
        panel2.add(nombreEntrada);
        panel2.add(apellidPEntrada);
        panel2.add(apellidoMEntrada);
        panel2.add(edadEntrada);
        panel2.add(numeroEmpleadoEntrada);


        panel3.setLayout(new GridLayout(5,1));
        panel3.add(direccion);
        panel3.add(telefono);
        panel3.add(ine);
        panel3.add(diaDescanso);
        panel3.add(nombreCargo);


        panel4.setLayout(new GridLayout(5,1));
        panel4.add(direccionEntrada);
        panel4.add(telefonoEntrada);
        panel4.add(ineEntrada);
        panel4.add(diaDescansoEntrada);
        panel4.add(nombreCargoEntrada);

        panelDatos.setLayout(new GridLayout(1,4));
        panelDatos.add(panel1);
        panelDatos.add(panel2);
        panelDatos.add(panel3);
        panelDatos.add(panel4);

        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(titulo);
        panelContainer.add(vacio1);
        panelContainer.add(panelDatos);
        panelContainer.add(vacio4);
        panelContainer.add(panelBotones);

        add(panelContainer);
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombree = nombreEntrada.getText();
            String apelliP = apellidPEntrada.getText();
            String apellidoM = apellidoMEntrada.getText();
            int nedad = -1;
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
            int nnumEmpl = -1;
            String numEmpl = numeroEmpleadoEntrada.getText();
            while(nnumEmpl==-1){
                try{
                    nnumEmpl = Integer.parseInt(numEmpl);
                    if (nnumEmpl<=0){
                        numEmpl = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                        nnumEmpl=-1;
                    }
                } catch (NumberFormatException a){
                    numEmpl = JOptionPane.showInputDialog(null,"Ingresa un numero de empleado valido");
                }
            }
            String cargo = nombreCargoEntrada.getText();
            String descanso = diaDescansoEntrada.getText();

            listaRepartidores.add(new Repartidor(nombree,apelliP,apellidoM,edadd,direccion,telefono,ine,numEmpl,cargo,descanso));

            nombreEntrada.setText(" ");
            apellidPEntrada.setText(" ");
            apellidoMEntrada.setText(" ");
            edadEntrada.setText(" ");
            direccionEntrada.setText(" ");
            telefonoEntrada.setText(" ");
            ineEntrada.setText(" ");
            numeroEmpleadoEntrada.setText(" ");
            nombreCargoEntrada.setText(" ");
            diaDescansoEntrada.setText(" ");

        }
    }


    private void acciones(){
        regresar.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });
    }
}

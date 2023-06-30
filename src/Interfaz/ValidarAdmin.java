package Interfaz;

import javax.swing.*;
import java.awt.*;

public class ValidarAdmin extends JFrame {
    private JPanel panelContenedor, panelLogin;
    private JButton btnRegresar, btnAceptar;
    private JLabel usuario,contrasena;
    private JTextField usuarioEntrada;
    private JPasswordField contrasenaEntrada;
    public  ValidarAdmin(){
        initComponents();
        initFrame();
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnRegresar = new JButton("Regresar");
        btnAceptar = new JButton("Aceptar");
        panelLogin = new JPanel();

        usuario = new JLabel("Usuario: ");
        contrasena = new JLabel("Contrasena: ");
        usuarioEntrada = new JTextField();
        contrasenaEntrada = new JPasswordField();
    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(2,1));
        panelContenedor.setPreferredSize(new Dimension(300,300));

        panelLogin.setLayout(new GridLayout(4,2));
        panelLogin.add(usuario);
        panelLogin.add(usuarioEntrada);
        panelLogin.add(contrasena);
        panelLogin.add(contrasenaEntrada);

        panelLogin.add(new JLabel());
        panelLogin.add(new JLabel());

        panelLogin.add(btnRegresar);
        panelLogin.add(btnAceptar);

        panelContenedor.add(panelLogin);
    }
    private void addActionListeners(){
        btnRegresar.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });

        btnAceptar.addActionListener(e -> {
            validar();
        });
    }
    public void validar(){
        String contrasena = "admin";
        String usuario = "admin";

        String Cingresada = contrasenaEntrada.getText();
        String Uingresado = usuarioEntrada.getText();

        if(Uingresado.equals(usuario) && Cingresada.equals(contrasena)){
            this.setVisible(false);
            Administrador administrador = new Administrador();
            administrador.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Usuario o Contraseña incorrectos");
        }
    }
}

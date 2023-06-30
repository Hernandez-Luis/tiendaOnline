package Imagen;

import java.awt.*;

public class MiImagen extends Canvas {
    @Override
    public void paint(Graphics g) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\Wicho\\Documents\\Paradigmas de programacion\\Tareaa\\perfil.png");
        g.drawImage(image,100,100,this);
    }
}

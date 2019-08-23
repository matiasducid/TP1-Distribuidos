package punto3b;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;


public class Ventana{
	public Ventana() {
		JFrame f = new JFrame("Titulo de ventana");
		f.setSize(600, 600);
		
		Container cp = f.getContentPane();
		cp.setLayout(null);
		cp.add(new Texto("Host",10,10,100));
		cp.add(new Texto("Port",130,10,100));
		cp.add(new Boton("Conectar",240,10,120));

		cp.add(new Boton("Abrir",10,100,80));
		cp.add(new Boton("Leer",100,100,80));
		cp.add(new Boton("Escribir",190,100,120));
		cp.add(new Boton("Cerrar",320,100,100));
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
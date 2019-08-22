package punto3b;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;


public class Ventana{
	public Ventana() {
		JFrame f = new JFrame("Titulo de ventana");
		f.setSize(600, 600);
		
		Container cp = f.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new Boton("Abrir"));
		cp.add(new Boton("Leer"));
		cp.add(new Boton("Escribir"));
		cp.add(new Boton("Cerrar"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
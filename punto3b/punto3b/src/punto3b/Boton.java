package punto3b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Boton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public Boton(String nombre_boton) {
		super(nombre_boton);
		this.addActionListener(this); /* Significa que esta clase maneja ella misma los eventos de click */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Abrir") {
			byte[] arreglo_temporal = null;
			System.out.println("Abrir button pressed");

			OpenArgument open = new OpenArgument("777", "/home/anele/Escritorio/vacio.txt");
			SocketClient s = new SocketClient("localhost", 7896);
			OpenRespuesta resp = (OpenRespuesta)s.run(open);
			
			
		
			
			System.out.println("TERMINE DE PROCESAR TODO");
		}
		if (e.getActionCommand() == "Leer") {
			System.out.println("Ler button pressed");
		}
	}	
}

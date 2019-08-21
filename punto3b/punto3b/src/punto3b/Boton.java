package punto3b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			System.out.println("Abrir button pressed");
		}
		if (e.getActionCommand() == "Leer") {
			System.out.println("Ler button pressed");
		}
		System.out.println("nada");
	}	
}
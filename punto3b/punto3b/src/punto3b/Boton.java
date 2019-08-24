package punto3b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Boton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public Boton(String nombre_boton) {
		super(nombre_boton);
		this.addActionListener(this); /* Significa que esta clase maneja ella misma los eventos de click */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OTRO") {
			Cliente c = new Cliente();
			c.hacer();
		}
	}	
}












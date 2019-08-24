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
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Boton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public Boton(String nombre_boton,int x,int y, int width) {
		super(nombre_boton);
		this.addActionListener(this); /* Significa que esta clase maneja ella misma los eventos de click */
		this.setBounds(new Rectangle(x,y,width,20));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aux="";   
		String texto="";
	
		if (e.getActionCommand() == "Conectar") {
			System.out.println("Boton conectar apretado.");
			
			Component[] componentes = getComponentes(e);//Funcion definida abajo.
			
			//Texto hostText = (Texto) componentes[0];//Casteo el primer elemento para tener su texto (el host).
			//Texto portText = (Texto)componentes[1];//Casteo el segundo elemento para obtener su texto (el port).
			//System.out.println("Host al que se desea conectar: " + hostText.getText());
			//System.out.println("Port al que se desea conectar: " + portText.getText());
			
			//QUIZAS ESTA PARTE HABRIA QUE MANEJARLA CON UNA EXCEPCION O ALGUNA VALIDACION POR SI NO SE PUEDE CONECTAR.
			//SocketClient s = new SocketClient(hostText.getText(),Integer.parseInt(portText.getText()));
			
			
		}
		if (e.getActionCommand() == "Abrir") {
			
			boolean cosa = true;
			int fd;
			
			System.out.println("HOLA CAPO2");
			ClienteStub stub = new ClienteStub();
			fd = stub.Abrir("/home/anele/Escritorio/cosa.py");
			
			while(cosa) {
				ReadRespuesta resp = stub.leer(50, fd);
				System.out.println(resp.getBuffer());
				cosa = resp.hayMasDatos;
			}
			System.out.println("TERMINEEE");
		}
		

		
		
		
		
		if (e.getActionCommand() == "Leer") {
			System.out.println("Leer button pressed");			
	//		String[] argumentosCliente = {"localhost", "mensaje del leer"};
	//		SocketClient.main(argumentosCliente);
			
			//aca tiene que tener el filepath y los permisos 
			//llamar al stub el cliente a la funcion abrir
		}
	
		System.out.println("nada desde boton.");
	}
	
	private Component[] getComponentes(ActionEvent e) { //Funcion que obtiene la lista de componentes del jpanel.
		Component component = (Component) e.getSource();
		JFrame frame = (JFrame) SwingUtilities.getRoot(component);//Obtengo el jframe.
		Component[] componentes = frame.getContentPane().getComponents();//Obtengo todos los componentes colocados en el contentpane del jframe.
		return componentes;
	}
}












package punto3b;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileDescriptor;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Cliente  implements ActionListener{
	
	public static void main(String[] args) {
//		Ventana v = new Ventana();
	}
	public static void realizarLectura(String host,int port) {
		System.out.println("realizar lectura llamado");
	}
	
	public Cliente() {
		Ventana v = new Ventana(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String host,fileLocal,fileServer;
		int port;

		Component[] componentes = getComponentes(e); //Obtengo los componentes del JFrame e inicializo objetos de los que quiero.
		Texto hostTextBox = (Texto)componentes[0];
		Texto portTextBox = (Texto)componentes[1];
		Texto fileLocalTextBox = (Texto)componentes[2];
		Texto fileServerTextBox = (Texto)componentes[3];
		JTextArea textAreaBox = (JTextArea)componentes[4];
		host = hostTextBox.getText();
		port = Integer.parseInt(portTextBox.getText());
		fileLocal = fileLocalTextBox.getText();
		fileServer = fileServerTextBox.getText();
		
		if (e.getActionCommand() == "Leer") {
					
			boolean cosa = true;
			int fd;
			

			ClienteStub stub = new ClienteStub();
			fd = stub.abrir(fileServer,host, port);
			System.out.println("entro a leer");
			while(cosa) {
				ReadRespuesta resp = stub.leer(50, fd, host, port);
				System.out.println(resp.getBuffer());
				textAreaBox.append(resp.getBuffer());
				cosa = resp.hayMasDatos;
			}
			stub.cerrar(fd, host, port);

		}
		// /home/anele/Escritorio/vacio.txt
		
		if (e.getActionCommand() == "Escribir") {
			boolean cosa = true;
			int fd;
			
			ClienteStub stub = new ClienteStub();
			fd = stub.abrir("/home/anele/Escritorio/vacio.txt",host, port);
			String cadena = "HOLA MUNDO CAPO ANELE";
			int flag = stub.escribir(cadena.getBytes(), fd, host, port);
			stub.cerrar(fd, host, port);
		}
		
		
	}
	private Component[] getComponentes(ActionEvent e) { //Funcion que obtiene la lista de componentes del jpanel.
		Component component = (Component) e.getSource();
		JFrame frame = (JFrame) SwingUtilities.getRoot(component);//Obtengo el jframe.
		Component[] componentes = frame.getContentPane().getComponents();//Obtengo todos los componentes colocados en el contentpane del jframe.
		return componentes;
	}
}

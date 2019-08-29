package punto3b;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
			
			textAreaBox.setText("");
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

		
		if (e.getActionCommand() == "Escribir") {
			
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(new File(fileLocal));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			StringBuffer buf = new StringBuffer("");
			int fd;
			int i;
			int maxCaracteres = 200;
			
			ClienteStub stub = new ClienteStub();
			fd = stub.abrir(fileServer,host, port);
			
			System.out.println("PUNTERO:"+fd);
			try {
				
				while (true) {
					i = fis.read();
					if (i == -1) {
						break;
					}
					buf.append((char)i);
					if (buf.length() == maxCaracteres) {
						System.out.println(buf);
						stub.escribir(new String(buf).getBytes(), fd, host, port);
						buf.delete(0, buf.length());
					}
				}
				stub.cerrar(fd, host, port);
				
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
	}
	private Component[] getComponentes(ActionEvent e) { //Funcion que obtiene la lista de componentes del jpanel.
		Component component = (Component) e.getSource();
		JFrame frame = (JFrame) SwingUtilities.getRoot(component);//Obtengo el jframe.
		Component[] componentes = frame.getContentPane().getComponents();//Obtengo todos los componentes colocados en el contentpane del jframe.
		return componentes;
	}
}
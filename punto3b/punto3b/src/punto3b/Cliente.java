package punto3b;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileDescriptor;

import javax.swing.JFrame;
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
		String host;
		int port;

		if (e.getActionCommand() == "Leer") {
			System.out.println("Leer button pressed");			
	//		String[] argumentosCliente = {"localhost", "mensaje del leer"};
	//		SocketClient.main(argumentosCliente);
			Component[] componentes = getComponentes(e);
			Texto hostTextBox = (Texto)componentes[0];
			Texto portTextBox = (Texto)componentes[1];
			host = hostTextBox.getText();
			port = Integer.parseInt(portTextBox.getText());
			//[TODO] llamar a la funcion del cliente que haga la logica necesaria llamando al stub para leer.
			
		}
		if (e.getActionCommand() == "Escribir") {
			System.out.println("Escribir boton presseed");
			
		}
	
		System.out.println("nada desde el manejador de eventos en el cliente.");
	}
	private Component[] getComponentes(ActionEvent e) { //Funcion que obtiene la lista de componentes del jpanel.
		Component component = (Component) e.getSource();
		JFrame frame = (JFrame) SwingUtilities.getRoot(component);//Obtengo el jframe.
		Component[] componentes = frame.getContentPane().getComponents();//Obtengo todos los componentes colocados en el contentpane del jframe.
		return componentes;
	}
}

package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorStub {
	
	private Respuesta respuesta = null;
	private Servidor server = new Servidor();
	private ManejadorArchivos manejador = new ManejadorArchivos();
	
	public void run() {
		try {
      		ServerSocket escuchandoSocket = new ServerSocket(7896);
      		while (true) {
    		    Socket socketCliente = escuchandoSocket.accept();
    			ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());
    	        ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
    			Argument request = (Argument)in.readObject();
    			Conexion hilo = new Conexion(socketCliente,in,out,server,request,manejador);
    			hilo.start();
      	   	}
		}
     	catch(Exception e) {
      		e.printStackTrace();
     	}
	}
	
	public static void main() {
//		try {
//			int puertoServicio = 7896;
//			ServerSocket escuchandoSocket = new ServerSocket(puertoServicio);
//			while (true) {
//				/* Espera conexion de un cliente */
//				Socket socketCliente = escuchandoSocket.accept();
//				/* Crea un thread para el servicio al cliente */
//				//Conexion c = new Conexion(socketCliente);
//				}
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
		}

// Getters & Setters
	public ManejadorArchivos getManejador() {
		return manejador;
	}

	public void setManejador(ManejadorArchivos manejador) {
		this.manejador = manejador;
	}
		
	
}

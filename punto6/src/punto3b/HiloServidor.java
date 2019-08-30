package punto3b;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor implements Runnable{
	
	private Socket socketCliente;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Argument request;
	private Servidor server;
	private ManejadorArchivos manejador;
	private Respuesta respuesta = null;
	
	
public HiloServidor(Socket unSocketCliente, ServidorStub serverStub) {
	try {
		/* Ya hay una conexion con un cliente, streams de I/O */
		this.socketCliente = unSocketCliente;
		ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
		this.entrada = in;
		this.salida = out;
		Argument request = (Argument)in.readObject();
		this.request = request;
		this.server = serverStub.getServer();
		this.manejador = serverStub.getManejador();
	}
	catch(Exception e){
		e.printStackTrace(); 
	}
}
public void run() {
	try {
		/* Provee servicio e imprime */
		System.out.println("METODO CORRER DEL HILO INICIADO");
		if (request instanceof OpenArgument) {
			OpenArgument argumento = (OpenArgument)request;
			Servidor servidor = server;
			File file = server.abrir(argumento.getFilename());
			OpenedFile of = new OpenedFile(file);
			manejador.setOpenedFile(of);
			this.respuesta = new OpenRespuesta(of.getId());	
		}
	
		else if (request instanceof ReadArgument) {
			ReadArgument argumento = (ReadArgument)request;
			OpenedFile of = manejador.getOpenedFileById(argumento.getFd());
			ReadRespuesta resp = this.server.leer(argumento.getCantidadALeer(),of.getFileInputStream());
			this.respuesta = resp;
		}
		
		else if (request instanceof WriteArgument) {
			WriteArgument argumento = (WriteArgument)request;
			OpenedFile of = manejador.getOpenedFileById(argumento.getFd());	
			WriteRespuesta resp = this.server.escribir(argumento.getBuf(), of.getFileOutputStream());
			this.respuesta = resp;
		}
		
		else {
			CloseArgument argumento = (CloseArgument)request;
			OpenedFile of = manejador.getOpenedFileById(argumento.getFd());
			int resultado = this.server.cerrar(of.getFileInputStream(), of.getFileOutputStream());
			manejador.deleteOpenedFileById(of.getId()); //:TODO nreoslver
			this.respuesta = new CloseRespuesta(resultado);
		}
		
		salida.writeObject(this.respuesta);
	    socketCliente.close();//[TODO] probablemente se deba cerrar acá, ver si no, cierro en otro lado y descomentar/borrar.
		
		/* Fin de un servicio */
		}
		catch(Exception e) {
			e.printStackTrace(); }
		System.out.println("Termine run");
	}


// Getters & Setters
public Socket getSocketCliente() {
	return socketCliente;
}
public void setSocketCliente(Socket socketCliente) {
	this.socketCliente = socketCliente;
}
public ObjectInputStream getEntrada() {
	return entrada;
}
public void setEntrada(ObjectInputStream entrada) {
	this.entrada = entrada;
}
public ObjectOutputStream getSalida() {
	return salida;
}
public void setSalida(ObjectOutputStream salida) {
	this.salida = salida;
}
public Argument getRequest() {
	return request;
}
public void setRequest(Argument request) {
	this.request = request;
}

}

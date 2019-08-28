package punto3b;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class Conexion extends Thread {
	
	private Socket socketCliente;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Argument request;
	private Servidor server;
	private ManejadorArchivos manejador;
	private Respuesta respuesta = null;
	
	
public Conexion (Socket unSocketCliente,ObjectInputStream in, ObjectOutputStream out,Servidor server,Argument request,ManejadorArchivos manejador) {
	try {
		/* Ya hay una conexion con un cliente, streams de I/O */
		socketCliente = unSocketCliente;
		this.entrada = in;
		this.salida = out;	
		this.request = request;
		this.server = server;
		this.manejador = manejador;
		
		/* Al servicio */
//	    System.out.println("Atributos del hilo seteados");
	}
	catch(Exception e){
		e.printStackTrace(); 
	}
}
public void run() {
	try {
	/* Provee servicio e imprime */
//	String datos = "MENSAJE DESDE HILO.";
	
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
    socketCliente.close();
	
	/* Fin de un servicio */
	}
	catch(Exception e) {
		e.printStackTrace(); }
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
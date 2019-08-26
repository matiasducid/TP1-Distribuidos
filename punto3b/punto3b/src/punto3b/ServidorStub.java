package punto3b;

import java.io.FileDescriptor;
import java.io.IOException;


public class ServidorStub {
	private Respuesta respuesta = null;
	private Servidor server = new Servidor();
	
	//Metodos para manejar un cliente nuevo
	
	public Respuesta handleClient(Argument request, ManejadorArchivos manejador) throws ClassNotFoundException, IOException {
		
		if (request instanceof OpenArgument) {
			OpenArgument argumento = (OpenArgument)request;
			FileDescriptor fd = this.server.abrir(argumento.getFilename());
			OpenedFile of = new OpenedFile(fd);
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
			int resultado = this.server.cerrar(of.getFd());
			this.respuesta = new CloseRespuesta(resultado);
		}
		return this.respuesta;
	}
}

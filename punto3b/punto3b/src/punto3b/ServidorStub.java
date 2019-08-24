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
			OpenedFile of = new OpenedFile();
			of.setFd(fd);
			manejador.setOpenedFile(of);
			this.respuesta = new OpenRespuesta(of.getId());
		}
		
		else if (request instanceof ReadArgument) {
			ReadArgument argumento = (ReadArgument)request;
			OpenedFile of = manejador.getOpenedFileById(argumento.getFd());	
			ReadRespuesta resp = this.server.leer(argumento.getCantidadALeer(),of);
			this.respuesta = resp;
		}
		
		else if (request instanceof WriteArgument) {
			
		}
		
		else {
			int resultado = this.server.cerrar(((CloseArgument)request).getFd());
			this.respuesta = new CloseRespuesta(resultado);
		}
		return this.respuesta;
	}
}

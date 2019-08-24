package punto3b;

import java.io.FileDescriptor;
import java.io.IOException;


public class ServidorStub {
	private Respuesta respuesta = null;
	private Servidor server = new Servidor();
	
	//Metodos para manejar un cliente nuevo
	
	public Respuesta handleClient(Argument request) throws ClassNotFoundException, IOException {
		
		if (request instanceof OpenArgument) {
			OpenArgument argumento = (OpenArgument)request;
			FileDescriptor fd = this.server.abrir(argumento.getFilename());
			this.respuesta = new OpenRespuesta(fd);
		}
		
		else if (request instanceof ReadArgument) {
			ReadArgument argumento = (ReadArgument)request;
			ReadRespuesta resp = this.server.leer(argumento.getCantidadALeer(), argumento.getFd());
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

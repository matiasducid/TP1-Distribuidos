package punto3b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ServidorStub {
	Respuesta respuesta = null;
	
	public Respuesta handleClient(Argument request) throws ClassNotFoundException, IOException {
		
		if (request instanceof OpenArgument) {
			Servidor server = new Servidor();
			OpenedFile openedFile = server.abrir(((OpenArgument)request).getFilename());
			this.respuesta = new OpenRespuesta(openedFile);
			System.out.println("estoy en el servidor");
		}
		
		else if (request instanceof ReadArgument) {
			
		}
		
		else if (request instanceof ReadArgument) {
		
		}
		
		else {
			
		}
		return this.respuesta;
	}
}

package punto3b;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Servidor_stub {
	Respuesta respuesta;
	
	public Respuesta handleClient(Argument request) throws FileNotFoundException {
		
		if (request instanceof OpenArgument) {
			Servidor server = new Servidor();
			FileInputStream openedFile = server.abrir(((OpenArgument) request).getFilename());
			this.respuesta = new OpenRespuesta(openedFile);
		}
		
		else if (request instanceof ReadArgument) {
			
		}
		
		else if (request instanceof ReadArgument) {
		
		}
		
		else {
			
		}
		return respuesta;
	}
}

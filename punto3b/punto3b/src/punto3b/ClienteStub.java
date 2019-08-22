package punto3b;

import java.io.FileInputStream;



public class ClienteStub {
	
	public void Abrir(String filename) {
		/* recibir  parametros, crear un objeto argumento que se serialize y luego enviarlo al socket.*/
		byte[] arreglo_temporal = null;
		System.out.println("Abrir button pressed");
		OpenArgument open = new OpenArgument("777", filename);
		SocketClient s = new SocketClient("localhost", 7896);
		OpenRespuesta resp = (OpenRespuesta)s.run(open);
		System.out.println("TERMINE DE PROCESAR TODO");
	
	}
	
	public void leer(int cantidad, FileInputStream openedFile) {

		
	}
	
	public void Escribir() {
		
	}
	
	public void Cerrar() {
		
	}


}

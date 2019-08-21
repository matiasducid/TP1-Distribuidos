package punto3b;

import java.io.FileInputStream;



public class Cliente_stub {
	
	public void abrir(String filename) {
		/* recibir  parametros, crear un objeto argumento que se serialize y luego enviarlo al socket.*/
		//System.out.println(filename + "aaaa");
		OpenArgument openArgument = new OpenArgument();
		//serializar el openArgument y enviarlo al socket del cliente.
		String[] argumentos = {"localhost",filename};
		
		SocketClient.main(argumentos);
	}
	
	public void leer(int cantidad, FileInputStream openedFile) {

		
	}
	
	public void escribir() {
		
	}
	
	public void cerrar() {
		
	}


}

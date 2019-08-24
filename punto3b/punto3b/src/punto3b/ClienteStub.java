package punto3b;

import java.io.FileDescriptor;


public class ClienteStub {
	
	public FileDescriptor Abrir(String filename) {
		OpenArgument argumento = new OpenArgument("777", filename);
		SocketClient s = new SocketClient("localhost", 7896);
		OpenRespuesta respuesta = (OpenRespuesta)s.run(argumento);
		return respuesta.getFd();
	}
	
	
	public ReadRespuesta leer(int cantidad, FileDescriptor fd) {
		ReadArgument argumento = new ReadArgument(fd, cantidad);
		SocketClient s = new SocketClient("localhost", 7896);
		ReadRespuesta respuesta = (ReadRespuesta)s.run(argumento);
		return respuesta;		
	}
	
	
	public void Escribir() {
		
	}
	
	
	public int Cerrar(FileDescriptor fd) {
		CloseArgument argumento = new CloseArgument(fd);
		SocketClient s = new SocketClient("localhost", 7896);
		CloseRespuesta respuesta = (CloseRespuesta)s.run(argumento);
		return respuesta.getStatus();
	}
}

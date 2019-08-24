package punto3b;

import java.io.FileDescriptor;


public class ClienteStub {
	
	public FileDescriptor abrir(String filename,String host, int port) {
		OpenArgument argumento = new OpenArgument("777", filename);
		SocketClient s = new SocketClient(host, port);
		OpenRespuesta respuesta = (OpenRespuesta)s.run(argumento);
		return respuesta.getFd();
	}
	
	
	public ReadRespuesta leer(int cantidad, FileDescriptor fd,String host, int port) {
		ReadArgument argumento = new ReadArgument(fd, cantidad);
		SocketClient s = new SocketClient(host, port);
		ReadRespuesta respuesta = (ReadRespuesta)s.run(argumento);
		return respuesta;		
	}
	
	
	public void escribir(FileDescriptor fd,String host,int port) {
		//WriteArgument argumento = new WriteArgument();
	}
	
	
	public int cerrar(FileDescriptor fd,String host,int port) {
		CloseArgument argumento = new CloseArgument(fd);
		SocketClient s = new SocketClient(host, port);
		CloseRespuesta respuesta = (CloseRespuesta)s.run(argumento);
		return respuesta.getStatus();
	}
}

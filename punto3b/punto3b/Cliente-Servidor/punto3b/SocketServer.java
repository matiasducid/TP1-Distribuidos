package punto3b;

import java.net.*;
import java.io.*; 

public class SocketServer {
	
	public static void main(String args[])  {
		ServidorStub stub = new ServidorStub();
		try {
      		ServerSocket escuchandoSocket = new ServerSocket(7896);
      		while (true) {
      			System.out.println("ESPERANDO CONECCCIONES");
    		    Socket socketCliente = escuchandoSocket.accept();
    		    System.out.println("LLEGO UNA CONECION");
    			ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());
    	        ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
    			Argument request = (Argument)in.readObject();
    		    Respuesta respuesta = stub.handleClient(request);
    		    out.writeObject(respuesta);
    		    socketCliente.close();
      	   	}
		}
     	catch(Exception e) {
      		e.printStackTrace();
     	}
	}
}


package punto3b;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient {
	int puerto;
	String server_name;
	Respuesta respuesta = null;
	
	public SocketClient(String server_name, int puerto) {
	  this.puerto = puerto;
	  this.server_name = server_name;
	}
	
	public Respuesta run(Argument argumento) {
		try {
      		Socket s = new Socket("localhost", 7896);
	        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

      		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
	        out.writeObject(argumento);
	        Respuesta r  = (Respuesta)in.readObject();
	        this.respuesta = r;
			s.close();
	   }
	   catch( Exception e) {
		   System.out.println("ERROR");
		   e.printStackTrace();
	   }
		return this.respuesta;
	}
}

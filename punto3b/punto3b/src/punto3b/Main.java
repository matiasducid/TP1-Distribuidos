package punto3b;

import java.io.IOException;

public class Main {
	static String[] cosa;
	
	public static void main(String args[]) throws IOException  {
		System.out.println("HOLA CAPO ARRANCO LA COSA");
		Cliente cliente = new Cliente();
		SocketServer.main(cosa);
	}
}

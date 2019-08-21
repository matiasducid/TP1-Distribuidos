package punto3b;

public class Main {
	static String[] argumentosCliente = {"localhost", "mensaje"};
	static String[] argumentosServidor = {"arg0","arg1","arg2"};
	public static void main(String args[])  {
	 Ventana v = new Ventana();
	 SocketServer.main(argumentosServidor);
	// SocketClient.main(argumentosCliente);
	 
	 
   }
}

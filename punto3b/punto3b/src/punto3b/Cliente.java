package punto3b;

import java.io.FileDescriptor;

public class Cliente {
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
	}
	
	public void hacer() {
		System.out.println("HOLA CAPO2");
		ClienteStub stub = new ClienteStub();
		
		FileDescriptor fd = stub.Abrir("/home/anele/Escritorio/cosa.py");
		System.out.println("termine de abrir");
		
	}
}

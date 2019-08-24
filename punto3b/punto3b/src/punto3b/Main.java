package punto3b;

import java.io.IOException;

public class Main {
	static String[] cosa;
	
	public static void main(String args[]) throws IOException  {
		//Cliente cliente = new Cliente();
		//Cliente.main(cosa);
		
		System.out.println("HOLA CAPO");
		SocketServer.main(cosa);
	}
}



/*
FileInputStream otro = new FileInputStream(new File("/home/anele/Escritorio/cosa.py"));

FileInputStream file = new FileInputStream(otro.getFD());
int content;

System.out.print((char) (file.read()));
System.out.print((char) (file.read()));
System.out.print((char) (file.read()));
System.out.print((char) (file.read()));
System.out.print((char) (file.read()));
System.out.print((char) (file.read()));
System.out.print((char) (file.read()));

System.out.print("--------------------------------");

FileInputStream file2= new FileInputStream(otro.getFD());
int content2;
System.out.print((char) (file2.read()));
System.out.print((char) (file2.read()));
System.out.print((char) (file2.read()));
System.out.print((char) (file2.read()));
System.out.print((char) (file2.read()));
System.out.print((char) (file2.read()));
*/	

package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Servidor {
	
	//Abrir
	public FileDescriptor abrir(String filename) throws IOException {
		FileInputStream file = new FileInputStream(new File(filename));
		return file.getFD();
	}
	
	
	//Leer
	public ReadRespuesta leer(int cantidadALeer, FileDescriptor fd) {
		ReadRespuesta resp = null;
		FileInputStream openedFile = new FileInputStream(fd);
		StringBuffer buf = new StringBuffer("");
		boolean hayMasDatos = true;
		
		try {
			int i;
			int contador = 0;
			while (contador < cantidadALeer) {
				i = openedFile.read();
				if (i == -1) {
					hayMasDatos = false;
					break;
				}
				else {
					buf.append((char) i);
				}
			}
			resp = new ReadRespuesta(buf, hayMasDatos);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	
	
	//Escribir
	public int escribir() {
		System.out.println("no hace nada");
		return 0;
	}
	
	//Cerrar
	public int cerrar(FileDescriptor fd) throws IOException {
		FileInputStream stream = new FileInputStream(fd);
		stream.close();
		return 0;
	}
}
package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Servidor {
	
	//Abrir
	public FileDescriptor abrir(String filename) throws IOException {
		FileInputStream file = new FileInputStream(new File(filename));
		return file.getFD();
	}
	
	
	//Leer
	public ReadRespuesta leer(int cantidadALeer, FileInputStream fis) {
		ReadRespuesta resp = null;
		StringBuffer buf = new StringBuffer("");
		boolean hayMasDatos = true;
		
		try {
			int i;
			int contador = 0;
			while (contador < cantidadALeer) {
				++contador;
				i = fis.read();
				if (i == -1) {
					hayMasDatos = false;
					break;
				}
				else {
					buf.append((char) i);
				}
			}
			resp = new ReadRespuesta((new String(buf)).getBytes(), hayMasDatos);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	
	
	//Escribir
	public WriteRespuesta escribir(byte[] buffer, FileOutputStream fos) {
		WriteRespuesta resp = null;
		try {
			fos.write(buffer);
			resp = new WriteRespuesta(0);
		} catch (IOException e) {
			resp = new WriteRespuesta(1);
		}
		
		return resp;
	}
	
	//Cerrar
	public int cerrar(FileDescriptor fd) throws IOException {
		FileInputStream stream = new FileInputStream(fd);
		stream.close();
		return 0;
	}
}
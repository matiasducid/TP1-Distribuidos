package punto3b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Servidor {
	
	public OpenedFile abrir(String filename) throws FileNotFoundException {
		File file = new File(filename);
		OpenedFile fos = new OpenedFile(file);
	    return fos;
	}
	
	public void leer(int cantidad, FileInputStream openedFile) {
		try {
			int i;
			StringBuffer buf = new StringBuffer("");

			while ((i = openedFile.read()) != -1) {
				buf.append((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribir() {
		System.out.println("no hace nada");
	}
	
	public void cerrar(FileInputStream openedFile) throws IOException {
		openedFile.close();
	}
}
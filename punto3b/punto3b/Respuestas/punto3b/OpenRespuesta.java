package punto3b;

import java.io.FileInputStream;

public class OpenRespuesta extends Respuesta{

	private static final long serialVersionUID = 1L;
	private OpenedFile openedFile;
	private String argumento_prueba = "argumento pruebaaa";
	
	public String getArgumento() {
		return this.argumento_prueba;
	}
	public FileInputStream getOpenedFile() {
		return (FileInputStream)this.openedFile;
	}

	public void setOpenedFile(OpenedFile openedFile) {
		this.openedFile = openedFile;
	}

	public OpenRespuesta(OpenedFile openedFile) {
		//this.setOpenedFile(openedFile);
		this.argumento_prueba = "hola mundo";
	}
}

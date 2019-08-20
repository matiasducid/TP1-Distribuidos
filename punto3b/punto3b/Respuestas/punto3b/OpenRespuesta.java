package punto3b;

import java.io.FileInputStream;

public class OpenRespuesta extends Respuesta{
	FileInputStream openedFile;
	
	public FileInputStream getOpenedFile() {
		return openedFile;
	}

	public void setOpenedFile(FileInputStream openedFile) {
		this.openedFile = openedFile;
	}

	public OpenRespuesta(FileInputStream openedFile) {
		this.setOpenedFile(openedFile);
	}
}

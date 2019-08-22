package punto3b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

public class OpenedFile extends FileInputStream implements Serializable{


	private static final long serialVersionUID = 1L;

	public OpenedFile(File file) throws FileNotFoundException {
		super(file);
	}

}

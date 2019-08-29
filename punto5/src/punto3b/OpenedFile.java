package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OpenedFile {

	private static int id = 0;
	private File file;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		OpenedFile.id = id;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
	public FileInputStream getFileInputStream() throws FileNotFoundException {
		if (this.fileInputStream != null) {
			return this.fileInputStream;
		}
		else {
			this.setFileInputStream(new FileInputStream(this.getFile()));
			return this.fileInputStream;
		}
	}
	
	
	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	
	
	public FileOutputStream getFileOutputStream() throws FileNotFoundException {
		if(this.fileOutputStream != null) {
//			System.out.println("TENGO UN FOS Y LO DEVUELVO");
			return this.fileOutputStream;
		}
		else {
//			System.out.println("NO TENGO LO CREO Y LO DEVUELVO");
			this.setFileOutputStream(new FileOutputStream(this.getFile()));
			return this.fileOutputStream;
		}
		
	}
	
	
	
	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}
	
	public OpenedFile(File file) throws FileNotFoundException {
		this.setId(++id);
		this.setFile(file);
	}
}

package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OpenedFile {

	private static int id = 0;
	File file;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	
	
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
	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}
	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}
	
	public OpenedFile(File file) throws FileNotFoundException {
		this.setId(++id);
		this.setFileInputStream(new FileInputStream(file));
		this.setFileOutputStream(new FileOutputStream(file));
		this.setFile(file);
	}
}

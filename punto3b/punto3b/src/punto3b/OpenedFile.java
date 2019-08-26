package punto3b;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OpenedFile {

	private static int id = 0;
	FileDescriptor fd;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		OpenedFile.id = id;
	}
	
	public FileDescriptor getFd() {
		return fd;
	}
	public void setFd(FileDescriptor fd) {
		this.fd = fd;
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
	
	public OpenedFile(FileDescriptor fd) {
		this.setId(++id);
		this.setFd(fd);
		this.setFileInputStream(new FileInputStream(fd));
		this.setFileOutputStream(new FileOutputStream(fd));
	}
}

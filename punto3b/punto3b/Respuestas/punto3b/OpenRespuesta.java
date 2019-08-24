package punto3b;

import java.io.FileDescriptor;

public class OpenRespuesta extends Respuesta{

	private static final long serialVersionUID = 1L;
	private FileDescriptor fd;

	public FileDescriptor getFd() {
		return fd;
	}

	public void setFd(FileDescriptor fd) {
		this.fd = fd;
	}
	
	public OpenRespuesta(FileDescriptor fd) {
		this.setFd(fd);		
	}
}

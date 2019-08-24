package punto3b;

import java.io.FileDescriptor;

public class ReadArgument extends Argument {

	FileDescriptor fd;
	int cantidadALeer;

	public int getCantidadALeer() {
		return cantidadALeer;
	}

	public void setCantidadALeer(int cantidadALeer) {
		this.cantidadALeer = cantidadALeer;
	}

	public FileDescriptor getFd() {
		return fd;
	}

	public void setFd(FileDescriptor fd) {
		this.fd = fd;
	}
	
	public ReadArgument(FileDescriptor fd, int cantidadALeer) {
		this.setFd(fd);
		this.setCantidadALeer(cantidadALeer);
	}
}

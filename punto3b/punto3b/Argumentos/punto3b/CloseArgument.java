package punto3b;

import java.io.FileDescriptor;

public class CloseArgument extends Argument {

	private FileDescriptor fd;

	public FileDescriptor getFd() {
		return fd;
	}

	public void setFd(FileDescriptor fd) {
		this.fd = fd;
	}
	
	public CloseArgument(FileDescriptor fd) {
		this.setFd(fd);
	}
}

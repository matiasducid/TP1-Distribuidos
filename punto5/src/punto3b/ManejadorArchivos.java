package punto3b;

import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {

	private List<OpenedFile> arrayOpenedFiles = new ArrayList<OpenedFile>();
	
	
	public OpenedFile getOpenedFileById(int fileDescriptor) {
		OpenedFile of = null;
		for (int i = 0; i < arrayOpenedFiles.size(); i++) {
			of = arrayOpenedFiles.get(i);
			if (of.getId() == fileDescriptor) {
				return of;
			}
			else {
				of = null;
			}
		}
		return of;
	}
	
	
	public void deleteOpenedFileById(int id) {
		for (int i = 0; i < arrayOpenedFiles.size(); i++) {
			/*
			OpenedFile of = arrayOpenedFiles.get(i);
			if (of.getId() == id) {
				arrayOpenedFiles.remove(of);
			}*/
			OpenedFile of = arrayOpenedFiles.get(i);
			this.arrayOpenedFiles.remove(of);
		}
	}
	
	
	public void setOpenedFile(OpenedFile openedFile) {
		this.arrayOpenedFiles.add(openedFile);
	}
}

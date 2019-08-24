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
	
	
	public void setOpenedFile(OpenedFile openedFile) {
		this.arrayOpenedFiles.add(openedFile);
	}
}


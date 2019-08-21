package punto3b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Boton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public Boton(String nombre_boton) {
		super(nombre_boton);
		this.addActionListener(this); /* Significa que esta clase maneja ella misma los eventos de click */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aux="";   
		String texto="";
	
		if (e.getActionCommand() == "Abrir") {
			System.out.println("Abrir button pressed");
			
			//ACA DEBO CREAR UN JFileChooser para elegir el path.
			Component component = (Component) e.getSource(); 
			JFrame frame = (JFrame) SwingUtilities.getRoot(component);//obtengo el frame donde se encuentra el boton.
			JFileChooser file=new JFileChooser();
			frame.add(file); // Agrego al frame el buscador de archivos.
			frame.setVisible(true);

			/**llamamos el metodo que permite cargar la ventana*/
			file.showOpenDialog(this);
			/**abrimos el archivo seleccionado*/
			File abre=file.getSelectedFile();
		 
			/**recorremos el archivo, lo leemos para plasmarlo
			 *en el area de texto*/
			if(abre!=null)
			{     
				String path = abre.getAbsolutePath();
				System.out.println(path);
				Cliente_stub clienteStub = new Cliente_stub();
				clienteStub.abrir(path);
			}    				
		}
		if (e.getActionCommand() == "Leer") {
			System.out.println("Leer button pressed");			
			String[] argumentosCliente = {"localhost", "mensaje del leer"};
			SocketClient.main(argumentosCliente);
			

			//ACA DEBO CREAR UN JFileChooser para elegir el path.
			Component component = (Component) e.getSource(); 
			JFrame frame = (JFrame) SwingUtilities.getRoot(component);//obtengo el frame donde se encuentra el boton.
			JFileChooser file=new JFileChooser();
			frame.add(file); // Agrego al frame el buscador de archivos.
			frame.setVisible(true);

			try
			{
				/**llamamos el metodo que permite cargar la ventana*/
//				JFileChooser file=new JFileChooser();
				file.showOpenDialog(this);
				/**abrimos el archivo seleccionado*/
				File abre=file.getSelectedFile();
			 
				/**recorremos el archivo, lo leemos para plasmarlo
				 *en el area de texto*/
				if(abre!=null)
				{     
					FileReader archivos=new FileReader(abre);
					BufferedReader lee=new BufferedReader(archivos);
					while((aux=lee.readLine())!=null)
					{
						texto+= aux+ "\n";
					}
					lee.close();
				}    
			}
			catch(IOException ex)
			{
				JOptionPane.showMessageDialog(null,ex+"" +
						"\nNo se ha encontrado el archivo",
						"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
			System.out.println(texto);//El texto se almacena en el JTextArea
			//aca tiene que tener el filepath y los permisos 
			//llamar al stub el cliente a la funcion abrir
		}
		System.out.println("nada desde boton.");
	}	
}

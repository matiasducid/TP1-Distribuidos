package punto3b;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ServidorStub {
	
	private Respuesta respuesta = null;
	private Servidor server = new Servidor();
	private ManejadorArchivos manejador = new ManejadorArchivos();
	
	private List<Conexion>  misHilos = new ArrayList<Conexion>();
	
	
	private boolean existeHilo(Socket socketNuevo) {
		int i ;
		int topeLista = this.misHilos.size();
		boolean varRetorno = false;
		System.out.println("SE ME CONSULTO");
		System.out.println(topeLista);
		i = 0;
		while(i< topeLista) {
			
			Conexion hilo = this.misHilos.get(i);
			Socket socket = hilo.getSocketCliente();
			System.out.println("El socket a comparar: \n"+socketNuevo+"\n El socket que saco de la lista:\n"+socket);
			if(socket == socketNuevo) {
				varRetorno = true;
			}
			++i;
		}
		System.out.println("RESULTADO CONSULTA = "+varRetorno);
		return varRetorno;
		
	}
	
	private List<Integer> getPosicionesABorrar(){
		List<Integer> posicionesABorrar = new ArrayList<Integer>();
		List<Conexion> listaHilos = this.misHilos;
		int i;
		int topeLista = listaHilos.size();
		i = 0;
		while (i < topeLista) {
			Conexion hilo = listaHilos.get(i);
			if (!hilo.isAlive()) {
				posicionesABorrar.add(i);
			}
			++i;
		}		
		return posicionesABorrar;
	}
	
	
	private void actualizarLista() {//Metodo para limpiar la lista de hilos(QUITAR LOS HILOS TERMINADOS Y ORDENAR LA LISTA).
		List<Conexion> listaHilos = this.misHilos;
		List<Integer> posicionesABorrar = new ArrayList<Integer>();
		int j,k;
		j = 0;
		
		posicionesABorrar = getPosicionesABorrar();//Obtengo de la lista de hilos, la posicion de cada hilo TERMINADO.
		while(j<posicionesABorrar.size()) {
			listaHilos.remove(posicionesABorrar.get(j));
			++j;
		}
		k =0;
		while(k<posicionesABorrar.size()) {
			posicionesABorrar.remove(k);
			++k;
		}
		//listaHilos.sort(Comparator.comparing( String::toString ));
	}
	
	
	public void run() {
		try {
			//Falta que el servidorstub limpie y oredene su lista de hilos con los que siguen corriendo solamente.
//			actualizarLista();	
			ServerSocket escuchandoSocket = new ServerSocket(7896);
      		while (true) {
    		    Socket socketCliente = escuchandoSocket.accept();
    		    System.out.println("ACEPTE UN CLIENTE NUEVO");
    			//VERIFICO SI EL HILO YA EXISTE EN MI LISTA, SI EXISTE PARA ESTE SOCKETCLIENTE NO INSTANCIO OTRO.
//    		    if(existeHilo(socketCliente)) {
//    		    	System.out.println("Existe un hilo para este cliente que ya se ejecuto");
//    		    }
//    		    else {
//    		    	ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());
//        	        ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
//        			Argument request = (Argument)in.readObject();
    		    	Conexion hilo = new Conexion(socketCliente,this);
//        			this.misHilos.add(hilo);
        			hilo.start();
//    		    }    		    
      	   	}
		}
     	catch(Exception e) {
      		e.printStackTrace();
     	}
	}
	
	public static void main() {
//		try {
//			int puertoServicio = 7896;
//			ServerSocket escuchandoSocket = new ServerSocket(puertoServicio);
//			while (true) {
//				/* Espera conexion de un cliente */
//				Socket socketCliente = escuchandoSocket.accept();
//				/* Crea un thread para el servicio al cliente */
//				//Conexion c = new Conexion(socketCliente);
//				}
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
		}

// Getters & Setters
	public ManejadorArchivos getManejador() {
		return manejador;
	}

	public void setManejador(ManejadorArchivos manejador) {
		this.manejador = manejador;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Servidor getServer() {
		return server;
	}

	public void setServer(Servidor server) {
		this.server = server;
	}

	public List<Conexion> getMisHilos() {
		return misHilos;
	}

	public void setMisHilos(List<Conexion> misHilos) {
		this.misHilos = misHilos;
	}
		
	
}

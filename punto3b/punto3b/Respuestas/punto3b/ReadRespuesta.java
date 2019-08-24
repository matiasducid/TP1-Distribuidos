package punto3b;

public class ReadRespuesta extends Respuesta {

	StringBuffer buf;
	boolean hayMasDatos;

	
	public String[] getBuffer() {
		return getBuffer();
	}
	public void setBuffer(StringBuffer buffer) {
		this.buf = buffer;
	}
	public boolean isHayMasDatos() {
		return hayMasDatos;
	}
	public void setHayMasDatos(boolean hayMasDatos) {
		this.hayMasDatos = hayMasDatos;
	}
	
	public ReadRespuesta(StringBuffer buffer, boolean hayMasDatos) {
		this.setBuffer(buffer);
		this.setHayMasDatos(hayMasDatos);
	}
}

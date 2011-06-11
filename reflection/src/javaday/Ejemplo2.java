package javaday;

public class Ejemplo2 {

	public static void main(String[] args) {
		Cliente c = new Cliente("22.222.222-2", "Perico de los Palotes");
		Persona p = new Persona();
		p.nombre = c	.nombreCompleto;
		p.rut = c.identificador;
		p.saludar();
	}	
}

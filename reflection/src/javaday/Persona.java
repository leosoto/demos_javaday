package javaday;

public class Persona {
	public String nombre;
	public String rut;
	
	public Persona() {};
	
	public Persona(String rut, String nombre) {
		this.rut = rut;
		this.nombre = nombre;
	}
	
	public void saludar() {
		System.out.printf("Hola!, yo soy %s\n", this.nombre);
	}
}

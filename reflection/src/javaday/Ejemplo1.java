package javaday;

public class Ejemplo1 {

	public static void main(String[] args) throws Exception {
		Persona j = new Persona("11.111.111-1", "Juan Perez");
		print(j.nombre);
		print(getAttr(j, "nombre"));
		
		print(j.rut);
		print(getAttr(j, "rut"));
		
		setAttr(j, "nombre", "Juan Francisco Perez");
		print(j.nombre);
		
		j.saludar();
		Persona.class.getMethod("saludar").invoke(j);
	}
	
	private static void print(Object o) {
		System.out.println(o.toString());
	}
	
	private static Object getAttr(Object obj, String name) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		Class<?> c = obj.getClass();
		return c.getField(name).get(obj);
	}
	
	private static void setAttr(Object obj, String name, Object value) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		Class<?> c = obj.getClass();
		c.getField(name).set(obj, value);
	}
	
}

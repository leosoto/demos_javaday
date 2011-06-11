package javaday;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo3 {

	public static void main(String[] args) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		Cliente c = new Cliente("22.222.222-2", "Perico de los Palotes");
		Mapper<Cliente, Persona> mapper = new Mapper<Cliente, Persona>();
		mapper.addFieldMapping("identificador", "rut");
		mapper.addFieldMapping("nombreCompleto", "nombre");
		Persona p = mapper.map(c);
		p.saludar();
	}

	static class Mapper<S, D> {
		Map<String, String> fieldMap = new HashMap<String, String>();
		public void addFieldMapping(String srcField, String dstField) {
			fieldMap.put(srcField, dstField);
		}
		
		public void map(S src, D dst) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
			for(String srcField: fieldMap.keySet()) {
				String dstField = fieldMap.get(srcField);
				setAttr(dst, dstField, getAttr(src, srcField));
			}
		}
		
		public D map(S src, Class<D> klass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, NoSuchFieldException {
			D dst = klass.newInstance();
			map(src, dst);
			return dst;
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
}

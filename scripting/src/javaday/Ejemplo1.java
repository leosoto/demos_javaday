package javaday;

import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Ejemplo1 {
	public static void main(String[] args) throws ScriptException {
	    ScriptEngineManager factory = new ScriptEngineManager();
	    ScriptEngine engine = factory.getEngineByName("JavaScript");
	    engine.eval("print('Hola Mundo\\n')");
	    engine.put("nombres", Arrays.asList("Pedro", "Juan", "Diego"));
	    engine.eval("print(nombres.size() + '\\n')");
	    engine.eval("print(nombres.get(2) + '\\n')");
	}
}

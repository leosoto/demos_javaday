package javaday;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Ejemplo1 {
	public static void main(String[] args) throws Exception {
		File hello = new File("src/Hello.java");
		FileWriter fstream = new FileWriter(hello);
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write("public class Hello {");
	    out.write("  public static void hello() { ");
	    out.write("    System.out.print(\"Hola Mundo\");");
	    out.write("  }");
	    out.write("}");
	    out.close();
	    fstream.close();

	    JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = jc.getStandardFileManager(null, null, null);
	    Iterable<? extends JavaFileObject> fileObjects = manager.getJavaFileObjects(hello);
	    List<String> options = Arrays.asList("-d", "bin");
	    jc.getTask(null, manager, null, options, null, fileObjects).call();
	    manager.close();
	    Class<?> helloClass = Class.forName("Hello");
	    helloClass.getMethod("hello").invoke(null);
	}
}

package Compiler;

import org.openjdk.tools.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class JavaC {
/*
	public JavaC(String[] args, File source){
		this.args = args;
		this.source = source;
	}
*/
	public JavaC(String[] args, JavaFileObject javaFileObject){
		this.args = args;
		this.internalFile = javaFileObject;
	}

	private String[] args;
	private File source;
	private JavaFileObject internalFile;
	private boolean MakeJavaFile;

	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();


	public void CompileAndRun(){
		//compiler.run(System.in, System.out, System.err, source.getAbsolutePath());

		//Compile
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(this.internalFile);
		JavaCompiler.CompilationTask a = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);
		a.call();

		//Run the generated out.class file, if theres no errors from java compiler
		if (diagnostics.getDiagnostics().isEmpty()) {
			try {
				//executeProcessAndShow("java -cp src/Output out");
				executeProcessAndShow("java out");
			} catch (IOException ex) {
				System.out.println("Error" + ex.getMessage());
			}
		}
		else{
			//Report java-compiler errors
			System.out.println("Java compiler encountered error(s):");
			for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
				//System.out.println(diagnostic.getCode());
				//System.out.println(diagnostic.getKind());
				//System.out.println(diagnostic.getPosition());
				//System.out.println(diagnostic.getStartPosition());
				//System.out.println(diagnostic.getEndPosition());
				//ystem.out.println(diagnostic.getSource());
				System.out.print(diagnostic.getMessage(null));
				System.out.print(" at: " + diagnostic.getPosition() + "\n");
			}
		}

	}

	private void executeProcessAndShow(String cmd) throws IOException{
		//Process proc = Runtime.getRuntime().exec("java -cp . src/Output out");
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(cmd);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		StringBuffer stdout = new StringBuffer();
		StringBuffer errout = new StringBuffer();

		// read the output from the command
		//System.out.println("Output:");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
			stdout.append(s);
		}

		// read any errors from the attempted command
		/*
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
			errout.append(s);
		}
		*/

		//System.out.println(stdInput.toString());
	}

}

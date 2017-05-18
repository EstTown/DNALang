package Compiler;

import org.openjdk.tools.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class OutputCompiler {

	public OutputCompiler(String[] args){
		this.args = args;
	}

	private String[] args;

	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

	public void Compile(){
		compiler.run(null, null, null, "src/Output/out.java");
	}

	public void CompileAndRun(){
		//Remove old .class file???

		compiler.run(System.in, System.out, System.err, "src/Output/out.java");
		try {
			executeProcessAndShow("java -cp src/Output out");
		}catch (IOException ex){
			System.out.println("Error" + ex.getMessage());
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
		System.out.println("Output:");
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

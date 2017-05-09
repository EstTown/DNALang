package ASTNodes;

public class Error {

	private String msg;
	private int lineNo;
	private int charNo;
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	public Error(String msg){
		this.msg = msg;
	}

	public Error(String msg, int lineNumber, int charNumber){
		this.msg = msg;
		this.lineNo = lineNumber;
		this.charNo = charNumber;
	}

	public String getMessage(){
		if (lineNo == 0 && charNo == 0)
			return ANSI_RED + this.msg + ANSI_RESET;
		else
			return ANSI_RED + "Error: line: " + this.lineNo + "; at: " + this.charNo + "; " + this.msg + ANSI_RESET;
	}

}

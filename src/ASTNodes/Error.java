package ASTNodes;

public class Error {

	private String msg;
	private int lineNo;
	private int charNo;

	public Error(String msg){
		this.msg = msg;
	}

	public Error(String msg, int lineNumber, int charNumber){
		this.msg = msg;
		this.lineNo = lineNumber;
		this.charNo = charNumber;
	}



}

package Complexity_Mesuring_Tool;

import java.util.ArrayList;
import java.util.List;

public class Cuupling_Method {

	//moethod full body
	String methodBody;
	
//	        Wr = Weight of a recursive call
//			Nr = Number of recursive calls
	boolean isRecursiveCall;
	String recursiveCallNo="";
//			Wmcms = Weight of a regular method calling another regular method in the same file
//			Nmcms = Number of calls from regular method(s) to other regular methods in the same file
	List<String> callToNormalMethodsOfThis = new ArrayList<String>();
//			Wmcmd = Weight of a regular method calling another regular method in a different file
//			Nmcmd = Number of calls from regular method(s) to other regular methods in different files
	List<String> callToNormalMethodsOfOther = new ArrayList<String>();
	public String getMethodBody() {
		return methodBody;
	}
	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}
	public boolean isRecursiveCall() {
		return isRecursiveCall;
	}
	public void setRecursiveCall(boolean isRecursiveCall) {
		this.isRecursiveCall = isRecursiveCall;
	}
	public String getRecursiveCallNo() {
		return recursiveCallNo;
	}
	public void setRecursiveCallNo(String recursiveCallNo) {
		this.recursiveCallNo = recursiveCallNo;
	}
	public List<String> getCallToNormalMethodsOfThis() {
		return callToNormalMethodsOfThis;
	}
	public void setCallToNormalMethodsOfThis(List<String> callToNormalMethodsOfThis) {
		this.callToNormalMethodsOfThis = callToNormalMethodsOfThis;
	}
	public List<String> getCallToNormalMethodsOfOther() {
		return callToNormalMethodsOfOther;
	}
	public void setCallToNormalMethodsOfOther(List<String> callToNormalMethodsOfOther) {
		this.callToNormalMethodsOfOther = callToNormalMethodsOfOther;
	}

//			Wmcrms = Weight of a regular method calling a recursive method in the same file
//			Nmcrms = Number of calls from regular method(s) to recursive methods in the same file

//			Wmcrmd = Weight of a regular method calling a recursive method in a different filem
//			Nmcrmd = Number of calls from regular method(s) to recursive methods in different files
	
//			Wrmcrms = Weight of a recursive method calling another recursive method in the same file
//			Nrmcrms = Number of calls from recursive method(s) to other recursive methods in the same file
	
//			Wrmcrmd = Weight of a recursive method calling another recursive method in a different file
//			Nrmcrmd = Number of calls from recursive method(s) to other recursive methods in different files
//			Wrmcms = Weight of a recursive method calling a regular method in the same file
//			Nrmcms = Number of calls from recursive method(s) to regular methods in the same file
//			Wrmcmd = Weight of a recursive method calling a regular method in a different file
//			Nrmcmd = Number of calls from recursive method(s) to regular methods in different files
//			Wmrgvs = Weight of a regular method referencing a global variable in the same file
//			Nmrgvs = Number of references from regular method(s) to global variables in the same file
//			Wmrgvd = Weight of a regular method referencing a global variable in a different file
//			Nmrgvd = Number of references from regular method(s) to global variables in different files
//			Wrmrgvs = Weight of a recursive method referencing a global variable in the same file
//			Nrmrgvs = Number of references from recursive method(s) to global variables in the same file
//			Wrmrgvd = Weight of a recursive method referencing a global variable in a different file
//			Nrmrgvd = Number of references from recursive method(s) to global variable in different files
	
	

}

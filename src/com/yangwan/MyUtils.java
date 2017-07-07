package com.yangwan;

public final class MyUtils {
	
	public static final int FUNCTION_LINE = 1;
	public static final int VALUE_LINE = 2;
	public static final int ERROR_LINE = 0;
	
	public static int MathLine(String lineContent){
		
		if(lineContent.contains("function(params,resultCallback)")){
			return FUNCTION_LINE;
		}else if(lineContent.contains("new BWAERpc")){
			return VALUE_LINE;
		}else{
			return ERROR_LINE;
		}
	}
}

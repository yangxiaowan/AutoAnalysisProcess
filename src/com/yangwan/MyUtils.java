package com.yangwan;

import java.util.HashMap;
import java.util.Map;

public final class MyUtils {
	
	public static final int SERVICE_LINE = 1;
	public static final int FUNCTION_LINE = 2;
	public static final int EXCEPTION_LINE = 3;
	public static final int VALUE_LINE = 4;
	public static final int END_LINE = 5;
	public static final int ERROR_LINE = 0;
	
	public static HashMap<String, HashMap<String, String>> serviceInterfaceMap = new HashMap<String, HashMap<String, String>>();
	
	public static int MathLine(String lineContent){
		
		if(lineContent.contains("function(params,resultCallback)")){
			return FUNCTION_LINE;
		}else if(lineContent.contains("new BWAERpc")){
			return VALUE_LINE;
		}else if(lineContent.contains("if(typeof BWAEPATH")){
			return EXCEPTION_LINE;
		}else if(lineContent.contains("={};")){
			if(!lineContent.equals("BWAE.cash_special={};")){
				return SERVICE_LINE;
			}else{
				return ERROR_LINE;
			}
		}else if(lineContent.contains("};")){
			return END_LINE;
		}else{
			return ERROR_LINE;
		}
	}
}

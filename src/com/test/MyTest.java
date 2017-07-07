package com.test;

import com.yangwan.FileReader;
import com.yangwan.MyUtils;

public class MyTest {
	
	public static void main(String[] agrs){
		String filePath = "C:\\Users\\yangwan\\git\\qmc-mgr_cash-special\\target\\bwae\\srv-api\\META-INF\\js\\bwaerpc-i.js";
		FileReader myFileReader = new FileReader(filePath,"cash_special");
		myFileReader.openFileAndGetStream();
		myFileReader.analysisFile();
		System.out.println(MyUtils.serviceInterfaceMap);
	}
}

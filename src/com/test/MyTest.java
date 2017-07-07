package com.test;

import java.util.ArrayList;
import java.util.List;

import com.yangwan.DataUtils;
import com.yangwan.FileReader;
import com.yangwan.MyUtils;

public class MyTest {
	
	public static void main(String[] agrs){
		String filePath = "C:\\Users\\chenyangyang\\git\\qmc-mgr_cash\\target\\bwae\\srv-api\\META-INF\\js\\bwaerpc-i.js";
		FileReader myFileReader = new FileReader(filePath);
		myFileReader.openFileAndGetStream();
		List<String> list = myFileReader.analysisFile();
		List<String> arrayList = new ArrayList<String>();
		DataUtils dataUtils = new DataUtils();
		boolean bol = dataUtils.getConnectionToSQL();
		if(bol){
			for(int i=0;i<list.size();i+=3){
				arrayList=list.subList(i, i+3);
				dataUtils.saveData(arrayList);
			}
			dataUtils.closeSql();
		}
	}
}

package com.yangwan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FileReader {
	
	private String moduleName = null;
	
	private File file = null;
	
	private String filePath = null;
	
	private BufferedReader br;
	
	public FileReader(String filePath, String mdName){
		this.filePath = filePath;
		this.moduleName = "BWAE."+mdName;
	}
	
	public void openFileAndGetStream(){
		file = new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("获取文件流失败");
		}
		InputStreamReader isReader = new InputStreamReader(fis);
		br = new BufferedReader(isReader);
	}
	
	public void analysisFile(){
		try{
			String lineContent = null;
			String[] interfaceName = {"","","",""};
			HashMap<String, String> serviceMap = null;
			while((lineContent = br.readLine()) != null){
				switch(MyUtils.MathLine(lineContent)){
				case MyUtils.SERVICE_LINE:
					serviceMap = new HashMap<String, String>();
					lineContent = lineContent.replace("={};","");
					String[] splits = lineContent.split("\\.");
					MyUtils.serviceInterfaceMap.put(splits[2], serviceMap);
					break;
				case MyUtils.FUNCTION_LINE:
					lineContent = lineContent.replace(" = function(params,resultCallback){", "");
					interfaceName = lineContent.split("\\.");
					break;
				case MyUtils.VALUE_LINE:
					String[] value = lineContent.split("'");
					serviceMap.put(interfaceName[3], value[3]);
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("readline error!!!!!");
		}
	}
}

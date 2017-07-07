package com.yangwan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
	
	private File file = null;
	
	private String filePath = null;
	
	private BufferedReader br;
	
	public FileReader(String filePath){
		this.filePath = filePath;
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
	
	public List analysisFile(){
		String lineContent = null;
		List<String> list = new ArrayList<String>();
		String pattern = "";
		Pattern r = null;
		Matcher m = null;
		try{
			while((lineContent = br.readLine()) != null){
				switch(MyUtils.MathLine(lineContent)){
				case MyUtils.FUNCTION_LINE:
					 pattern = "(\\.)(\\w+)(\\.)(\\D+)(\\s\\=)";
					 r = Pattern.compile(pattern);
					 m = r.matcher(lineContent);
					 if (m.find( )) {
					 list.add(m.group(4).trim());
					 }
					break;
				case MyUtils.VALUE_LINE:
					 pattern = "(\\[\\')(\\w+)(\\'\\])(\\+\\')(\\D+\\w+)";
					 r = Pattern.compile(pattern);
					 m = r.matcher(lineContent);
					 if (m.find( )) {
					 list.add(m.group(2).replace("_", "-").trim());
					 list.add(m.group(5).trim());
					 }
					break; 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("readline error!!!!!");
		}
		return list;
	}
}

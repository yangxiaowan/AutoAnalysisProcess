package com.test;

import com.yangwan.DataUtils;

public class DataTest {
	
	public static void main(String[] agrs){
		DataUtils dataUtils = new DataUtils();
		if(dataUtils.getConnectionToSQL()){
			System.out.println("�������ݿ�ɹ�");
		}
	}
}

package com.yangwan;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4346251008247726567L;
	private Object mData[][] = null;
	private HashMap<String, HashMap<String, String>> mapData = null;
	public MyTableModel(HashMap<String, HashMap<String, String>> displayData){
		this.mapData = displayData;
	}
	
	private Class []cellType={String.class,String.class,String.class};  
	
	private final String title[]={"服务名称","接口名称","MD5值"}; 
	
	public void initDisplayData(){
		int mapNum = mapData.size();
		
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return cellType[columnIndex];
	}
	
	@Override  
    public String getColumnName(int index) {  
        return title[index];  
    }  
	
	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public int getRowCount() {
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return mData[row][column];
	}
	
	@Override
	public boolean isCellEditable(int r,int c)  
    {  
        return true;  
    }  
	
	@Override
	public void setValueAt(Object value,int r,int c)  
    {  
        mData[r][c]=value;  
        this.fireTableCellUpdated(r,c);  
    }  
}

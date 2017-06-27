package com.yangwan;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class WindowsGUI extends JFrame {
	
	private String inputFilePath = null;
	
	private JTextField inputFileEditor = null;
	
	private JButton analysisiButton = null;
	
	private JLabel filepathLable = null;
	
	private JTable table;  
	
    private MyTableModel model;  
    
	public WindowsGUI(){
		initFrame();
	}
	
	public void initFrame(){
		this.setTitle("文档编写助手");
		this.setSize(800,1000);
		this.setLayout(null);
		filepathLable = new JLabel();
		filepathLable.setText("文件路径: ");
		filepathLable.setFont(new Font("黑体",Font.BOLD,18));
		analysisiButton = new JButton("自动生成列表");
		inputFileEditor = new JTextField();
		filepathLable.setSize(140,40);
		filepathLable.setLocation(40,50);
		inputFileEditor.setSize(300, 40);
		inputFileEditor.setLocation(160, 50);
		analysisiButton.setSize(200, 40);
		analysisiButton.setLocation(500, 50);
		model = new MyTableModel(null);
		table=new JTable(model);  
		table.setSize(500,400);
		table.setLocation(50,120);
		this.add(inputFileEditor);
		this.add(analysisiButton);
		this.add(filepathLable);
		this.add(table);
		this.setVisible(true);
	}
}

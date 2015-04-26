package com.hama.studentsmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.example.studentsmanager.R;
import com.hama.VO.Group;
import com.hama.VO.Lession;
import com.hama.VO.Student;
import com.hama.VO.TheClass;
import com.hama.VO.Union;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Union union = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		Button start = (Button) findViewById(R.id.start_0);
		start.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				File file = new File(Environment.getExternalStorageDirectory().toString() + "/学生会/学生会.xls");
				String s = String.valueOf(file.exists());
				
				Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
				
				System.out.println(Environment.getExternalStorageDirectory().getAbsolutePath().toString());
				
				Toast.makeText(MainActivity.this, "信息初始化...", Toast.LENGTH_SHORT).show();
				init();
				Toast.makeText(MainActivity.this, "初始化完成", Toast.LENGTH_SHORT).show();
				Intent begin = new Intent(MainActivity.this, SelectLevel.class);
				begin.putExtra("union", union);
				startActivity(begin);
//				 m																									 
//				File file = new File(Environment.getExternalStorageDirectory().toString());
//				File[] files = file.listFiles();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * 学生会信息初始化
	 */
	public void init() {
		union = new Union(0, "学生会");
		Map<String, TheClass> classes = new HashMap<String, TheClass>();
		Map<String, TheClass> classes_h = new HashMap<String, TheClass>();
//		for(int i = 1; i <= 10; i ++) {
//			String className = "软件" + i + "班";
//			TheClass tclass = new TheClass(className);
//			readScheme(tclass, 1);
//			classes.put(className, tclass);
//		}
//		for(int i = 1; i <= 4; i ++) {
//			String className = "集成" + i + "班";
//			TheClass tClass = new TheClass(className);
//			readScheme(tClass, 1);
//			classes.put(className, tClass);
//		}
//		for(int i = 1; i <= 10; i ++) {
//			String className = "软件" + i + "班";
//			TheClass tclass = new TheClass(className);
//			readScheme(tclass, 2);
//			classes_h.put(className, tclass);
//		}
//		for(int i = 1; i <= 4; i ++) {
//			String className = "集成" + i + "班";
//			TheClass tClass = new TheClass(className);
//			readScheme(tClass, 2);
//			classes_h.put(className, tClass);
//		}
		
		//   部门设定
		Map<String, Group> groups = new HashMap<String, Group>();
		
		Workbook book = null;
		File file = null;
		InputStream inStream = null;
		try {
//			file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile().toString() + "/学生会/学生会.xls");
//			inStream = new FileInputStream(file);
			inStream = getAssets().open("union.xls");
			book = Workbook.getWorkbook(inStream);
			Sheet readsheet = book.getSheet(0);   
			int rsColumns = readsheet.getColumns();   
			int rsRows = readsheet.getRows();   
			for (int i = 2; i < rsRows; i++) {   
//				for (int j = 0; j < rsColumns; j++)  {   
//					Cell cell = readsheet.getCell(j, i);   
//					System.out.print(cell.getContents() + " ");   
//				}  
				
				// 部门
				Cell cell_1 = readsheet.getCell(0, i);
				String groupName = cell_1.getContents();
				Group group = groups.get(groupName);
				if(group == null) {
					group = new Group();
					group.setName(groupName);
					groups.put(groupName, group);
				}
				// 姓名
				Cell cell_2 = readsheet.getCell(1, i);
				String stuName = cell_2.getContents();
				Student stu = new Student(i, stuName);
				group.addMate(stuName, stu);
				// 班级
				Cell cell_3 = readsheet.getCell(3, i);
				String sClass = cell_3.getContents();
				TheClass theClass = classes.get(sClass);
				if(theClass == null) {
					theClass = new TheClass(sClass);
					readScheme(theClass, 1);
					classes.put(sClass, theClass);
				}
				theClass.addStu(stuName, stu);
				stu.setTheClass(theClass);
				// 电话
				Cell cell_4 = readsheet.getCell(5, i);
				String tel = cell_4.getContents();
				stu.setTel(tel);
//				System.out.println(groupName + "  " + stuName + "  " + sClass + "  " + tel);
			}   
			
//			file = new File(Environment.getExternalStorageDirectory().toString() + "/学生会/管理层.xls");
//			inStream = new FileInputStream(file);
			inStream = getAssets().open("managers.xls");
			book = Workbook.getWorkbook(inStream);
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();
			for(int r = 2; r < rows; r ++) {
				Cell cell_1 = sheet.getCell(0, r);
				String group = cell_1.getContents();
				Group g = groups.get(group);
				
				Cell cell_2 = sheet.getCell(2, r);
				String name = cell_2.getContents();
				Student stu = new Student(1000 + r, name);
				
				Cell cell_3 = sheet.getCell(4, r);
				String tClass = cell_3.getContents();
				TheClass theClass = classes_h.get(tClass);
				if(theClass == null) {
					theClass = new TheClass(tClass);
					readScheme(theClass, 2);
					classes.put(tClass, theClass);
				}
				
				Cell cell_4 = sheet.getCell(6, r);
				String tel = cell_4.getContents();
				stu.setTel(tel);
				stu.setTheClass(theClass);
				theClass.addStu(name, stu);
				if(g != null) {
					stu.setGroup(g);
					g.addManager(tel, stu);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		union.setGroups(groups);
		union.setClasses_1(classes);
		union.setClasses_2(classes_h);
		
		
		
	}
	
	public void readScheme(TheClass tClass, int level) {
		if(level == 1) {
			String className = tClass.getId();
			Workbook book = null;
			Lession[][] lessions = tClass.getLession();
//			File file = new File(Environment.getExternalStorageDirectory().toString() + "/学生会/大一/" + className + ".xls");
			try {
//				InputStream in = new FileInputStream(file);
				InputStream in = getAssets().open("freshmen/" + className + ".xls");
				book = Workbook.getWorkbook(in);
				Sheet sheet = book.getSheet(0);
				int maxC = sheet.getColumns();
				int maxR = sheet.getRows();
				
				for(int i = 0; i < maxC; i ++) {
					for(int j = 0; j < maxR; j ++) {
						Cell cell = sheet.getCell(i, j);
						String content = cell.getContents().trim();
						if((content != null) && (!content.equals(""))) {
							parseString(content, lessions[i][j]);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String className = tClass.getId();
			Workbook book = null;
			Lession[][] lessions = tClass.getLession();
//			File file = new File(Environment.getExternalStorageDirectory().toString() + "/学生会/大二/" + className + ".xls");
			try {
//				InputStream in = new FileInputStream(file);
				InputStream in = getAssets().open("sophomore/" + className + ".xls");
				book = Workbook.getWorkbook(in);
				Sheet sheet = book.getSheet(0);
				int maxC = sheet.getColumns();
				int maxR = sheet.getRows();
				
				for(int i = 0; i < maxC; i ++) {
					for(int j = 0; j < maxR; j ++) {
						Cell cell = sheet.getCell(i, j);
						String content = cell.getContents().trim();
						if((content != null) && (!content.equals(""))) {
							parseString(content, lessions[i][j]);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void parseString(String content, Lession lession) {
		int index = content.indexOf("/");
		String use = content;
		if(index > 0) {
			use = content.substring(0, index);
//		String elem2 = info.substring(index + 1, info.length());
//		parseString(day, time, elem2);
		}
		int index_0 = use.indexOf("》");
		System.out.println(use.substring(1, index_0));
		use = use.substring(index_0 + 1,use.length());
		int index_1 = use.indexOf(")");
		use = use.substring(index_1 + 1, use.length());
		int index_2 = use.indexOf("-");
		char type = use.charAt(use.length() - 2);
		String sMin = use.substring(0, index_2);
		String sMax = "";
		switch(type) {
		case '单':
			sMax = use.substring(index_2 + 1, use.length()-2);
			lession.setWeekType(1);
			break;
		case '双':
			sMax = use.substring(index_2 + 1, use.length()-2);
			lession.setWeekType(2);
			break;
		default:
			sMax = use.substring(index_2 + 1, use.length()-1);
			lession.setWeekType(0);
		}
		
		int min = Integer.parseInt(sMin);
		int max = Integer.parseInt(sMax);
		
		lession.setMax_week(max);
		lession.setMin_week(min);
	}
	
	public static boolean isSdCardExist() {  
	    return Environment.getExternalStorageState().equals(  
	            Environment.MEDIA_MOUNTED);  
	}
	
	public static String getSdCardPath() {  
	    boolean exist = isSdCardExist();  
	    String sdpath = "";  
	    if (exist) {  
	        sdpath = Environment.getExternalStorageDirectory()  
	                .getAbsolutePath();  
	    } else {  
	        sdpath = "不适用";  
	    }  
	    return sdpath;  
	  
	}
	
	public static String getDefaultFilePath() {  
	    String filepath = "";  
	    File file = new File(Environment.getExternalStorageDirectory(),  
	            "学生会.xls");  
	    if (file.exists()) {  
	        filepath = file.getAbsolutePath();  
	    } else {  
	        filepath = "不适用";  
	    }  
	    return filepath;  
	}

}

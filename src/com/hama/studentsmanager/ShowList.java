package com.hama.studentsmanager;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.studentsmanager.R;
import com.example.studentsmanager.R.layout;
import com.example.studentsmanager.R.menu;
import com.hama.VO.Group;
import com.hama.VO.Student;
import com.hama.VO.Union;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ShowList extends Activity {

	private int level = 0;
	private Union union = null;
	private int day = 0;
	private int lession = 0;
	private int week = 0;
	
//	private TextView freeStudent_0;
	private TextView freeStudent_1;
	private TextView freeStudent_2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_list_2);
		Intent intent = this.getIntent();
		level = intent.getIntExtra("level", 0);
		union = (Union) intent.getSerializableExtra("union");
		day = intent.getIntExtra("d", 0) - 1;
		lession = intent.getIntExtra("l", 0) - 1;
		week = intent.getIntExtra("week", 12);
		
		System.out.println("周" + day + "第" + lession + "节课");
		
//		freeStudent_0 = (TextView) this.findViewById(R.id.content_0);
		freeStudent_1 = (TextView) this.findViewById(R.id.content_1);
		freeStudent_2 = (TextView) this.findViewById(R.id.content_2);
		listFree();
	}
	
	public void listFree() {
//		String content_0 = "";
//		if(level < 2) {
//			content_0 = "无权限查看";
//		} else {
//			Map<String, Student> student_0 = union.getManagers();
//			Collection<Student> collection = student_0.values();
//			Iterator<Student> it_0 = collection.iterator();
//			while(it_0.hasNext()) {
//				Student stu = it_0.next();
//				if(stu.isFree(day, lession,12)) {
//					content_0 = content_0.concat( stu.getName() + " ");
//				}
//			}			
//		}
		Map<String, Group> groups = union.getGroups();
		Collection<Group> groupp = groups.values();
		Iterator<Group> it_1 = groupp.iterator();
		String content_1 = "";
		String content_2 = "";
		while(it_1.hasNext()) {
			Group group = it_1.next();
			content_1 = content_1.concat(group.getName() + " : \n   ");
			content_2 = content_2.concat(group.getName() + " : \n   ");
			if(level < 1) {
				content_1 = "无权限查看";
			}else{
				Iterator<Student> it_1_0 = group.getManagers().values().iterator();
				while(it_1_0.hasNext()) {
					Student stu = it_1_0.next();
					if(stu.isFree(day, lession,week)) {
						content_1 = content_1.concat(stu.getName() + " ");
					}
				}
				content_1 = content_1.concat("\n");
				
			}
			Iterator<Student> it_2 = group.getMate().values().iterator();
			while(it_2.hasNext()) {
				Student stu = it_2.next();
				if(stu.isFree(day, lession,12)) content_2 = content_2.concat(stu.getName() + " "); 
			}
			content_2 = content_2.concat("\n");
		}
//		freeStudent_0.setText(content_0);
		freeStudent_1.setText(content_1);
		freeStudent_2.setText(content_2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_list, menu);
		return true;
	}

}

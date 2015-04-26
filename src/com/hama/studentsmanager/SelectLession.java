package com.hama.studentsmanager;

import com.example.studentsmanager.R;
import com.example.studentsmanager.R.layout;
import com.example.studentsmanager.R.menu;
import com.hama.VO.Union;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectLession extends Activity implements OnClickListener {
	
	private Button t1_t1 = null;
	private Button t1_t2 = null;
	private Button t1_t3 = null;
	private Button t1_t4 = null;
	private Button t1_t5 = null;
	private Button t2_t1 = null;
	private Button t2_t2 = null;
	private Button t2_t3 = null;
	private Button t2_t4 = null;
	private Button t2_t5 = null;
	private Button t3_t1 = null;
	private Button t3_t2 = null;
	private Button t3_t3 = null;
	private Button t3_t4 = null;
	private Button t3_t5 = null;
	private Button t4_t1 = null;
	private Button t4_t2 = null;
	private Button t4_t3 = null;
	private Button t4_t4 = null;
	private Button t4_t5 = null;
	private Button t5_t1 = null;
	private Button t5_t2 = null;
	private Button t5_t3 = null;
	private Button t5_t4 = null;
	private Button t5_t5 = null;
	private Button t6_t1 = null;
	private Button t6_t2 = null;
	private Button t6_t3 = null;
	private Button t6_t4 = null;
	private Button t6_t5 = null;
	private Button t7_t1 = null;
	private Button t7_t2 = null;
	private Button t7_t3 = null;
	private Button t7_t4 = null;
	private Button t7_t5 = null;
	
	private int level = 0;
	private Union union = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lession_table_2);
		level =  this.getIntent().getIntExtra("level", 0);
		union = (Union) this.getIntent().getSerializableExtra("union");
		initView();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_lession, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(SelectLession.this, ShowList.class);
		intent.putExtra("level", level);
		intent.putExtra("union", union);
		
		EditText weekIn =(EditText)this.findViewById(R.id.weekIn);
		String sWeek =  weekIn.getText().toString();
		
		
		if((sWeek != null)&&(!sWeek.equals(""))) {
			int week = Integer.parseInt(sWeek);
			intent.putExtra("week", week);
			
			if(arg0 == t1_t1) {
				intent.putExtra("d", 1);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t1_t2) {
				intent.putExtra("d", 1);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t1_t3) {
				intent.putExtra("d", 1);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t1_t4) {
				intent.putExtra("d", 1);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t1_t5) {
				intent.putExtra("d", 1);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t2_t1) {
				intent.putExtra("d", 2);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t2_t2) {
				intent.putExtra("d", 2);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t2_t3) {
				intent.putExtra("d", 2);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t2_t4) {
				intent.putExtra("d", 2);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t2_t5) {
				intent.putExtra("d", 2);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t3_t1) {
				intent.putExtra("d", 3);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t3_t2) {
				intent.putExtra("d", 3);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t3_t3) {
				intent.putExtra("d", 3);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t3_t4) {
				intent.putExtra("d", 3);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t3_t5) {
				intent.putExtra("d", 3);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t4_t1) {
				intent.putExtra("d", 4);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t4_t2) {
				intent.putExtra("d", 4);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t4_t3) {
				intent.putExtra("d", 4);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t4_t4) {
				intent.putExtra("d", 4);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t4_t5) {
				intent.putExtra("d", 4);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t5_t1) {
				intent.putExtra("d", 5);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t5_t2) {
				intent.putExtra("d", 5);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t5_t3) {
				intent.putExtra("d", 5);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t5_t4) {
				intent.putExtra("d", 5);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t5_t5) {
				intent.putExtra("d", 5);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t6_t1) {
				intent.putExtra("d", 6);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t6_t2) {
				intent.putExtra("d", 6);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t6_t3) {
				intent.putExtra("d", 6);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t6_t4) {
				intent.putExtra("d", 6);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t6_t5) {
				intent.putExtra("d", 6);
				intent.putExtra("l", 5);
				startActivity(intent);
			}else if(arg0 == t7_t1) {
				intent.putExtra("d", 7);
				intent.putExtra("l", 1);
				startActivity(intent);
			}else if(arg0 == t7_t2) {
				intent.putExtra("d", 7);
				intent.putExtra("l", 2);
				startActivity(intent);
			}else if(arg0 == t7_t3) {
				intent.putExtra("d", 7);
				intent.putExtra("l", 3);
				startActivity(intent);
			}else if(arg0 == t7_t4) {
				intent.putExtra("d", 7);
				intent.putExtra("l", 4);
				startActivity(intent);
			}else if(arg0 == t7_t5) {
				intent.putExtra("d", 7);
				intent.putExtra("l", 5);
				startActivity(intent);
			}
		} else {
			Toast.makeText(this, "«Î ‰»Î÷‹ ˝", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void initView() {
		t1_t1 = (Button) findViewById(R.id.t1_lession_1);
		t1_t1.setOnClickListener(this);
		t1_t2 = (Button) findViewById(R.id.t1_lession_2);
		t1_t2.setOnClickListener(this);
		t1_t3 = (Button) findViewById(R.id.t1_lession_3);
		t1_t3.setOnClickListener(this);
		t1_t4 = (Button) findViewById(R.id.t1_lession_4);
		t1_t4.setOnClickListener(this);
		t1_t5 = (Button) findViewById(R.id.t1_lession_5);
		t1_t5.setOnClickListener(this);
		
		t2_t1 = (Button) findViewById(R.id.t2_lession_1);
		t2_t1.setOnClickListener(this);
		t2_t2 = (Button) findViewById(R.id.t2_lession_2);
		t2_t2.setOnClickListener(this);
		t2_t3 = (Button) findViewById(R.id.t2_lession_3);
		t2_t3.setOnClickListener(this);
		t2_t4 = (Button) findViewById(R.id.t2_lession_4);
		t2_t4.setOnClickListener(this);
		t2_t5 = (Button) findViewById(R.id.t2_lession_5);
		t2_t5.setOnClickListener(this);
		
		t3_t1 = (Button) findViewById(R.id.t3_lession_1);
		t3_t1.setOnClickListener(this);
		t3_t2 = (Button) findViewById(R.id.t3_lession_2);
		t3_t2.setOnClickListener(this);
		t3_t3 = (Button) findViewById(R.id.t3_lession_3);
		t3_t3.setOnClickListener(this);
		t3_t4 = (Button) findViewById(R.id.t3_lession_4);
		t3_t4.setOnClickListener(this);
		t3_t5 = (Button) findViewById(R.id.t3_lession_5);
		t3_t5.setOnClickListener(this);
		
		t4_t1 = (Button) findViewById(R.id.t4_lession_1);
		t4_t1.setOnClickListener(this);
		t4_t2 = (Button) findViewById(R.id.t4_lession_2);
		t4_t2.setOnClickListener(this);
		t4_t3 = (Button) findViewById(R.id.t4_lession_3);
		t4_t3.setOnClickListener(this);
		t4_t4 = (Button) findViewById(R.id.t4_lession_4);
		t4_t4.setOnClickListener(this);
		t4_t5 = (Button) findViewById(R.id.t4_lession_5);
		t4_t5.setOnClickListener(this);
		
		t5_t1 = (Button) findViewById(R.id.t5_lession_1);
		t5_t1.setOnClickListener(this);
		t5_t2 = (Button) findViewById(R.id.t5_lession_2);
		t5_t2.setOnClickListener(this);
		t5_t3 = (Button) findViewById(R.id.t5_lession_3);
		t5_t3.setOnClickListener(this);
		t5_t4 = (Button) findViewById(R.id.t5_lession_4);
		t5_t4.setOnClickListener(this);
		t5_t5 = (Button) findViewById(R.id.t5_lession_5);
		t5_t5.setOnClickListener(this);
		
		t6_t1 = (Button) findViewById(R.id.t6_lession_1);
		t6_t1.setOnClickListener(this);
		t6_t2 = (Button) findViewById(R.id.t6_lession_2);
		t6_t2.setOnClickListener(this);
		t6_t3 = (Button) findViewById(R.id.t6_lession_3);
		t6_t3.setOnClickListener(this);
		t6_t4 = (Button) findViewById(R.id.t6_lession_4);
		t6_t4.setOnClickListener(this);
		t6_t5 = (Button) findViewById(R.id.t6_lession_5);
		t6_t5.setOnClickListener(this);
		
		t7_t1 = (Button) findViewById(R.id.t7_lession_1);
		t7_t1.setOnClickListener(this);
		t7_t2 = (Button) findViewById(R.id.t7_lession_2);
		t7_t2.setOnClickListener(this);
		t7_t3 = (Button) findViewById(R.id.t7_lession_3);
		t7_t3.setOnClickListener(this);
		t7_t4 = (Button) findViewById(R.id.t7_lession_4);
		t7_t4.setOnClickListener(this);
		t7_t5 = (Button) findViewById(R.id.t7_lession_5);
		t7_t5.setOnClickListener(this);
	}
}

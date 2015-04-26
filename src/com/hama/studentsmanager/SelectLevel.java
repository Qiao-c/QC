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
import android.widget.TextView;

public class SelectLevel extends Activity {
	
	private TextView text = null;
	private Button button_2 = null;
	private Button button_1 = null;
	private Button button_0 = null;
	private Union union = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		union = (Union) this.getIntent().getSerializableExtra("union");
		text = (TextView) this.findViewById(R.id.alert_0);
		final Intent intent = new Intent(SelectLevel.this, SelectLession.class);
		intent.putExtra("union", union);
		button_2 = (Button) this.findViewById(R.id.level_2);
		button_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.putExtra("level", 2);
				startActivity(intent);
			}
		});
		button_1 = (Button) this.findViewById(R.id.level_1);
		button_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.putExtra("level", 1);
				startActivity(intent);
			}
		});
		button_0 = (Button) this.findViewById(R.id.level_0);
		button_0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.putExtra("level", 0);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_level, menu);
		return true;
	}

}

package com.example.passdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity02 extends Activity {
	private TextView tv_name;
	private TextView tv_password;
	private TextView tv_sex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		//获取Intent对象
		Intent intent =getIntent();
		//取出key对应的value值
		String name = intent.getStringExtra("name");
		String password = intent.getStringExtra("password");
		String sex = intent.getStringExtra("sex");
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_password = (TextView) findViewById(R.id.tv_password);
		tv_sex = (TextView) findViewById(R.id.tv_sex);
		
		tv_name.setText("用户名："+name);
		tv_password.setText("密   码："+password);
		tv_sex.setText("性   别："+sex);
		
	}
}

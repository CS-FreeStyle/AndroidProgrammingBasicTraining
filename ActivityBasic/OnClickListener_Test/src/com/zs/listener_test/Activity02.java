package com.zs.listener_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity02 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		Button button1 = (Button) findViewById(R.id.button1);
		//创建一个匿名内部类
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("Activity02","按钮1点击");
			}
		});
	}
}

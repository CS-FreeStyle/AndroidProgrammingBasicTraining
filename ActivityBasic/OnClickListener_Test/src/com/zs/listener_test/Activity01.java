package com.zs.listener_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity01 extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);

		// 按钮绑定接口
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	// 在重载方法中实现点击设置
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Log.i("MainActivity", "按钮1点击");
			break;
		case R.id.button2:
			Log.i("MainActivity", "按钮2点击");
			break;
		}
	}
}

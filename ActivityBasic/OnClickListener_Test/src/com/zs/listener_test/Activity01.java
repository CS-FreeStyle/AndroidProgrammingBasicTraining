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

		// ��ť�󶨽ӿ�
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	// �����ط�����ʵ�ֵ������
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Log.i("MainActivity", "��ť1���");
			break;
		case R.id.button2:
			Log.i("MainActivity", "��ť2���");
			break;
		}
	}
}

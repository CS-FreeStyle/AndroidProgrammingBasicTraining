package com.zs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity01 extends Activity {
	//��Activity������ʱ����õķ���
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		Log.i("Activity01","onCreate()");
	}
	//�����Activity����û��ɼ���ʱ����õķ���
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("Activity01","onStart()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("Activity01","onRestart()");
	}
	
	//��Activity��ȡ�������ʱ����õķ���
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Activity01","onResume()");
	}
	//Activityʧȥ�����ʱ����õķ���
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Activity01","onPause()");
	}
	
	//Activity�û����ɼ���ʱ����õķ���
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Activity01","onStop()");
	}
	
	//��Activity�����ٵ�ʱ����õķ���
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Activity01","onDestroy()");
	}
	
	//�����еİ�ť�ĵ���¼�
	public void click(View view){
		//����һ��Intent����ͨ���ö�������2��Activity
		Intent intent = new Intent(this,Activity02.class);
		startActivity(intent);
	}
}

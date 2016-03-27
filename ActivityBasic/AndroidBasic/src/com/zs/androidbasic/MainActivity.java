package com.zs.androidbasic;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	//��Ӧ���������¼�
	public boolean onKeyDown(int keyCode,KeyEvent event){
		Toast.makeText(this, "�������£�", 0).show();
		return super.onKeyDown(keyCode, event);
	}
	
	//��Ӧ�����ɿ�
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		Toast.makeText(this, "��������", 0).show();
		return super.onKeyUp(keyCode, event);
	}
	
	//��Ӧ��Ļ�����¼�
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();//��ȡ�������x����
		float y = event.getY();//��ȡ�������y����
		Toast.makeText(this, "�������Ϊ��"+x+":"+y+"��", 0).show();
		return super.onTouchEvent(event);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

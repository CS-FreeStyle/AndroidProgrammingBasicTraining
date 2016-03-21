package com.zs.phonecalltool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText editText1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取界面上的按钮
		Button btnDail =(Button) findViewById(R.id.button1);
		 editText1= (EditText) findViewById(R.id.editText1);
		//获取界面的文本输入框，将输入框中的号码提取出来
		//给按钮注册点击监听器
		btnDail.setOnClickListener(new MyListener());
	}
	private class MyListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String number = editText1.getText().toString();
			Intent myIntent = new Intent();
			myIntent.setAction(Intent.ACTION_DIAL);
			myIntent.setData(Uri.parse("tel://"+number));
			startActivity(myIntent);
		}
		
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

package com.example.passdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	
	private RadioButton manRadio;
	private RadioButton womanRadio;
	private EditText et_password;
	private Button btn_send;
	private EditText et_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		et_name = (EditText) findViewById(R.id.et_name);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_send = (Button) findViewById(R.id.btn_send);
		manRadio = (RadioButton) findViewById(R.id.radioMale);
		womanRadio = (RadioButton) findViewById(R.id.radioFemale);
		
		//点击提交用户信息按钮进行数据传递
		btn_send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				passData();
				
			}
		});
	}
	private void passData() {
		//创建Intent对象，启动Activity02
		Intent intent = new Intent(this,Activity02.class);
		//将数据存入Intent对象
		intent.putExtra("name", et_name.getText().toString().trim());
		intent.putExtra("password", et_password.getText().toString().trim());
		String str = "";
		if(manRadio.isChecked()){
			str ="男";
		}
		else if(womanRadio.isChecked()){
			str ="女";
		}
		intent.putExtra("sex", str);
		startActivity(intent);
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

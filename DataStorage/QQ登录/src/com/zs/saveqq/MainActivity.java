package com.zs.saveqq;

import java.util.HashMap;
import java.util.Map;

import com.zs.saveqq.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText etNumber;
	private EditText etPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		// ȡ������
		Map<String, String> userInfo = Utils.getUserInfo(this);
		if(userInfo !=null){
			//��ʾ�ڽ�����
			etNumber.setText(userInfo.get("number"));
			etPassword.setText(userInfo.get("password"));
		}
	}

	private void initView() {
		etNumber = (EditText) findViewById(R.id.et_number);
		etPassword = (EditText) findViewById(R.id.et_password);
		findViewById(R.id.btn_login).setOnClickListener(this);

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

	@Override
	public void onClick(View v) {
		//���������¼����ťʱ����ȡQQ���������
		String number = etNumber.getText().toString().trim();
		String password = etPassword.getText().toString().trim();
		//�������������Ƿ���ȷ
		if(TextUtils.isEmpty(number)){
			Toast.makeText(this, "������QQ����", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(password)){
			Toast.makeText(this, "����������", Toast.LENGTH_SHORT).show();
			return;
		}
		//��¼�ɹ�
		Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
		//�����ȷ���ж��Ƿ�ѡ�˼�ס����
		Log.i("MainActivity","��ס����:"+number+","+password);
		//�����û���Ϣ
		boolean isSaveSuccess = Utils.saveUserInfo(this, number, password);
		if(isSaveSuccess){
			Toast.makeText(this, "����ɹ�", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(this, "����ʧ��", Toast.LENGTH_SHORT).show();
		}

	}
}

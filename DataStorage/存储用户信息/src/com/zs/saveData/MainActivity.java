package com.zs.saveData;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText et_info;
	private Button btn_save;
	private Button btn_read;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 获取布局文件中的控件
		et_info = (EditText) findViewById(R.id.et_info);
		btn_save = (Button) findViewById(R.id.btn_save);
		btn_read = (Button) findViewById(R.id.btn_read);
		btn_save.setOnClickListener(new ButtonListener());
		btn_read.setOnClickListener(new ButtonListener());
	}

	// 定义Button按钮的点击事件
	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_save:
				String saveinfo = et_info.getText().toString().trim();
				FileOutputStream fos;
				try {
					// 保存数据
					fos = openFileOutput("data.txt", Context.MODE_APPEND);
					fos.write(saveinfo.getBytes());
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Toast.makeText(MainActivity.this, "数据保存成功", 0).show();
				break;

			case R.id.btn_read:
				String content = "";
				try {
					// 获取保存的数据
					FileInputStream fis = openFileInput("data.txt");
					byte[] buffer = new byte[fis.available()];
					fis.read(buffer);
					content = new String(buffer);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Toast.makeText(MainActivity.this, "保存的数据是：" + content, 0)
						.show();
				break;
			default:
				break;
			}
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

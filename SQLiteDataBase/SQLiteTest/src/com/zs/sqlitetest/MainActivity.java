package com.zs.sqlitetest;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private PersonSQLiteOpenHelper sqlCtrler;
	Button btnInsert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sqlCtrler = new PersonSQLiteOpenHelper(this);
		btnInsert = (Button) findViewById(R.id.btn_insert);
		btnInsert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sqlCtrler.add("zhangsan", "123");
			}
		});
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

	// ģ������ת�ˣ�SQLite����
	public void Trans() {
		// ��ȡһ����д��SQLiteDatabase����
		SQLiteDatabase db = sqlCtrler.getWritableDatabase();
		// ��ʼ���ݿ�����
		db.beginTransaction();
		try {
			// ִ��ת������
			db.execSQL("update person set account =account-1000 where name=?",
					new Object[] { "zhangsan" });
			// ִ��ת�����
			db.execSQL("update person set account =account+1000 where name=?",
					new Object[] { "wangwu" });
			//������ݿ�����ִ�гɹ�
			db.setTransactionSuccessful();
		} catch (Exception e) {
			Log.i("������ʧ�ܣ�", e.toString());
		} finally {
			db.endTransaction();// �ر�����
			db.close();// �ر����ݿ�
		}
	}
}

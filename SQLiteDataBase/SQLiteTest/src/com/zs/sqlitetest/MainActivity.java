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

	// 模拟银行转账（SQLite事务）
	public void Trans() {
		// 获取一个可写的SQLiteDatabase对象
		SQLiteDatabase db = sqlCtrler.getWritableDatabase();
		// 开始数据库事务
		db.beginTransaction();
		try {
			// 执行转出操作
			db.execSQL("update person set account =account-1000 where name=?",
					new Object[] { "zhangsan" });
			// 执行转入操作
			db.execSQL("update person set account =account+1000 where name=?",
					new Object[] { "wangwu" });
			//标记数据库事务执行成功
			db.setTransactionSuccessful();
		} catch (Exception e) {
			Log.i("事务处理失败！", e.toString());
		} finally {
			db.endTransaction();// 关闭事务
			db.close();// 关闭数据库
		}
	}
}

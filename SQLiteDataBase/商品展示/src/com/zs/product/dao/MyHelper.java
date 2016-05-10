package com.zs.product.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//�������ݿ����
public class MyHelper extends SQLiteOpenHelper {

	// ���ڸ���û���޲������캯���������������ָ�����ø����ĸ��в����Ĺ��캯��
	public MyHelper(Context context) {
		super(context, "product.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("MainActivity", "onCreate");
		db.execSQL("CREATE TABLE account(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),balance INTEGER)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("MainActivity","onUpgrade");

	}

}

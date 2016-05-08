package com.zs.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Helpers;

public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {
	private PersonSQLiteOpenHelper helper;
	public PersonSQLiteOpenHelper(Context context) {
		super(context,"person.db",null,5);
	}

	@Override
	//���ݿ��һ�α�������ʱ����ø÷���
	public void onCreate(SQLiteDatabase db) {
		//��ʼ�����ݿ�ı�ṹ��ִ��һ�������SQL���
		db.execSQL("create table person(id integer primary key autoincrement,"+"name varchar(20),"+"number varchar(20))");

	}

	@Override
	//�����ݿ�İ汾������ʱ����
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("alter table person add account varchar(20)");

	}
	
	//����һ������
	public long add(String name,String number){
		//�õ�һ���ɶ�д��SQLiteDatabase����
		SQLiteDatabase db = helper.getWritableDatabase();
		//��������������ӵ�ContentValues��������
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("number", number);
		//����һ�����ݵ�person������
		long id = db.insert("person", null, values);
		//���������ķ���������ʹ��
//		db.execSQL("insert into person(name,number) values(?,?)",new Object[]{name,number});
		//�ر����ݿ�
		db.close();
		return id;
	}
	
	//�޸�һ������
	public int update(String name,String newnumber){
		//��ȡһ���ɶ�д��SQLiteDatabase����
		SQLiteDatabase db = helper.getWritableDatabase();
		//����һ��ContentValues����
		ContentValues values = new ContentValues();
		//��������key,value����ʽ��ӽ�ȥ
		values.put("number", newnumber);
		//ִ���޸ĵķ���
		int number = db.update("person", values, "name=?", new String[]{name});
		//�ر����ݿ�
		db.close();
		return number;
	}
	
	//ɾ��һ������
	public int delete(String name){
		//��ȡһ����д��SQLiteDatabase����
		SQLiteDatabase db = helper.getWritableDatabase();
		//ɾ������
		int number = db.delete("person", "name=?", new String[]{name});
		//�ر����ݿ�
		db.close();
		return number;
	}
	
	//��ѯһ������
	public boolean find(String name){
		//��ȡһ���ɶ������ݿ�
		SQLiteDatabase db = helper.getWritableDatabase();
		//��ѯ���ݿ�Ĳ���  ����1������������2����ѯ������������3����ѯ����
		//����4����ѯ����ֵ������5����������������6��having����������7������ʽ
		Cursor cursor =db.query("person", null, "name=?", new String[]{name}, null, null, null);
		
		/*
		 rawQuery������ִ�в�ѯ��SQL���
		 Cursor cursor = db.rawQuery("select * from person where name=?",new String[]{name});
		 */
		//�Ƿ�����һ����ֵ
		boolean result = cursor.moveToNext();
		//�ر��α�
		cursor.close();
		//�ر����ݿ�
		db.close();
		return result;
	}

}

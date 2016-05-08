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
	//数据库第一次被创建的时候调用该方法
	public void onCreate(SQLiteDatabase db) {
		//初始化数据库的表结构，执行一条建表的SQL语句
		db.execSQL("create table person(id integer primary key autoincrement,"+"name varchar(20),"+"number varchar(20))");

	}

	@Override
	//当数据库的版本号增加时调用
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("alter table person add account varchar(20)");

	}
	
	//增加一条数据
	public long add(String name,String number){
		//拿到一个可读写的SQLiteDatabase对象
		SQLiteDatabase db = helper.getWritableDatabase();
		//将参数名和列添加到ContentValues对象里面
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("number", number);
		//插入一条数据到person表里面
		long id = db.insert("person", null, values);
		//除了上述的方法还可以使用
//		db.execSQL("insert into person(name,number) values(?,?)",new Object[]{name,number});
		//关闭数据库
		db.close();
		return id;
	}
	
	//修改一条数据
	public int update(String name,String newnumber){
		//获取一个可读写的SQLiteDatabase对象
		SQLiteDatabase db = helper.getWritableDatabase();
		//创建一个ContentValues对象
		ContentValues values = new ContentValues();
		//将参数以key,value的形式添加进去
		values.put("number", newnumber);
		//执行修改的方法
		int number = db.update("person", values, "name=?", new String[]{name});
		//关闭数据库
		db.close();
		return number;
	}
	
	//删除一条数据
	public int delete(String name){
		//获取一个可写的SQLiteDatabase对象
		SQLiteDatabase db = helper.getWritableDatabase();
		//删除数据
		int number = db.delete("person", "name=?", new String[]{name});
		//关闭数据库
		db.close();
		return number;
	}
	
	//查询一条数据
	public boolean find(String name){
		//获取一个可读的数据库
		SQLiteDatabase db = helper.getWritableDatabase();
		//查询数据库的操作  参数1：表名，参数2：查询的列名，参数3：查询条件
		//参数4：查询参数值，参数5：分组条件，参数6：having条件，参数7：排序方式
		Cursor cursor =db.query("person", null, "name=?", new String[]{name}, null, null, null);
		
		/*
		 rawQuery方法，执行查询的SQL语句
		 Cursor cursor = db.rawQuery("select * from person where name=?",new String[]{name});
		 */
		//是否有下一条数值
		boolean result = cursor.moveToNext();
		//关闭游标
		cursor.close();
		//关闭数据库
		db.close();
		return result;
	}

}

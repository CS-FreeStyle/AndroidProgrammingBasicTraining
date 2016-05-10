package com.zs.product.dao;

import java.util.ArrayList;
import java.util.List;

import com.zs.product.bean.Account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//数据库逻辑操作类
public class AccountDao {
	private MyHelper helper;

	public AccountDao(Context context) {
		// 创建Dao时，创建Helper
		helper = new MyHelper(context);
	}

	// 插入数据
	public void insert(Account account) {
		// 获取数据库对象
		SQLiteDatabase db = helper.getWritableDatabase();
		// 用来装载要插入的数据的Map<列名，列的值>
		ContentValues values = new ContentValues();
		values.put("name", account.getName());
		values.put("balance", account.getBalance());
		// 向account表中插入数据values
		Long id = db.insert("account", null, values);
		account.setId(id);// 得到id
		db.close(); // 关闭数据库
	}

	// 根据id删除数据
	public int delete(long id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// 按条件删除指定表中的数据，返回受影响的行数
		int count = db.delete("account", "_id=?", new String[] { id + "" });
		db.close();
		return count;
	}
	
	//更新数据
	public int update(Account account){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();//要修改的数据
		values.put("name", account.getName());
		values.put("balance", account.getBalance());
		int count = db.update("account", values, "_id=?", new String []{account.getId()+""});//更新并得到行数
		db.close();
		return count;
	}
	
	//查询所有的数据倒序排列
	public List<Account> queryAll(){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("account", null, null, null, null, null, "balance DESC");
		List<Account> list = new ArrayList<Account>();
		while(c.moveToNext()){
			//可以根据列名获取索引值
			long id = c.getLong(c.getColumnIndex("_id"));
			String name=c.getString(1);
			int balance=c.getInt(2);
			list.add(new Account(id,name,balance));
		}
		c.close();
		db.close();
		return list;
	}

}

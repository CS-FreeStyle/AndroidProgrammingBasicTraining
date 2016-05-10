package com.zs.product.dao;

import java.util.ArrayList;
import java.util.List;

import com.zs.product.bean.Account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//���ݿ��߼�������
public class AccountDao {
	private MyHelper helper;

	public AccountDao(Context context) {
		// ����Daoʱ������Helper
		helper = new MyHelper(context);
	}

	// ��������
	public void insert(Account account) {
		// ��ȡ���ݿ����
		SQLiteDatabase db = helper.getWritableDatabase();
		// ����װ��Ҫ��������ݵ�Map<�������е�ֵ>
		ContentValues values = new ContentValues();
		values.put("name", account.getName());
		values.put("balance", account.getBalance());
		// ��account���в�������values
		Long id = db.insert("account", null, values);
		account.setId(id);// �õ�id
		db.close(); // �ر����ݿ�
	}

	// ����idɾ������
	public int delete(long id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// ������ɾ��ָ�����е����ݣ�������Ӱ�������
		int count = db.delete("account", "_id=?", new String[] { id + "" });
		db.close();
		return count;
	}
	
	//��������
	public int update(Account account){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();//Ҫ�޸ĵ�����
		values.put("name", account.getName());
		values.put("balance", account.getBalance());
		int count = db.update("account", values, "_id=?", new String []{account.getId()+""});//���²��õ�����
		db.close();
		return count;
	}
	
	//��ѯ���е����ݵ�������
	public List<Account> queryAll(){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("account", null, null, null, null, null, "balance DESC");
		List<Account> list = new ArrayList<Account>();
		while(c.moveToNext()){
			//���Ը���������ȡ����ֵ
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

package com.zs.product;

import java.util.List;

import com.zs.product.bean.Account;
import com.zs.product.dao.AccountDao;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// ��Ҫ��������ݼ���
	private List<Account> list;
	// ���ݿ���ɾ�Ĳ������
	private AccountDao dao;
	// �������Ƶ�EditText
	private EditText nameET;
	// �������EditText
	private EditText balanceET;
	// ������
	private MyAdapter adapter;
	// ListView
	private ListView accountLV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ��ʼ���ؼ�
		initView();
		dao = new AccountDao(this);
		// �����ݿ��ѯ����������
		list = dao.queryAll();
		adapter = new MyAdapter();
		// ΪListView������������Զ�������������Ŀ��
		accountLV.setAdapter(adapter);
	}

	private void initView() {
		accountLV = (ListView) findViewById(R.id.accountLV);
		nameET = (EditText) findViewById(R.id.nameET);
		balanceET = (EditText) findViewById(R.id.balanceET);
		// ��Ӽ�������������Ŀ����¼�
		accountLV.setOnItemClickListener(new MyOnItemClickListener());

	}

	public void add(View v) {
		String name = nameET.getText().toString().trim();
		String balance = balanceET.getText().toString().trim();
		// ��Ŀ����balance.equals("")�����0
		// ���balance���ǿ��ַ������������ת��
		Account a = new Account(name, balance.equals("") ? 0
				: Integer.parseInt(balance));
		dao.insert(a);// �������ݿ�
		list.add(a);// ���뼯��
		adapter.notifyDataSetChanged();// ˢ�½���
		// ѡ�����һ��
		accountLV.setSelection(accountLV.getCount() - 1);
		nameET.setText("");
		balanceET.setText("");
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

	// �Զ���һ����������������װ�ص�ListView�Ĺ��ߣ�
	private class MyAdapter extends BaseAdapter {
		// ��ȡ��Ŀ����
		public int getCount() {
			return list.size();
		}

		// ����λ�û�ȡ����
		public Object getItem(int position) {
			return list.get(position);
		}

		// ����λ�û�ȡid
		public long getItemId(int position) {
			return position;
		}

		// ��ȡһ����Ŀ��ͼ
		public View getView(int position, View convertView, ViewGroup parent) {
			System.out.println("11111111111111111");
			// ����convertView
			View item = convertView != null ? convertView : View.inflate(
					getApplicationContext(), R.layout.item, null);
			// ��ȡ����ͼ�е�TextView
			TextView idTV = (TextView) item.findViewById(R.id.idTV);
			TextView nameTV = (TextView) item.findViewById(R.id.nameTV);
			TextView balanceTV = (TextView) item.findViewById(R.id.balanceTV);
			// ���ݵ�ǰλ�û�ȡAccount����
			final Account a = list.get(position);
			// ��Account�����е����ݷŵ�TextView��
			idTV.setText(a.getId() + "");
			nameTV.setText(a.getName());
			balanceTV.setText(a.getBalance() + "");
			ImageView upIV = (ImageView) item.findViewById(R.id.upIV);
			ImageView downIV = (ImageView) item.findViewById(R.id.downIV);
			ImageView deleteIV = (ImageView) item.findViewById(R.id.deleteIV);

			// ���ϼ�ͷ�ĵ���¼������ķ���
			upIV.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					a.setBalance(a.getBalance() + 1);// �޸�ֵ
					adapter.notifyDataSetChanged();// ˢ�½���
					dao.update(a);// �������ݿ�
				}
			});
			// ���¼�ͷ�ĵ���¼������ķ���
			downIV.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					a.setBalance(a.getBalance() - 1);
					adapter.notifyDataSetChanged();
					dao.update(a);

				}
			});

			// ɾ��ͼƬ�ĵ���¼���������
			deleteIV.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// ɾ������֮ǰ���ȵ���һ���Ի���
					android.content.DialogInterface.OnClickListener listener = new android.content.DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							list.remove(a);// �Ӽ�����ɾ��
							dao.delete(a.getId());// �����ݿ���ɾ��
							adapter.notifyDataSetChanged();// ˢ�½���
						}
					};
					// �����Ի���
					Builder bulider = new Builder(MainActivity.this);
					bulider.setTitle("ȷ��Ҫɾ����");// ���ñ���
					// ����ȷ����ť���ı��Լ�������
					bulider.setPositiveButton("ȷ��", listener);
					bulider.setNegativeButton("ȡ��", listener);
					bulider.show();
				}
			});
			return item;

		}
	}

	private class MyOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Account a = (Account) parent.getItemAtPosition(position);
			Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_SHORT).show();

		}
	}
}

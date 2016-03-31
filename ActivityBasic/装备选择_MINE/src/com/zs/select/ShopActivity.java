package com.zs.select;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ShopActivity extends Activity implements OnClickListener {
	
	private ItemInfo itemInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		itemInfo = new ItemInfo("��", 100, 20, 20);
		findViewById(R.id.r1).setOnClickListener(this);
		TextView mLifeTV = (TextView) findViewById(R.id.tv_life);
		TextView mNameTV = (TextView) findViewById(R.id.tv_name);
		TextView mSpeedTV = (TextView) findViewById(R.id.tv_speed);
		TextView mAttack = (TextView) findViewById(R.id.tv_attack);
		
		//Textview ��ʾ�ַ��������ﴫ��һ��intֵ�����벻�ᱨ�����лᱨ��
		mLifeTV.setText("����ֵ+"+itemInfo.getLife());
		mNameTV.setText(itemInfo.getName());
		mSpeedTV.setText("���ݶ�+"+itemInfo.getSpeed());
		mAttack.setText("������+"+itemInfo.getAttack());
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.r1:
			Intent intent = new Intent();
			intent.putExtra("equipment", itemInfo);
			Log.i("ShopActivity",itemInfo.toString());
			setResult(1, intent);
			finish();
			break;

		}
	}

}

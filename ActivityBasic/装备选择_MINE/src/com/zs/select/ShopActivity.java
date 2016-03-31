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
		itemInfo = new ItemInfo("金剑", 100, 20, 20);
		findViewById(R.id.r1).setOnClickListener(this);
		TextView mLifeTV = (TextView) findViewById(R.id.tv_life);
		TextView mNameTV = (TextView) findViewById(R.id.tv_name);
		TextView mSpeedTV = (TextView) findViewById(R.id.tv_speed);
		TextView mAttack = (TextView) findViewById(R.id.tv_attack);
		
		//Textview 显示字符串，这里传入一个int值，编译不会报错，运行会报错。
		mLifeTV.setText("生命值+"+itemInfo.getLife());
		mNameTV.setText(itemInfo.getName());
		mSpeedTV.setText("敏捷度+"+itemInfo.getSpeed());
		mAttack.setText("攻击力+"+itemInfo.getAttack());
		
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

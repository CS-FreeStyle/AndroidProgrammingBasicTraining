package com.zs.select;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ProgressBar mProgerssBar1;
	private ProgressBar mProgerssBar2;
	private ProgressBar mProgerssBar3;
	private TextView mLifeTV;
	private TextView mAttackTV;
	private TextView mSpeedTV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLifeTV = (TextView) findViewById(R.id.tv_life_progress);
		mAttackTV = (TextView) findViewById(R.id.tv_attack_progress);
		mSpeedTV = (TextView) findViewById(R.id.tv_speed_progress);
		initProgress();
	}
	//��ʼ��������
	private void initProgress() {
		mProgerssBar1 = (ProgressBar) findViewById(R.id.progressBar1);
		mProgerssBar2 = (ProgressBar) findViewById(R.id.progressBar2);
		mProgerssBar3 = (ProgressBar) findViewById(R.id.progressBar3);
		mProgerssBar1.setMax(1000); //�������ֵΪ1000
		mProgerssBar2.setMax(1000);
		mProgerssBar3.setMax(1000);
		
	}
	
	//�����µ�Activity���һ�ȡ���ķ���ֵ
	public void click(View view) {
		Intent intent = new Intent(this,ShopActivity.class);
		startActivityForResult(intent, 1);//������������������Ϊ1
	}
	public void click2(View view) {
		Intent intent = new Intent(this, ShopActivity.class);
		startActivityForResult(intent, 1);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(data !=null){
			//�жϽ�����Ƿ����1������1Ϊ�������װ��������2Ϊ�������װ��
			if(resultCode ==1){
				if(requestCode ==1){
					ItemInfo info =(ItemInfo) data.getSerializableExtra("equipment");
					//����ProgressBar��ֵ
					updateProgress(info);
				}
			}
		}
	}
	private void updateProgress(ItemInfo info) {
		int progress1 = mProgerssBar1.getProgress();
		int progress2 = mProgerssBar1.getProgress();
		int progress3 = mProgerssBar3.getProgress();
		
		mProgerssBar1.setProgress(progress1+info.getLife());
		mProgerssBar2.setProgress(progress2+info.getAttack());
		mProgerssBar3.setProgress(progress3+info.getSpeed());
		
		mLifeTV.setText(mProgerssBar1.getProgress()+" ");
		mAttackTV.setText(mProgerssBar2.getProgress()+" ");
		mSpeedTV.setText(mProgerssBar3.getProgress()+" ");
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
}

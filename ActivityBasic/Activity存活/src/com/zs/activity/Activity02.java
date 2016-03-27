package com.zs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Activity02 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity02);
		Log.i("Activity02","onCreate()");
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.i("Activity02","onStart()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("Activity02","onRestart()");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Activity02","onResume()");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Activity02","onPause()");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Activity02","onStop()");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Activity02","onDestory()");
	}
}

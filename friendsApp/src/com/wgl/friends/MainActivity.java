package com.wgl.friends;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

import com.phonegap.DroidGap;

public class MainActivity extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/login.html");
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {// 捕捉返回键
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			ConfirmExit();// 按了返回键，但已经不能返回，则执行退出确认
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	public void ConfirmExit() {// 退出确认
		AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
		ad.setTitle("退出");
		ad.setMessage("是否退出软件?");
		ad.setPositiveButton("是", new DialogInterface.OnClickListener() {// 退出按钮
					@Override
					public void onClick(DialogInterface dialog, int i) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();// 关闭activity

					}
				});
		ad.setNegativeButton("否", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int i) {
				// 不退出不用执行任何操作
			}
		});
		ad.show();// 显示对话框
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
}
package com.example.testmarry;

import android.accounts.OnAccountsUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {
	private Button btnSysUI, toggleButton, btn_nextActivity,btn_Animationset,btn_otherActivity;
	private View viewToAnimate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSysUI = (Button) findViewById(R.id.buttonSysUI);
		toggleButton = (Button) findViewById(R.id.toggleButton);
		btn_nextActivity = (Button) findViewById(R.id.btn_nextActivity);
		btn_Animationset = (Button) findViewById(R.id.btn_Animationset);
		btn_otherActivity = (Button) findViewById(R.id.btn_otherActivity);
		viewToAnimate = findViewById(R.id.theView);
		btnSysUI.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int currentVis = v.getSystemUiVisibility();
				int newVis;
				if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
					newVis = View.SYSTEM_UI_FLAG_VISIBLE;
				} else {
					newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
				}
				v.setSystemUiVisibility(newVis);
			}
		});
		toggleButton.setOnClickListener(this);
		btn_nextActivity.setOnClickListener(this);
		btn_otherActivity.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_nextActivity:
			Intent intent = new Intent(this,AnimationActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_Animationset:
			Intent intent2 = new Intent(this,AnimationSetActivity.class);
			startActivity(intent2);
			break;
		case R.id.btn_otherActivity:
			Intent intent3 = new Intent(this,OtherActivity.class);
			startActivity(intent3);
			break;
		case R.id.toggleButton:
			if (viewToAnimate.getVisibility() == View.VISIBLE) {
				// �����ͼ�Ѿ��ǿɼ��ģ��ʹ��Ҳཫ�们��
				Animation out = AnimationUtils.makeOutAnimation(this, true);
				viewToAnimate.startAnimation(out);
				viewToAnimate.setVisibility(View.INVISIBLE);
			} else {
				// �����ͼ�����صģ���������
				Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
				viewToAnimate.startAnimation(in);
				viewToAnimate.setVisibility(View.VISIBLE);
			}
			/*if(viewToAnimate.getAlpha() > 0f) {
				//�����ͼ�Ѿ��ɼ���������Ҳ໬��
				viewToAnimate.animate().alpha(0f).translationX(1000f);
				} else {
				//�����ͼ�����صģ�ԭ����һ�����Զ���
				//Property Animation ��ʵ���޸���ͼ����˱������Ȼָ���ͼ��λ��
				viewToAnimate.setTranslationX(0f);
				viewToAnimate.animate().alpha(1f);
				}*/
			break;
		default:
			break;
		}
		
	}
}

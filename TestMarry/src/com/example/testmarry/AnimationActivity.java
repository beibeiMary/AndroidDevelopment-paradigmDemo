package com.example.testmarry;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class AnimationActivity extends Activity {
	boolean isa;
	ScaleAnimation shrink, grow;
	ImageView flipImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		flipImage = (ImageView) findViewById(R.id.flip_image);
		flipImage.setImageResource(R.drawable.a);
		isa = true;
		shrink = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		shrink.setDuration(150);
		shrink.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				if (isa) {
					isa = false;
					flipImage.setImageResource(R.drawable.b);
				} else {
					isa = true;
					flipImage.setImageResource(R.drawable.a);
				}
				flipImage.startAnimation(grow);
			}
		});
		grow = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		grow.setDuration(150);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			flipImage.startAnimation(shrink);
			return true;
		}
		return super.onTouchEvent(event);
	}

}

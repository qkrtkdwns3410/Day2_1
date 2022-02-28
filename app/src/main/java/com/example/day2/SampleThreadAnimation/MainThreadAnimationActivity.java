package com.example.day2.SampleThreadAnimation;

import java.util.ArrayList;

import com.example.day2.R;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainThreadAnimationActivity extends AppCompatActivity {
	  ImageView imageView;
	  
	  ArrayList<Drawable> drawableList = new ArrayList<>();
	  Handler handler = new Handler();
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_thread_animation);
			
			Resources res = getResources();
			drawableList.add(res.getDrawable(R.drawable.face1));
			drawableList.add(res.getDrawable(R.drawable.face2));
			drawableList.add(res.getDrawable(R.drawable.face3));
			drawableList.add(res.getDrawable(R.drawable.face4));
			drawableList.add(res.getDrawable(R.drawable.face5));
			
			imageView = findViewById(R.id.imageView);
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						AnimThread thread = new AnimThread();
						thread.start();
						
				  }
			});
	  }
	  
	  class AnimThread extends Thread {
			@Override
			public void run() {
				  int index = 0;
				  for (int i = 0; i < 100; i += 1) {
						final Drawable drawable = drawableList.get(index);
						index += 1;
						if (index > 4) {
							  index = 0;
						}
						//화면에 이미지를 보여주기 위해 핸들러의 post() 메서드 호출하기
						handler.post(new Runnable() {
							  @Override
							  public void run() {
									imageView.setImageDrawable(drawable);
									
							  }
						});
						
						try {
							  Thread.sleep(1000);
						} catch (Exception e) {
							  e.printStackTrace();
						}
				  }
			}
	  }
}










































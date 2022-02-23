package com.example.day2.SampleTweenAnimation;

import com.example.day2.R;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_anim);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						//AnimationUtils 클래스의 loadAnimation() 메서드  >> XML 리소스에 정의된 애니메이션 액션 정보 로딩합니다.
						Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
						
						view.startAnimation(anim);
				  }
			});
	  }
}
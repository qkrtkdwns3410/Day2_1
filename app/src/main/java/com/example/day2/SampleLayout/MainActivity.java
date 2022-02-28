package com.example.day2.SampleLayout;

import com.example.day2.R;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sample_view);
		 
			Layout1 layout1 = findViewById(R.id.layout1); //XML 레이아웃에 추가한 뷰를 참조합니다.
		 
			//뷰의 메서드를 호출하여 데이터를 설정합니다.
			layout1.setImage(R.drawable.ic_launcher_foreground);
			layout1.setName("김민수");
			layout1.setMoblie("010-0000-0000");
		 
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						layout1.setImage(R.drawable.profile1);
				  }
			});
		 
			Button button2 = findViewById(R.id.button2);
			button2.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						layout1.setImage(R.drawable.profile2);
				  }
			});
	  }
}












































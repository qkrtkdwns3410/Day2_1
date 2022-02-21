package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	  public static final int REQUEST_CODE_MENU = 101;
	  public static final String KEY_SIMPLE_DATA = "data";

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sample_intent);

			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
						SimpleData data = new SimpleData(100, "Hello Android!"); // SImpleDATA 객체의 생성
						intent.putExtra(KEY_SIMPLE_DATA, data); //인텐트에 부가 데이터 전송
						startActivityForResult(intent, REQUEST_CODE_MENU);
						
						
				  }
			});
	  }
}
package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SampleParcelable extends AppCompatActivity {
	public static final int REQUEST_CODE_MENU = 101;
	public static final String KEY_SIMPLE_DATA = "data";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_parcelable);

		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
				SimpleData data = new SimpleData(100, "Hello Android!"); //SimpleData 객체의 생성
				// 정수는 100 문자열은 Hello Android 데이터가 Parcel 객체로 생성됨
				intent.putExtra(KEY_SIMPLE_DATA, data); //인텐트에 부가 데이터로 넣기
				// 인텐트 객체의 putExtra >> SimpleData 객체를 부가 데이터로 추가 >> SimpleData 객체는 메뉴 액티비티에서 꺼내어 사용
				startActivityForResult(intent, REQUEST_CODE_MENU);
			}
		});
	}
}
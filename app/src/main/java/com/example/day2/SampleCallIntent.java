package com.example.day2;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SampleCallIntent extends AppCompatActivity {
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_call_intent);

		editText = findViewById(R.id.editText);

		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String data = editText.getText().toString(); //입력 상자에 입력된 전화번호 확인

				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
				//전화 걸기 화면을 보여줄 인텐트 객체의 생성

				startActivity(intent);
				//액티비티 띄우기
			}
		});

		Button button2 = findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				ComponentName name = new ComponentName("com.example.day2", "com.example.day2.MenuActivity");
				intent.setComponent(name); // 인텐트 객체에 컴포넌트의 지정
				startActivityForResult(intent, 101); // 액티비티 띄우기
			}

		});
	}
}
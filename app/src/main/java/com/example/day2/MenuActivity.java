package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

	  TextView textView;
	  public static final String KEY_SIMPLE_DATA = "data";
	  //번들 객체에 데이터를 저장하기 위한 키는 메인 액티비티와 다른 액티비티 모두 KEY_SIMPLE_DATA라는 같은 이름의 상수로 정의되어 있음.

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sample_parcelable);

			textView = findViewById(R.id.textView);
			Button button = findViewById(R.id.button);

			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						Intent intent = new Intent();
						intent.putExtra("name", "mike");
						setResult(RESULT_OK, intent);

						finish();

				  }
			});

			//메인 엑티비티로 부터 전달받은 인텐트 객체를 참조하기 위해.. onCreate()메서드 안에서 getIntent()메서드를 호출하였습니다.
			//getIntent() 메서드를 호출하면 인텐트 객체가 반환되므로 >> 해다 객체 안의 번들 객체를 참조가능합니다
			//getExtras 호출... > Bundle 자료형의 객체 반환
			//
			Intent intent = getIntent();
			processIntent(intent);

	  }

	  private void processIntent(Intent intent) {
			if (intent != null) {
				  Bundle bundle = intent.getExtras();
				  SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
				  //Parcelable 인터페이스 >> 객체를 정의해서 데이터를 전달가능함 >> 코드가 단순 , 재사용성이 높아집니다.
				  if (intent != null) {
						textView.setText("전달 받은 데이터\nNumber : " + data.number + "\nMessage : " + data.message);

				  }
			}
	  }
}






























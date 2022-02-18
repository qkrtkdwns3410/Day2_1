package com.example.day2.SampleReceiver;

import com.example.day2.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SmsActivity extends AppCompatActivity {
	  
	  EditText editText1;
	  EditText editText2;
	  EditText editText3;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sms);
			
			editText1 = findViewById(R.id.editText);
			editText2 = findViewById(R.id.editText2);
			editText3 = findViewById(R.id.editText3);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View v) {
						finish();
				  }
			});
			
			Intent passedIntent = getIntent();
			processIntent(passedIntent);
			//전달받은 인텐트 처리하도록 processIntent 메서드 호출
	  }
	  
	  //해당 액티비티가 이미 만들어져있는 상태에서 전달받은 인텐트도 처리해야합니다.
	  //화면에 있는 [확인]버튼 클릭시 finish() 메서드 호출 >> 해당 화면을 닫음.
	  @Override
	  protected void onNewIntent(Intent intent) {
			processIntent(intent);
			
			super.onNewIntent(intent);
	  }
	  
	  private void processIntent(Intent intent) {
			//엔텐트가 널이 아니라면 . 그 안에 들어 있는 부가 데이터를 화면에 보여줌.
			if (intent != null) {
				  String sender = intent.getStringExtra("sender");
				  String contents = intent.getStringExtra("contents");
				  String receivedDate = intent.getStringExtra("receivedDate");
				  
				  editText1.setText(sender);
				  editText2.setText(contents);
				  editText3.setText(receivedDate);
				  
			}
	  }
}






























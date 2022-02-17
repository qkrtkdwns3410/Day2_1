package com.example.day2.SampleService;

import com.example.day2.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 *packageName    : com.example.day2.SampleService
 * fileName       : MainActivity
 * author         : letscombine
 * date           : 2022-02-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-17        letscombine       최초 생성
 */
public class MainActivity extends AppCompatActivity {
	  EditText editText;
	  
	  @Override
	  protected void onCreate(@Nullable Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_service);
			//레이아웃 설정
			
			editText = findViewById(R.id.editText);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View v) {
						String name = editText.getText().toString();
						
						//인텐트 객체를 만들고 부가데이터(Extra Data)를 넣습니다.
						Intent intent = new Intent(getApplicationContext(), MyService.class);
						
						intent.putExtra("command", "show");
						//command 키 : 서비스 쪽으로 전달한 인텐트 객체의 데이터가 어떤 목적으로 사용되는지를 구별
						//
						intent.putExtra("name", name);
						//name 키 : 입력상자에서 가져온 문자열을 전달하기 위함
						//
						startService(intent);
						//서비스 시작합니다.
				  }
				  
			});
	  }
}


























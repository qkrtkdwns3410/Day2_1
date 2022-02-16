package com.example.day2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SampleLifeCycle extends AppCompatActivity {
	  EditText inputName;

	  /*
	  *
	  * 액티비티 수명주기 찍히는거.
	  2022-02-16 14:53:26.005 13758-13758/com.example.day2 D/Main: onPause() 호출
	  2022-02-16 14:53:26.034 13758-13758/com.example.day2 D/Main: onStart() 호출
	  2022-02-16 14:53:26.042 13758-13758/com.example.day2 D/Main: onResume() 호출됨
	  2022-02-16 14:53:26.131 13758-13758/com.example.day2 D/Main: onStop() 호출
	  2022-02-16 14:53:26.147 13758-13758/com.example.day2 D/Main: onDestroy() 호출
	  *
	  * */
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sample_life_cycle);
			Toast.makeText(this, "onCreate() 호출", Toast.LENGTH_SHORT).show();

			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						Log.d("Main", "클릭됨");
						Intent intent = new Intent(getApplicationContext(), SampleLifeCycle.class);
						startActivity(intent);
				  }
			});

			inputName = findViewById(R.id.nameInput);

	  }

	  @Override
	  protected void onPause() {
			super.onPause();
			println("onPause() 호출");
			saveState();

	  }

	  @Override
	  protected void onResume() {
			super.onResume();
			println("onResume() 호출됨");
			restoreState();
	  }

	  @Override
	  protected void onStart() {
			super.onStart();
			println("onStart() 호출");
	  }

	  @Override
	  protected void onStop() {
			super.onStop();
			println("onStop() 호출");

	  }

	  @Override
	  protected void onDestroy() {
			super.onDestroy();
			println("onDestroy() 호출");

	  }

	  protected void restoreState() {
			//설정 정보에 저장된 데이터를 가져와서 메시지를 보여줍니다다
			println("상태 복원");
			SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
			if ((pref != null) && (pref.contains("name"))) {
				  String name = pref.getString("name", "");
				  inputName.setText(name);

			}
	  }

	  /*현재 입력상자에 입력된 데이터를 저장
	   *데이터 저장시 SharedPreferences >> 사용하여 pref 문자열을 저장소의 이름으로 사용
	   *SharedPreferences 객체 >> getSharedPreferences 로 사용합니다
	   *
	   *
	   * */
	  protected void saveState() {

			println("상태 저장");
			SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			// 데이터를 저장할 수 있도록 edit() 메서드 호출 >
			editor.putString("name", inputName.getText().toString());
			//putString 메서드로 저장하려는 데이터를 설정합니다

			editor.commit();
			//저장한 후에는 commit 메서드를 호출해야합니다
	  }

	  protected void clearState() {
			println("상태 비우기");
			SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			editor.clear();
			editor.commit();
	  }

	  public void println(String data) {
			Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
			Log.d("Main", data);
	  }
}
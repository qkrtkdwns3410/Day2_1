package com.example.day2.SampleKeypad;

import com.example.day2.R;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainKeypadActivity extends AppCompatActivity {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_keypad);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						if (getCurrentFocus() != null) {
							  //InputMethodManager : 객체 참조하기
							  InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(
								  INPUT_METHOD_SERVICE);
							  
							  inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
						}
				  }
			});
	  }
}
package com.example.day2.SampleSpinner;

import com.example.day2.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	  TextView textView;
	  
	  String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_spinner);
			
			textView = findViewById(R.id.textView);
			//스피너의 한 아이템을 선택시 선택한 값을 보여주기 위함입니다.
			
			Spinner spinner = findViewById(R.id.spinner);
			//어댑터 배열
			ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
			
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			//스피너도 선택 위젯이기에 어댑터 객체를 전달해야합니다.
			spinner.setAdapter(adapter);
			
			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				  //아이템이 선택되면!
				  @Override
				  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
						textView.setText(items[i]);
				  }
				  
				  //선택된게 없다면!
				  @Override
				  public void onNothingSelected(AdapterView<?> adapterView) {
						textView.setText("");
				  }
			});
	  }
}
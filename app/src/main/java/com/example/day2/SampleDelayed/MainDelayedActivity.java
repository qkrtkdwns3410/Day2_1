package com.example.day2.SampleDelayed;

import com.example.day2.R;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainDelayedActivity extends AppCompatActivity {
	  TextView textView;
	  
	  Handler handler = new Handler();
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_delayed);
			
			textView = findViewById(R.id.textView);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						//요청 다이얼을 띄움
						request();
				  }
			});
	  }
	  
	  private void request() {
			String title = "원격 요청";
			String message = "데이터를 요청하시겠습니까?";
			String titleButtonYes = "예";
			String titleButtonNo = "아니오";
			
			AlertDialog dialog = makeRequestDialog(title, message, titleButtonYes, titleButtonNo);
			dialog.show();
	  }
	  
	  private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleButtonYes,
		  CharSequence titleButtonNo) {
			
			AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
			
			requestDialog.setTitle(title);
			requestDialog.setMessage(message);
			//예 누르면!!
			requestDialog.setPositiveButton(titleButtonYes, new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialogInterface, int i) {
						textView.setText("5초 후에 결과 표시됨.");
						handler.postDelayed(new Runnable() {
							  
							  @Override
							  public void run() {
									textView.setText("요청 완료됨.");
							  }
						}, 5000);
						
				  }
			});
			
			requestDialog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialogInterface, int i) {
						
				  }
			});
			
			return requestDialog.create();
	  }
}















































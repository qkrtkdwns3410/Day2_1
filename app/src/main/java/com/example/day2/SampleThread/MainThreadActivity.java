package com.example.day2.SampleThread;

import com.example.day2.R;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;

public class MainThreadActivity extends AppCompatActivity {
	  TextView textView;
	  
	  Handler handler = new Handler();
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_thread);
			
			textView = findViewById(R.id.textView);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						BackgroundThread thread = new BackgroundThread();
						thread.start();
				  }
			});
	  }
	  
	  class BackgroundThread extends Thread {
			int value = 0;
			
			public void run() {
				  for (int i = 0; i < 100; i += 1) {
						try {
							  Thread.sleep(1000);
						} catch (Exception e) {
						
						}
					 
						value += 1;
						Log.d("Thread", "value : " + value);
					 
						handler.post(new Runnable() {
							  @Override
							  public void run() {
									textView.setText("value 값  : " + value);
							  }
						});
						// //obtainMessage : 메시지 객체를 하나 참조
						// Message message = handler.obtainMessage();
						//
						// Bundle bundle = new Bundle();
						// bundle.putInt("value", value);
						// message.setData(bundle);
						//
						// //핸들러로 메시지 객체를 전송
						// handler.sendMessage(message);
					 
				  }
			}
	  }
	  
	  class MainHandler extends Handler {
			
			//핸들러 안에서 전달받은 메시지 객체를 처리합니다.
			@Override
			public void handleMessage(@NonNull Message msg) {
				  //handleMessage() 메서드로 value 값을 전달해야 하는 문제가 생김..
				  super.handleMessage(msg);
				  //Message 객체에는  Bundle 객체가 들어 있어 putOOO() 메서드로 데이터를 넣었다가 getOOO() 메서드로 데이터를 가져올 수 있음.
				  
				  Bundle bundle = msg.getData();
				  int value = bundle.getInt("value");
				  textView.setText("value  값 : " + value);
			}
	  }
}












































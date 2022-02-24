package com.example.day2.SampleHttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.day2.R;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainHttpActivity extends AppCompatActivity {
	  
	  EditText editText;
	  TextView textView;
	  
	  Handler handler = new Handler();
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_http);
			
			editText = findViewById(R.id.editText);
			textView = findViewById(R.id.textView);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						final String urlStr = editText.getText().toString();
						//스레드 안에서 동작하도록.....
						new Thread(new Runnable() {
							  @Override
							  public void run() {
									//버튼 누르면 사용자가 입력한 사이트 주소를 이용해 request() 메서드를 호출합니다.
									request(urlStr);
							  }
						}).start();
						
				  }
			});
	  }
	  
	  public void request(String urlStr) {
			StringBuilder output = new StringBuilder();
			try {
				  URL url = new URL(urlStr);
				  
				  //HttpURL Connection 객체 만들기
				  //urlStr >> 문자열을 이용해 만들어진 객체의 openConnection 메서드 호출 >> HttpURLConnection 객체 반환
				  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				  
				  if (conn != null) {
						conn.setConnectTimeout(10000);
						conn.setRequestMethod("GET");
						conn.setDoInput(true);
						
						//응답코드 !!/..
						int resCode = conn.getResponseCode();
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String line = null;
						while (true) {
							  //read-line : 스트림에서 한 줄 씩 읽어들임.
							  line = reader.readLine();
							  if (line == null) {
									break;
							  }
							  
							  output.append(line + "\n");
							  
						}
						reader.close();
						conn.disconnect();
				  }
			} catch (Exception e) {
				  println("예외 발생: " + e.toString());
			}
			println("응답 >> " + output.toString());
	  }
	  
	  public void println(final String data) {
			handler.post(new Runnable() {
				  @Override
				  public void run() {
						textView.append(data + "\n");
				  }
			});
	  }
	  
}
	  
	 

	  


































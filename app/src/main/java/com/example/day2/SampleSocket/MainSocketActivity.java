package com.example.day2.SampleSocket;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.example.day2.R;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainSocketActivity extends AppCompatActivity {
	  EditText editText;
	  
	  TextView textView;
	  TextView textView2;
	  Handler handler = new Handler();
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_socket);
			
			editText = findViewById(R.id.editText);
			
			textView = findViewById(R.id.textView);
			textView2 = findViewById(R.id.textView2);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						final String data = editText.getText().toString();
						new Thread(new Runnable() {
							  @Override
							  public void run() {
									send(data);
							  }
						}).start();
						
				  }
			});
			
			Button button2 = findViewById(R.id.button2);
			button2.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						new Thread(new Runnable() {
							  @Override
							  public void run() {
									startServer();
							  }
						}).start();
				  }
			});
			//두 개의 버튼은 네트워킹 기능을 사용할 것이기에 스레드로 만들어야 합니다.
			
	  }
	  
	  //클라이언트 쪽 로그를 화면에 있는 텍스트 뷰에 출력하기 위해 핸들러 사용
	  
	  public void printClientLog(final String data) {
			Log.d("MainActivity", data);
			handler.post(new Runnable() {
				  @Override
				  public void run() {
						textView.append(data + "\n");
				  }
			});
	  }
	  //서버 쪽 로그를 화면에 있는 텍스트 뷰에 출력하기 위해 핸들러 사용
	  
	  public void printServerLog(final String data) {
			
			//전달받는 파라미터가 그대로 전달되어야 하기에 final로 정의되었습니다.
			Log.d("MainActivity", data);
			handler.post(new Runnable() {
				  @Override
				  public void run() {
						textView2.append(data + "\n");
				  }
			});
	  }
	  
	  public void startServer() {
			try {
				  int portNumber = 5001;
				  
				  //소켓 서버 객체 만들기
				  ServerSocket server = new ServerSocket(portNumber);
				  printServerLog("서버 시작함: " + portNumber);
				  
				  while (true) {
						//클라이언트의 접속 요청인 온 경우 accept 메서드를 통해 소켓 객체가 반환!
						Socket socket = server.accept();
						
						//접속할 IP주소 :
						InetAddress clientHost = socket.getLocalAddress();
						int clientPort = socket.getPort();
						printServerLog("클라이언트 연결됨: " + clientHost + " : " + clientPort);
						
						ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
						Object obj = inputStream.readObject();
						printServerLog("데이터 받은: " + obj);
						
						ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
						outputStream.writeObject(obj + " from Server.");
						outputStream.flush();
						printServerLog("데이터 보냄.");
						
						socket.close();
				  }
			} catch (Exception e) {
				  e.printStackTrace();
			}
	  }
	  
	  public void send(String data) {
			try {
				  int portNumber = 5001;
				  
				  Socket socket = new Socket("localhost", portNumber);
				  printClientLog("소켓 연결함.");
				  
				  ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				  outputStream.writeObject(data);
				  outputStream.flush();
				  printClientLog("데이터 전송함.");
				  
				  ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				  printClientLog("서버로부터 받음 : " + inputStream.readObject());
				  
				  socket.close();
			} catch (Exception e) {
				  e.printStackTrace();
			}
			
	  }
}













































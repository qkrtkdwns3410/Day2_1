package com.example.day2.SampleService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	  private static final String TAG = "MyService";
	  
	  public MyService() {
	  }
	  
	  @Override
	  public void onCreate() {
			super.onCreate();
			Log.d(TAG, "onCreate: ");
	  }
	  
	  /*onStartCommand : 인텐트 객체를 전달받습니다.
	   *
	   *서비스는 시스템에 의해 다시 시작될 수 있기에 > onStartCommand() 메서드로 전달되는 인텐트 객체가 null인 경우도 검사
	   *인텐트 객체가 null이면, onStartCommand() 메서드 >> Service.START_STICKY 을 반환
	   *
	   * 해당 값을 반환하지 않는다는 것은 서비스가 비정상적으로 종료됨을 의미 >> 시스템을 자동으로 재시작합니다.
	   *
	   * */
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
			Log.d(TAG, "onStartCommand: ");
			
			//인텐트 객체가 널이 아니면 processCommnad 호출하기...
			if (intent == null) {
				  
				  //START_STICKY
				  // : Service가 강제 종료되었을 경우 시스템이 다시 Service를 재시작 시켜 주지만 intent 값을 null로 초기화 시켜서 재시작 합니다.
				  // Service 실행시 startService(Intent service) 메서드를 호출 하는데
				  // onStartCommand(Intent intent, int flags, int startId) 메서드에 intent로 value를 넘겨 줄 수 있습니다.
				  
				  // 기존에 intent에 value값이 설정이 되있다고 하더라도
				  // Service 재시작시 intent 값이 null로 초기화 되서 재시작 됩니다.
				  
				  return Service.START_STICKY;
			} else {
				  processCommand(intent);
			}
			
			return super.onStartCommand(intent, flags, startId);
	  }
	  
	  private void processCommand(Intent intent) {
			//인텐트에서 부가데이터를 가져옵니다.
			String command = intent.getStringExtra("command");
			String name = intent.getStringExtra("name");
			
			Log.d(TAG, "name = " + name);
			Log.d(TAG, "command = " + command);
			
			Log.d(TAG, "============================================");
			
			for (int index = 0; index < 5; index += 1) {
				  try {
						Thread.sleep(1000);
						
				  } catch (Exception e) {
						System.out.println(e.getMessage());
				  }
				  Log.d(TAG, "seconds = " + index);
			}
			
			// 참고 https://onepinetwopine.tistory.com/327
			/*
			 *FLAG_ACTIVITY_NEW_TASK : 새로운 태스크를 생성하여 그 태스크안에 액티비를 추가
			 *FLAG_ACTIVITY_CLEAR_TOP : 만약 태스크에 호출하려는 액티비티의 인스턴스가 이미 존재하고 있을 경우에
			 * 														새로운 인스턴스를 생성하는 것 대신에 존재하고 있는 액티비티를 포그라운드로 가져옵니다
			 *															그리고 호출한 인스턴스를 포그라운드로 가져올때까지 있었던 위의 인스턴스들을 모두 삭제합니다.
			 * FLAG_ACTIVITY_SINGLE_TOP : 액티비티를 호출할 때 호출된 액티비티의 인스턴스가 현재 태스크의 루트에 이미 실행중인 경우 활동이 재실행되지 않음
			 * 															(== 새로운 인스턴스 생성 X)
			 *
			 * */
			Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
			//인텐트 객체를 new 연산자로 생성할 때
			// 1. getApplicationContext : Context 객체를 전달합니다
			
			showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
					Intent.FLAG_ACTIVITY_SINGLE_TOP |
					Intent.FLAG_ACTIVITY_CLEAR_TOP
			);
			//startActitity >> 메서드를 호출시 > 새로운 태스크를 생성해야하기에  FLAG_ACTIVITY_NEW_TASK 사용
			//FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP>> 메인 액티비티객체가 이미 메모리에 만들어져있을 때 재사용을 위해
			
			showIntent.putExtra("command", "show");
			showIntent.putExtra("name", name + " from service.");
			
			startActivity(showIntent);
			//메인 액티비티쪽으로 인텐트 객체가 전달됩니다.
	  }
	  
	  @Override
	  public void onDestroy() {
			super.onDestroy();
	  }
	  
	  /*
	   * 서비스가 서버 역할을 하면서 액티비티와 연결될 수 있도록 함 >> 바인딩
	   *
	   * */
	  @Override
	  public IBinder onBind(Intent intent) {
			// TODO: Return the communication channel to the service.
			throw new UnsupportedOperationException("Not yet implemented");
	  }
}
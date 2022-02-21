package com.example.day2.SampleReceiver;

import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
	  public static final String TAG = "SmsReceiver";
	  public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  
	  //SMS을 받으면 onReceive() 메서드가 자동으로 호출됩니다.
	  @Override
	  public void onReceive(Context context, Intent intent) {
			//intent 객체안에 SMS의 데이터가 IN IT
			Log.i(TAG, "onReceiver() 메서드 호출됨");
			
			Bundle bundle = intent.getExtras(); //인텐트에서 번들 객체를 가져옵니다.
			SmsMessage[] messages = parseSmsMessage(bundle);
			
			if (messages != null && messages.length > 0) {
				  String sender = messages[0].getOriginatingAddress();
				  //발신자의 번호를 확인
				  Log.d(TAG, "SMS sender: " + sender);
				  
				  String contents = messages[0].getMessageBody();
				  //문자 내용 확인
				  Log.d(TAG, "SMS contents: " + contents);
				  
				  Date receivedDate = new Date(messages[0].getTimestampMillis());
				  //문자 수신 시각확인
				  Log.d(TAG, "SMS received data :" + receivedDate);
				  
				  sendToActivity(context, sender, contents, receivedDate); // 새로운 화면을 띄우기 위한 메서드 호출
				  //SmsActivity로 인텐트를 보내기위함입니다.!
			}
			
	  }
	  
	  private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
			Intent myIntent = new Intent(context, SmsActivity.class);
			
			//인텐트에 플래그를 추가합니다 ..
			/*https://onepinetwopine.tistory.com/327
			 * FLAG_ACTIVITY_NEW_TASK : 새로운 태스크를 생성하여 그 태스크안에 엑티비티를 추가하게 됩니다.
			 * FLAG_ACTIVITY_SINGLE_TOP :액티비티를 호출할 때 호출된 액티비티의 인스턴스가 현재 태스크의 루트에 이미 실행중인 경우 활동이 재실행되지 않습니다( = 새로운 인스턴스를 생성하지 않습니다.)
			 *FLAG_ACTIVITY_CLEAR_TOP :만약에 태스크에 호출하려는 엑티비티의 인스턴스가 이미 존재하고 있을 경우에 >>새로운 인스턴스를 생성하는 것 대신에 존재하고 있는 액티비티를 포그라운드로 가져옵니다.
			 *												그리고 호출한 인스턴스를 포그라운드로 가져올때까지 있었던 위의 인스턴스들을 모두 삭제합니다.
															위에서 호출한 액티비티의 인스턴스와 동일한 인스턴스는  onNewIntent() 메소드에서 시작하는 새 인 텐트를 받거나 완료되어 새로운 인텐트로 다시 시작됩니다.
			 * */
			myIntent.addFlags(
				Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			myIntent.putExtra("sender", sender);
			myIntent.putExtra("contents", contents);
			myIntent.putExtra("receivedDate", format.format(receivedDate));
			
			context.startActivity(myIntent);
	  }
	  
	  private SmsMessage[] parseSmsMessage(Bundle bundle) {
			//Bundel 객체에 들어가 있는 부가 데이터 중 pdus 가져오기
			Object[] objects = (Object[])bundle.get("pdus");
			SmsMessage[] messages = new SmsMessage[objects.length];
			
			int smsCount = objects.length;
			for (int count = 0; count < smsCount; count += 1) {
				  
				  //단말 OS 버전에 따라 다른 방식으로 메서드를 호출합니다.
				  //AOS 23이상버전인경우 현재 32까지
				  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
						String format = bundle.getString("format");
						//인텐트 객체 안에 부가 데이터로 들어 있는 SMS 데이터를 확인하기 위하여 SMSMessage 클래스의 createFromPdu 메서더로 SmsMessage 객체로 변환합니다.
						
						messages[count] = SmsMessage.createFromPdu((byte[])objects[count], format);
				  } else {
						
						messages[count] = SmsMessage.createFromPdu((byte[])objects[count]);
				  }
			}
			
			return messages;
	  }
	  
}
























































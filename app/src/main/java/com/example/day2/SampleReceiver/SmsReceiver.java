package com.example.day2.SampleReceiver;

import java.sql.DatabaseMetaData;
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
				  
			}
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
			
			return new SmsMessage[0];
	  }
	  
}
























































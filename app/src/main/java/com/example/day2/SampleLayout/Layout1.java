package com.example.day2.SampleLayout;

import java.util.function.IntFunction;

import com.example.day2.R;

import android.content.Context;
import android.mtp.MtpObjectInfo;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/**
 *packageName    : com.example.day2.SampleLayout
 * fileName       : Layout1
 * author         : ipeac
 * date           : 2022-02-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-22        ipeac       최초 생성
 */
public class Layout1 extends LinearLayout {
	  ImageView imageView;
	  TextView textView;
	  TextView textView2;
	  
	  public Layout1(Context context) {
			super(context);
			init(context);
	  }
	  
	  public Layout1(Context context, @Nullable AttributeSet attrs) {
			super(context, attrs);
			init(context);
	  }
	  
	  //
	  private void init(Context context) {
			//인플레이션 진행
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//LayoutInflater > 시스템의 서비스로 제공되므로 getSystemService 메서드를 호출하면서
			// 파라미터로 Context.LAYOUT_INFLATER_SERVICE 상수를 전달하면서 객체가 반환
			//해당 객체의 inflate () 메서드를 호출하면서 XML 레이아웃 파일을 파라미터로 전달..
			//인플레이션이 진행되면서 해당 소스파일에 설정.
			
			inflater.inflate(R.layout.layout1, this, true);
			
			//XML레이아웃에 정의했던 뷰를 참조
			imageView = findViewById(R.id.imageView);
			textView = findViewById(R.id.textView);
			textView2 = findViewById(R.id.textView2);
			
	  }
	  
	  //뷰에 데이터를 설정
	  public void setImage(int resId) {
			imageView.setImageResource(resId);
	  }
	  
	  public void setName(String name) {
			textView.setText(name);
	  }
	  
	  public void setMoblie(String moblie) {
			textView2.setText(moblie);
			
	  }
	  
}





































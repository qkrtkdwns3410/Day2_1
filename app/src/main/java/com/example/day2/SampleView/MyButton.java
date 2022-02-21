package com.example.day2.SampleView;

import com.example.day2.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : ${USER}
 * date           : ${DATE}
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * ${DATE}        ${USER}       최초 생성
 */
public class MyButton extends AppCompatButton {
	  /*해당 뷰를 소스 코드에서 new 연산자로 생성하는 경우 사용합니다.
	   *
	   * */
	  public static final String TAG = "MyButton";
	  
	  public MyButton(@NonNull Context context) {
			super(context);
			init(context);
	  }
	  
	  /* AttributeSet : XML 레이아웃에서 태그에 추가하는 속성을 전달받기 위함입니다.
	   *해당 뷰를 XML 레이아웃에 추가하는 경우 이 두 번째 생성자가 사용됩니다.
	   *
	   * */
	  
	  public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
			super(context, attrs);
			init(context);
	  }
	  
	  private void init(Context context) {
			//초기화를 위한 메서드 정의
			/*뷰의 배경색과 글자색을 설정*/
			setBackgroundColor(Color.CYAN);
			setTextColor(Color.BLACK);
			
			float textSize = getResources().getDimension(R.dimen.text_size);
			//글자 크기 설정 >> 픽셀단위만 가능.... 사용 잘안함.** >>
			//sp 단위 사용위해서는 소스코드말고 XML 파일 사용해야함
			setTextSize(textSize);
			
	  }
	  
	  @Override
	  protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			
			//뷰가 다시 그려진다면 onDraw() 메서드가 동작....
			
			Log.d(TAG, "onDraw: 호출됨");
	  }
	  
	  @Override
	  public boolean onTouchEvent(MotionEvent event) {
			Log.d(TAG, "onTouchEvent: 호출됨");
			
			//손가락이 눌렷는지 등 정수로 확인
			int action = event.getAction();
			
			switch (action) {
				  case MotionEvent.ACTION_DOWN:
						setBackgroundColor(Color.BLUE);
						setTextColor(Color.RED);
						
						break;
				  case MotionEvent.ACTION_OUTSIDE:
				  case MotionEvent.ACTION_CANCEL:
				  case MotionEvent.ACTION_UP:
						setBackgroundColor(Color.CYAN);
						setTextColor(Color.BLACK);
						
						break;
			}
			//invalidate() 메서드 호출 > 뷰를 다시 그림..
			invalidate();
			
			return true;
	  }
}






































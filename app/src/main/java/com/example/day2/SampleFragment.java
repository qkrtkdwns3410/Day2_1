package com.example.day2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SampleFragment extends AppCompatActivity {
	  
	  MainFragment mainFragment;
	  MenuFragment menuFragment;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sample_fragment);
			
			//프래그먼트는 뷰가 아니라 Activity 클래스의 findViewById()  사용이 불가능합니다
			//FragmentManager의 findFragmentById 사용하여 프래그먼트를 검색하빈다
			mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
			menuFragment = new MenuFragment();
			//메뉴 프래그먼트는 new 연산자로 새로운 객체로 만들어 변수에 할당
	  }
	  
	  public void onFragmentChanged(int index) {
			if (index == 0) {
				  //replace >> 1 para : 프래그먼트를 담고 있는 레이아웃의 id가 되어야함 2 para : 바꿀 프래그먼트
				  //프래그먼트 변경시 오류가 생기면 다시 원 상태로 돌릴 수 있어야 하기에 트랜잭션 객체를 만들어 실행합니다.
				  getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
				  
			} else if (index == 1) {
				  getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
			}
	  }
}
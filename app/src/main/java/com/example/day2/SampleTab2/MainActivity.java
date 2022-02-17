package com.example.day2.SampleTab2;

import com.example.day2.R;
import com.example.day2.SampleTab.Fragment1;
import com.example.day2.SampleTab.Fragment2;
import com.example.day2.SampleTab.Fragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*AppCompatActivity 클래스는 안드로이드의 하위버전을 지원하는 액티비티이다.
예를 들면, ActionBar는 최신버전에서 지원하지 않는다.
하지만 AppCompatActivity 클래스를 사용하면 액션바를 동작할 수 있다.
Activity 클래스는 최신버전의 안드로이드만 지원한다.*/
public class MainActivity extends AppCompatActivity {
	  Toolbar toolbar;
	  
	  Fragment1 fragment1;
	  Fragment2 fragment2;
	  Fragment3 fragment3;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			//4에 연결되어 있습니다!.
			setContentView(R.layout.activity_main5);
			
			fragment1 = new Fragment1();
			fragment2 = new Fragment2();
			fragment3 = new Fragment3();
			
			getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
			
			BottomNavigationView bottomNavigation = findViewById(R.id.botton_navigation);
			/*setOnNavigationItemSelectedListener : 해당 메서드 호출시 >> 탭이 선택되었을때의 이벤트를 받아 처리가능.*/
			bottomNavigation.setOnNavigationItemSelectedListener(item -> {
				  switch (item.getItemId()) {
						case R.id.tab1:
							  Toast.makeText(getApplicationContext(), "첫 번째 탭 선택됨", Toast.LENGTH_SHORT).show();
							  getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
							  
							  return true;
						case R.id.tab2:
							  Toast.makeText(getApplicationContext(), "두번째 탭 선택됨", Toast.LENGTH_SHORT).show();
							  getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
							  
							  return true;
						case R.id.tab3:
							  Toast.makeText(getApplicationContext(), "세 번째 탭 선택됨", Toast.LENGTH_SHORT).show();
							  getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
							  
							  return true;
				  }
				  return false;
				  
			});
	  }
}
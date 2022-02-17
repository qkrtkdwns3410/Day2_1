package com.example.day2.SampleTab;

import com.example.day2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
	  Toolbar toolbar;
	  
	  Fragment1 fragment1;
	  Fragment2 fragment2;
	  Fragment3 fragment3;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			//4에 연결되어 있습니다!.
			setContentView(R.layout.activity_main4);
			
			toolbar = findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);
			//액션바로 설정합니다 >> 액티비티에 디폴트로 만들어진 액션바가 없는 경우에만 동작
			//설정에서 액션바가 존재하지 않는 테마로 설정해야합니다. >> Theme
			
			ActionBar actionBar = getSupportActionBar();
			actionBar.setDisplayShowTitleEnabled(false);
			
			fragment1 = new Fragment1();
			fragment2 = new Fragment2();
			fragment3 = new Fragment3();
			
			getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
			
			TabLayout tabs = findViewById(R.id.tabs);
			tabs.addTab(tabs.newTab().setText("통화기록"));
			tabs.addTab(tabs.newTab().setText("스팸 기록"));
			tabs.addTab(tabs.newTab().setText("연락처"));
			
			tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
				  @Override
				  public void onTabSelected(TabLayout.Tab tab) {
						int position = tab.getPosition();
						Log.d("Main", "선택된 탭 : " + position);
						Fragment selected = null;
						if (position == 0) {
							  selected = fragment1;
						} else if (position == 1) {
							  selected = fragment2;
						} else if (position == 2) {
							  selected = fragment3;
						}
						getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
						
				  }
				  
				  @Override
				  public void onTabUnselected(TabLayout.Tab tab) {
						
				  }
				  
				  @Override
				  public void onTabReselected(TabLayout.Tab tab) {
						
				  }
			});
			BottomNavigationView bottomNavigation = findViewById(R.id.botton_navigation);
			/*setOnNavigationItemSelectedListener : 해당 메서드 호출시 >> 탭이 선택되었을때의 이벤트를 받아 처리가능.*/
			bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
				  @Override
				  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
						
				  }
			});
	  }
}
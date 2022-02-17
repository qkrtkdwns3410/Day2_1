package com.example.day2.SampleDrawer;

import com.example.day2.R;
import com.example.day2.SampleTab.Fragment1;
import com.example.day2.SampleTab.Fragment2;
import com.example.day2.SampleTab.Fragment3;
import com.google.android.material.navigation.NavigationView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener,
		FragmentCallback {
	  Fragment1 fragment1;
	  Fragment2 fragment2;
	  Fragment3 fragment3;
	  
	  DrawerLayout drawer;
	  Toolbar toolbar;
	  
	  @Override
	  protected void onCreate(@Nullable Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main6);
			
			toolbar = findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);
			//액션바 설정
			
			drawer = findViewById(R.id.drawer_layout);
			ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
					drawer, toolbar, R.string.navigation_drawer_open,
					R.string.navigation_drawer_close);
			
			drawer.addDrawerListener(toggle);
			toggle.syncState();
			
			NavigationView navigationView = findViewById(R.id.nav_view);
			navigationView.setNavigationItemSelectedListener(this);
			
			fragment1 = new Fragment1();
			fragment2 = new Fragment2();
			fragment3 = new Fragment3();
			
			getSupportFragmentManager().beginTransaction().add(
					R.id.container, fragment1).commit();
	  }
	  
	  /*
	   * 시스템 Back키 입력시 네비를 닫는 역할
	   * */
	  @Override
	  public void onBackPressed() {
			if (drawer.isDrawerOpen(GravityCompat.START)) {
				  drawer.closeDrawer(GravityCompat.START);
				  
			} else {
				  super.onBackPressed();
				  
			}
	  }
	  
	  /**
	   *
	   * @param item
	   * @return boolean
	   *
	   * @apiNote
	   */
	  @Override
	  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			int id = item.getItemId();
			
			//어떤 메뉴가 눌린 것인지 구분
			if (id == R.id.menu1) {
				  Toast.makeText(this, "첫 번째 메뉴 선택", Toast.LENGTH_SHORT).show();
				  //해당 프래그먼트를 화면에 표시하도록합니다.
				  onFragmentSelected(0, null);
				  
			} else if (id == R.id.menu2) {
				  Toast.makeText(this, "두 번째 메뉴 선택", Toast.LENGTH_SHORT).show();
				  onFragmentSelected(1, null);
				  
			} else if (id == R.id.menu3) {
				  Toast.makeText(this, "세 번째 메뉴 선택", Toast.LENGTH_SHORT).show();
				  onFragmentSelected(2, null);
				  
			}
			drawer.closeDrawer(GravityCompat.START);
			
			return true;
	  }
	  
	  /**
	   *
	   * @param position
	   * @param bundle
	   *
	   * @apiNote 어떠한 프래그먼트를 보여줄 것인지 선택!
	   */
	  
	  @Override
	  public void onFragmentSelected(int position, Bundle bundle) {
			Fragment curFragment = null;
			
			if (position == 0) {
				  curFragment = fragment1;
				  toolbar.setTitle("첫 번째 화면");
				  
			} else if (position == 1) {
				  curFragment = fragment2;
				  toolbar.setTitle("두 번째 화면");
				  
			} else if (position == 2) {
				  curFragment = fragment3;
				  toolbar.setTitle("세 번째 화면");
				  
			}
			getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
			
	  }
}
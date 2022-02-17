package com.example.day2.SampleActionBar1;

import com.example.day2.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	  ActionBar actionBar;
	  
	  //actionbar자료형 변수의 선언
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main3);
			
			actionBar = getSupportActionBar();//androidx.appcompat.app 패지키 안의 클래스를 import...
			//xml 레아아웃에 들어있는 ActionBar 객체를 참조 , ActionBar 객체는 직접 XML 레이아웃에 추가가능...| 애티비티에 ㅈ거용한 테마에 따라 자동으로 적용가능
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						actionBar.setLogo(R.drawable.home);
						//setDisplayOptions : 버튼 클릯시 액션바가 보이는 모양을 바꿈
						//Use Logo : 홈아이콘 부분에 로코 아이콘 사용 || SHOW_HOME : 홈 아이콘을 표시하도록 합니다 || HOME_AS_UP : 홈 아이콘에 뒤로 가기 모양의 < 아이콘을 표시 || DISPLAY_SHOW_TITLE : 타이틀을 표시하도록 합니다
						
						actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
				  }
			});
	  }
	  
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.menu_main, menu);
			return true;
	  }
	  
	  @Override
	  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
			int curId = item.getItemId();
			switch (curId) {
				  case R.id.menu_refresh:
						Toast.makeText(this, "새로고침 메뉴가 실행", Toast.LENGTH_SHORT).show();
						break;
				  case R.id.menu_search:
						Toast.makeText(this, "검색 메뉴가 선택", Toast.LENGTH_SHORT).show();
						break;
				  case R.id.menu_settings:
						Toast.makeText(this, "설정 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
						break;
				  default:
						break;
			}
			
			return super.onOptionsItemSelected(item);
	  }
}
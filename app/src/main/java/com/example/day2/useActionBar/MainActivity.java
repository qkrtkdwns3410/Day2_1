package com.example.day2.useActionBar;

import com.example.day2.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	  
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.menu_main, menu);
			return true;
	  }
	  
	  @Override
	  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
			/*사용자가 하나의 메뉴 아이템을 선택시 >> 자동 호출되는 onOptionsMenu() */
			/*액티비티가 만들어 질때 미리 자동호출되어 화면에 메뉴 기능을 추가할 수 있음 >> onCreateOptionsMenu() */
			int curId = item.getItemId();
			
			switch (curId) {
				  case R.id.menu_refresh:
						Toast.makeText(this, "새로고침 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
						break;
				  case R.id.menu_search:
						Toast.makeText(this, "검색 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
						break;
				  case R.id.menu_settings:
						Toast.makeText(this, "설정 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
						break;
				  default:
						break;
			}
			return super.onOptionsItemSelected(item);
	  }
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_menu);
			
	  }
}
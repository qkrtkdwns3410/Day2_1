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
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main3);
			
			actionBar = getSupportActionBar();
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						actionBar.setLogo(R.drawable.home);
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
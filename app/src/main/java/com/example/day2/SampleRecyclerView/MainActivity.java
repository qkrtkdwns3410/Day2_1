package com.example.day2.SampleRecyclerView;

import com.example.day2.R;
import com.example.day2.SampleView.OnPersonItemClickListener;
import com.example.day2.SampleView.Person;
import com.example.day2.SampleView.PersonAdapter;

import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
	  RecyclerView recyclerView;
	  PersonAdapter adapter;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_recycle);
			
			recyclerView = findViewById(R.id.recyclerView);
			
			//2 파라 : 칼럼의 개수수
			GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
			//setLayoutManager : 레이아웃 매니저 객체를 설정....
			recyclerView.setLayoutManager(layoutManager);
			//
			adapter = new PersonAdapter();
			
			adapter.addItem(new Person("김민수", "010-1000-1000"));
			adapter.addItem(new Person("박민수", "010-2000-2000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("김민수", "010-4000-4000"));
			adapter.addItem(new Person("박민수", "010-5000-5000"));
			adapter.addItem(new Person("최민수", "010-6000-6000"));
			adapter.addItem(new Person("김민수", "010-7000-7000"));
			adapter.addItem(new Person("박민수", "010-8000-8000"));
			adapter.addItem(new Person("김민수", "010-1000-1000"));
			adapter.addItem(new Person("박민수", "010-2000-2000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("김민수", "010-4000-4000"));
			adapter.addItem(new Person("박민수", "010-5000-5000"));
			adapter.addItem(new Person("최민수", "010-6000-6000"));
			adapter.addItem(new Person("김민수", "010-7000-7000"));
			adapter.addItem(new Person("박민수", "010-8000-8000"));
			adapter.addItem(new Person("김민수", "010-1000-1000"));
			adapter.addItem(new Person("박민수", "010-2000-2000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("김민수", "010-4000-4000"));
			adapter.addItem(new Person("박민수", "010-5000-5000"));
			adapter.addItem(new Person("최민수", "010-6000-6000"));
			adapter.addItem(new Person("김민수", "010-7000-7000"));
			adapter.addItem(new Person("박민수", "010-8000-8000"));
			
			recyclerView.setAdapter(adapter);
			
			adapter.setOnItemListener(new OnPersonItemClickListener() {
				  @Override
				  public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
						Person item = adapter.getItem(position);
						
						Toast.makeText(getApplicationContext(), "아이템 선택됨: " + item.getName(), Toast.LENGTH_SHORT)
							.show();
				  }
			});
	  }
}
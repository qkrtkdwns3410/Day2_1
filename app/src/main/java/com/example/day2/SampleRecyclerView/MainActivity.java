package com.example.day2.SampleRecyclerView;

import com.example.day2.R;
import com.example.day2.SampleView.Person;
import com.example.day2.SampleView.PersonAdapter;

import android.widget.GridLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_recycle);
			
			RecyclerView recyclerView = findViewById(R.id.recyclerView);
			
			//2 파라 : 칼럼의 개수수
			GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
			//setLayoutManager : 레이아웃 매니저 객체를 설정....
			recyclerView.setLayoutManager(layoutManager);
			//
			PersonAdapter adapter = new PersonAdapter();
			
			adapter.addItem(new Person("김민수", "010-1000-1000"));
			adapter.addItem(new Person("박민수", "010-2000-2000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			adapter.addItem(new Person("최민수", "010-3000-3000"));
			
			recyclerView.setAdapter(adapter);
	  }
}
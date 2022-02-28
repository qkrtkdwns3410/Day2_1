package com.example.day2.SampleDatabase;

import com.example.day2.R;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainDatabaseActivity extends AppCompatActivity {
	  EditText editText;
	  EditText editText2;
	  TextView textView;
	  
	  SQLiteDatabase database;
	  
	  String tableName;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_database);
			
			editText = findViewById(R.id.editText);
			editText2 = findViewById(R.id.editText2);
			textView = findViewById(R.id.textView);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						String databaseName = editText.getText().toString();
						createDatabase(databaseName);
						
				  }
			});
			Button button2 = findViewById(R.id.button2);
			button2.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						tableName = editText2.getText().toString();
						createTable(tableName);
						
						insertRecord();
				  }
			});
	  }
	  
	  private void insertRecord() {
			println("insertRecord() 호출됨.");
			
			if (database == null) {
				  println("데이터베이스를 먼저 생성하세요.");
				  return;
			}
			if (tableName == null) {
				  println("테이블을 먼저 생성하세요");
				  return;
			}
			database.execSQL("insert into " + tableName + ""
				+ "(name, age, mobile) "
				+ "values"
				+ "('john',20,'010-1000-1000')");
			
			println("레코드 추가함.");
	  }
	  
	  private void createTable(String tableName) {
			println("createTable 호출됨.");
			
			if (database == null) {
				  println("데이터베이스를 먼저 생성하세요");
				  return;
			}
			database.execSQL("create table if not exists " + tableName + " (_id integer PRIMARY KEY autoincrement,"
				+ "name text,"
				+ "age integer,"
				+ "mobile text)");
			
			println("테이블 생성함: " + tableName);
	  }
	  
	  private void createDatabase(String databaseName) {
			println("createDatabase 호출됨.");
			
			database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
			
			println("데이터베이스 생성함: " + databaseName);
	  }
	  
	  public void println(String data) {
			textView.append(data + "\n");
	  }
}








































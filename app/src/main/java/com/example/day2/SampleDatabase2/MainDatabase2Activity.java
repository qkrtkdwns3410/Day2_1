package com.example.day2.SampleDatabase2;

import com.example.day2.R;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainDatabase2Activity extends AppCompatActivity {
	  EditText editText;
	  EditText editText2;
	  TextView textView;
	  
	  DatabaseHelper dbHelper;
	  SQLiteDatabase database;
	  String tableName;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_database2);
			
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
			
			Button button3 = findViewById(R.id.button3);
			button3.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						executeQuery();
				  }
			});
	  }
	  
	  private void executeQuery() {
			println("executeQuery 호출됨.");
			
			Cursor cursor = database.rawQuery("select _id, name, age, mobile from emp", null);
			int recordCount = cursor.getCount();
			println("레코드 개수: " + recordCount);
			
			for (int i = 0; i < recordCount; i += 1) {
				  cursor.moveToNext();
				  
				  int id = cursor.getInt(0);
				  String name = cursor.getString(1);
				  int age = cursor.getInt(2);
				  String mobile = cursor.getString(3);
				  
				  println("레코드#" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
			}
			
			cursor.close();
			
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
			
			dbHelper = new DatabaseHelper(this);
			database = dbHelper.getWritableDatabase();
			
			println("데이터베이스 생성함: " + databaseName);
	  }
	  
	  public void println(String data) {
			textView.append(data + "\n");
	  }
}










































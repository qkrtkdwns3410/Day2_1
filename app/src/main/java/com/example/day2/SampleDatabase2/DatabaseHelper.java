package com.example.day2.SampleDatabase2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 *packageName    : com.example.day2.SampleDatabase2
 * fileName       : DatabaseHelper
 * author         : ipeac
 * date           : 2022-02-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-26        ipeac       최초 생성
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	  
	  public static String NAME = "employee.db";
	  public static int VERSION = 1;
	  
	  public DatabaseHelper(Context context) {
			super(context, NAME, null, VERSION);
	  }
	  
	  @Override
	  public void onCreate(SQLiteDatabase sqLiteDatabase) {
			println("onCreate 호출됨");
			
			String sql = "create table if not exists emp("
				+ "_id integer PRIMARY KEY autoincrement, "
				+ " name text, "
				+ "age integer, "
				+ "mobile text)";
			
			sqLiteDatabase.execSQL(sql);
	  }
	  
	  @Override
	  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
			println("onUpgrade 호출됨: " + oldVersion + " -> " + newVersion);
			
			if (newVersion > 1) {
				  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS emp");
			}
	  }
	  
	  @Override
	  public void onOpen(SQLiteDatabase db) {
			println("opOpen 호출됨");
	  }
	  
	  public void println(String data) {
			Log.d("DatabaseHelper", data);
	  }
}





























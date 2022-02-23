package com.example.day2.SampleAsyncTask;

import com.example.day2.R;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainAsyncTaskActivity extends AppCompatActivity {
	  BackgroundTask task;
	  int value;
	  
	  ProgressBar progressBar;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_async_task);
			
			progressBar = findViewById(R.id.progress_circular);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						//태스크 객체 만들어 실행하기
						task = new BackgroundTask();
						task.execute();
				  }
			});
			
			Button button2 = findViewById(R.id.button2);
			button2.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						task.cancel(true);
				  }
			});
	  }
	  
	  class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {
			
			@Override
			protected void onPreExecute() {
				  value = 0;
				  progressBar.setProgress(value);
				  
			}
			
			@Override
			protected Integer doInBackground(Integer... integers) {
				  
				  while (isCancelled() == false) {
						value += 1;
						
						if (value >= 100) {
							  break;
						} else {
							  publishProgress(value);
							  
						}
						
						try {
							  Thread.sleep(100);
						} catch (InterruptedException ex) {
						
						}
				  }
				  
				  return value;
			}
			
			@Override
			protected void onProgressUpdate(Integer... values) {
				  progressBar.setProgress(values[0].intValue());
			}
			
			@Override
			protected void onPostExecute(Integer integer) {
				  progressBar.setProgress(0);
				  
			}
			
			@Override
			protected void onCancelled() {
				  progressBar.setProgress(0);
				  
			}
	  }
}



















































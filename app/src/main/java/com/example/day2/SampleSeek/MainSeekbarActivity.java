package com.example.day2.SampleSeek;

import com.example.day2.R;

import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainSeekbarActivity extends AppCompatActivity {
	  TextView textView;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_seekbar);
			
			textView = findViewById(R.id.textView);
			
			SeekBar seekBar = findViewById(R.id.seekBar);
			
			seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				  @Override
				  public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
						setBrightness(i);
						textView.setText("변경된 값 : " + i);
				  }
				  
				  @Override
				  public void onStartTrackingTouch(SeekBar seekBar) {
						
				  }
				  
				  @Override
				  public void onStopTrackingTouch(SeekBar seekBar) {
						
				  }
			});
	  }
	  
	  private void setBrightness(int value) {
			if (value < 10) {
				  value = 10;
			} else if (value > 100) {
				  value = 100;
			}
			
			WindowManager.LayoutParams params = getWindow().getAttributes();
			params.screenBrightness = (float)value / 100;
			getWindow().setAttributes(params);
			
	  }
}

















































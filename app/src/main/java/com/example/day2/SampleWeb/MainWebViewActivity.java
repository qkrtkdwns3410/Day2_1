package com.example.day2.SampleWeb;

import com.example.day2.R;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainWebViewActivity extends AppCompatActivity {
	  EditText editText;
	  WebView webView;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_web_view);
			
			editText = findViewById(R.id.editText);
			webView = findViewById(R.id.webView);
			
			//웹뷰의 설정 수정하기
			WebSettings webSettings = webView.getSettings();
			//웹에 자바 스크립트의 허용
			webSettings.setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new ViewClient());
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						// 버튼 클릭시 사이트 로딩
						webView.loadUrl(editText.getText().toString());
				  }
			});
	  }
	  
	  private class ViewClient extends WebViewClient {
			@Override
			public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
				  view.loadUrl(url);
				  
				  return true;
			}
	  }
}
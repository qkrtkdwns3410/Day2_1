package com.example.day2.SampleRequest;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day2.R;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainVolleyActivity extends AppCompatActivity {
	  EditText editText;
	  TextView textView;
	  
	  //요청 큐는 한 번만 만들어 계속 사용가능하기에 static 키워드로 클래스 변수를 선언 후 할당하였습니다.
	  static RequestQueue requestQueue;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_volley);
			
			editText = findViewById(R.id.editText);
			textView = findViewById(R.id.textView);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						//사용자가 버튼을 클릭했을 때 요청 객체를 만들고 요청 큐에 넣어줍니다.
						makeRequest();
				  }
			});
			
			//RequestQueue 생성하기
			if (requestQueue == null) {
				  requestQueue = Volley.newRequestQueue(getApplicationContext());
			}
	  }
	  
	  public void makeRequest() {
			String url = editText.getText().toString();
			
			//1 : get | post .. 요청방식을 지정합니다.
			//2 : 웹 사이트의 주소
			//3 : 응답받을 리스너 객체를 전달
			//4 :
			StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
				  // 메서드를 응답 받은 경우 자동으로 호출됩니다.
				  @Override
				  public void onResponse(String response) {
						println("응답 >> " + response);
				  }
				  //에러가 난 경우 자동으로 호출
			}, new Response.ErrorListener() {
				  @Override
				  public void onErrorResponse(VolleyError error) {
						println("에러 >> " + error);
				  }
			}
			) {
				  //POST방식을 사용하면 요청 파라미터를 전달하고자하면 getParams 안의 HashMap 객체에다가 정보를 담아서 ...
				  @Nullable
				  @Override
				  protected Map<String, String> getParams() throws AuthFailureError {
						Map<String, String> params = new HashMap<>();
						
						return params;
				  }
			};
			//캐쉬 사용여부
			request.setShouldCache(false);
			//요청 객체를 요청 큐에 넣음.
			requestQueue.add(request);
			
			println("요청 보냄.");
			
	  }
	  
	  public void println(String data) {
			textView.append(data);
	  }
}










































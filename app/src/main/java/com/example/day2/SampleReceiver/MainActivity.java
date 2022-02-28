package com.example.day2.SampleReceiver;

import java.security.Permission;

import com.example.day2.R;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_sample_receiver);
			
			//모든 위험 권한을 자동 부여하도록하는 메서드를 호출합니다.
			AutoPermissions.Companion.loadAllPermissions(this, 101);
	  }
	  
	  @Override
	  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
		  @NonNull int[] grantResults) {
			
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
			AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
	  }
	  
	  @Override
	  public void onDenied(int requestCode, @NonNull String[] permissions) {
			Toast.makeText(this, "permissions denied : " + permissions.length, Toast.LENGTH_SHORT).show();
	  }
	  
	  @Override
	  public void onGranted(int requestCode, @NonNull String[] permissions) {
			Toast.makeText(this, "permissions onGranted : " + permissions.length, Toast.LENGTH_SHORT).show();
			
	  }
}
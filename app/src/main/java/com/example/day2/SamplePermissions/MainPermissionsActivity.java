package com.example.day2.SamplePermissions;

import java.util.ArrayList;

import com.example.day2.MenuActivity;
import com.example.day2.R;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class MainPermissionsActivity extends AppCompatActivity {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_permissions);
			
			String[] permissions = {
				Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.WRITE_EXTERNAL_STORAGE
				
			};
			checkPermissions(permissions);
	  }
	  
	  private void checkPermissions(String[] permissions) {
			ArrayList<String> targetList = new ArrayList<>();
			
			for (int indexPerm = 0; indexPerm < permissions.length; indexPerm += 1) {
				  String curPermission = permissions[indexPerm];
				  int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
				  
				  if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
						Toast.makeText(this,curPermission+" 권한 있음")
				  } else {
						
				  }
				  
			}
	  }
}
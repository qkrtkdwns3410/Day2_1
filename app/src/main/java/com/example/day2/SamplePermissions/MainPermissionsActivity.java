package com.example.day2.SamplePermissions;

import java.util.ArrayList;

import com.example.day2.MenuActivity;
import com.example.day2.R;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainPermissionsActivity extends AppCompatActivity implements AutoPermissionsListener {
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_permissions);
			
			AutoPermissions.Companion.loadAllPermissions(this, 101);//자동으로 권한을 부여합니다.
	  }
	  
	  //요청코드와 함께 사용자가 권한을 수락했는지 여부가 파라미터로 전달됨.
	  @Override
	  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
		  @NonNull int[] grantResults) {
			
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
			
			AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this); //권한부여의 결과가 승인 > onGranted
			//거부 > onDenied()...
	  }
	  
	  private void checkPermissions(String[] permissions) {
			
			ArrayList<String> targetList = new ArrayList<>();
			
			for (int indexPerm = 0; indexPerm < permissions.length; indexPerm += 1) {
				  
				  String curPermission = permissions[indexPerm];
				  //checkSelfPermission : 이미 권한이 부여되어 있는지 확인합니다.
				  int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
				  
				  if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
						Toast.makeText(this, curPermission + " 권한 있음.", Toast.LENGTH_SHORT).show();
				  } else {
						Toast.makeText(this, curPermission + " 권한 없음.", Toast.LENGTH_SHORT).show();
						
						if (ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
							  Toast.makeText(this, curPermission + " 권한 설명 필요함.", Toast.LENGTH_SHORT).show();
							  
						} else {
							  targetList.add(curPermission);
							  
						}
				  }
			}
			
			String[] targets = new String[targetList.size()];
			targetList.toArray(targets);
			
			//위험 권한 부여 요청하기
			ActivityCompat.requestPermissions(this, targets, 101);
	  }
	  
	  @Override
	  public void onDenied(int requestCode, @NonNull String[] permissions) {
			Toast.makeText(this, "permissions denied : " + permissions.length, Toast.LENGTH_SHORT).show();
	  }
	  
	  @Override
	  public void onGranted(int requestCode, @NonNull String[] permissions) {
			Toast.makeText(this, "permissions granted : " + permissions.length, Toast.LENGTH_SHORT).show();
			
	  }
}









































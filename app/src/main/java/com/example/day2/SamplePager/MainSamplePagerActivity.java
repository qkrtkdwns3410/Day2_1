package com.example.day2.SamplePager;

import java.util.ArrayList;

import com.example.day2.R;
import com.example.day2.SampleTab.Fragment1;
import com.example.day2.SampleTab.Fragment2;
import com.example.day2.SampleTab.Fragment3;

import android.bluetooth.le.AdvertisingSetParameters;
import android.mtp.MtpConstants;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class MainSamplePagerActivity extends AppCompatActivity {
	  ViewPager pager;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main_sample_pager);
			
			Button button = findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View v) {
						pager.setCurrentItem(1);
						//손가락으로 화면 전환없이 버튼으로 페이지를 변경합니다.
				  }
			});
			
			pager = findViewById(R.id.pager);
			//미리 로딩해 놓은 아이템의 개수를 3개로 설정
			//기본값은 3보다 작다고 합니다
			pager.setOffscreenPageLimit(3);
			
			MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
			
			Fragment1 fragment1 = new Fragment1();
			adapter.addItem(fragment1);
			
			Fragment2 fragment2 = new Fragment2();
			adapter.addItem(fragment2);
			
			Fragment3 fragment3 = new Fragment3();
			adapter.addItem(fragment3);
			
			//어댑터 객체가 설정 > 뷰페이저  > 어뎁터에 있는 프래그먼트들을 화면에 띄울 수가 있습니다.
			pager.setAdapter(adapter);
	  }
	  
	  //내부 클래스 >> FragmentStatePagerAdapter 상속
	  //Adapter의 역할 : 뷰페이저에 보여줄 각 프래그먼트를 관리하는 역할 || 뷰페이저에 설정하면 서로 상호작용하면서 화면에 표시!
	  //MyPagerAdapter << 에는 프래그먼트 객체들이 담깁니다. addItem << 프래그먼트 추가. getItem << 프래그먼트 get || ...
	  class MyPagerAdapter extends FragmentStatePagerAdapter {
			ArrayList<Fragment> items = new ArrayList<>();
			
			public MyPagerAdapter(@NonNull FragmentManager fm) {
				  super(fm);
			}
			
			public void addItem(Fragment item) {
				  items.add(item);
			}
			
			@NonNull
			@Override
			public Fragment getItem(int position) {
				  return items.get(position);
			}
			
			@Override
			public int getCount() {
				  return items.size();
			}
			
			@Nullable
			@Override
			public CharSequence getPageTitle(int position) {
				  return "페이지" + position;
			}
	  }
}
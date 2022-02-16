package com.example.day2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
	  
	  //onCreateView >> 메서드는 프래그먼트와 관련되는 뷰들의 계층도를 구성하는 과정에서 호출
	  //액티비티가 처음 메모리에 만듬 > 액티비티 onCreate() 메서드 호출 > 프래그먼트 onActivityCreated() 메서드 호출 >
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
			  Bundle savedInstanceState) {
			// Inflate the layout for this fragment
			return inflater.inflate(R.layout.fragment_menu, container, false);
	  }
}
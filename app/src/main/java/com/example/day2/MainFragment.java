package com.example.day2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

	  @Override
	  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			  @Nullable Bundle savedInstanceState) {
			//LayoutInflater >> 해당 객체의 inflate() 메서드를 바로 호출할 수 있습니다.
			//inflate() 메서드로 전달되는 첫번째 파라미터는 .. XML레이아웃 파일 | 두 번째 파라미터는 XML 레이아웃이 될 뷰그룹 객체 >> inflate () 메서드 호출시 인플레이션이 실행
			//ViewGroup 해당 프래그먼트의 가장 상위 레이아웃 | inflate() 의 결과로 ViewGroup 객체 반환 > 해당 객체를 return 으로 반환합니다

			ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);
			// inflate() >> xml에 씌여져있는 view 정의를 실제 view객체로 만드는 역할 >> 메모리를 객체위에 올려놓은 과정

			Button button = rootView.findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View view) {
						SampleFragment activity = (SampleFragment)getActivity();
						//프래그 먼트에서 getActivity() 메서드 호출시  / 프래그 먼트가 올라가 있는 액티비티가 어떤 것인지 파악가능
						activity.onFragmentChanged(0);
				  }
			});

			return rootView;
	  }
}
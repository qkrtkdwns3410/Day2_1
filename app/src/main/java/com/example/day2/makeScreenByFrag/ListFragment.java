package com.example.day2.makeScreenByFrag;

import com.example.day2.R;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    
    public ImageSelectionCallBack callBack;
    
    //프래그먼트가 액티비티 위에 올라오는 시점에 호출
    //프래그먼트에서 해당 액티비티를 참조하고 싶다면, onAttach() 메서드로 전달되는 파라미터를 참조! getActivity() 메서드를 호출!
    //반환된 객체를 변수에 할당하여 > 프래그먼트 클래스 안에서 자유롭게 액티비티 객체를 참조할 수 있음.
    
    @Override
    public void onAttach(@NonNull Context context) {
        
        super.onAttach(context);
        
        if (context instanceof ImageSelectionCallBack) {
            //callBack 변수의 자료형이 ImageSelectionCallBack 인 이유?
            // 화면에서 선택된 버튼에 따라 다른 프래그먼트의 이미지를 변경하는 경우 액티비티 쪽으로 데이터를 전달해야합니다.
            //해당 액티비티에 onImageSelected 정의후 해당 메서드 호출
            //매번 액티비티마다 다른 이름의 메서드를 만드는 경우, 프래그먼트가 올라간 액티비티가 다른 액티비티로 변경되는 경우, 해당 액티비티가 무엇인지 매번 확인해야하는 번거로움이 있음.
            //인터페이스를 정의한 후 액티비티가 해당 인터페이스를 구현하도록 하는 것이 좋음
            callBack = (ImageSelectionCallBack)context;
        }
    }
    
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);
        
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null) {
                    callBack.onImageSelected(0);
                }
            }
        });
        
        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null) {
                    callBack.onImageSelected(1);
                }
            }
        });
        
        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null) {
                    callBack.onImageSelected(2);
                }
            }
        });
        
        return rootView;
    }
    
    public interface ImageSelectionCallBack {
        void onImageSelected(int position);
    }
}
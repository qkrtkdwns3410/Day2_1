package com.example.day2.makeScreenByFrag;

import com.example.day2.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    ImageView imageView;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_viewer, container, false);
        
        imageView = rootView.findViewById(R.id.imageView);
        
        return rootView;
    }
    
    //setImage() 메서드 >> 액티비티에서 이 프래그먼트에 있는 이미지뷰에 이미지를 설정합니다.
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
    
}
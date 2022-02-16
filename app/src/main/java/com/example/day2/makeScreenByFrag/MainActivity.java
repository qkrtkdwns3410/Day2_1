package com.example.day2.makeScreenByFrag;

import com.example.day2.R;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallBack {
    
    ListFragment listFragment;
    ViewerFragment viewerFragment;
    
    int[] images = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        FragmentManager manager = getSupportFragmentManager();
        //2개의 프라그먼트를 찾아 변수에 할당합니다. 이 MainActivity는 ImageSelectionCallback 인터페이스를 구현하도록 만들고, 인터페이스에 정의된 onImageSelected() 메서드도 구현.
        //onimageSelected() 호출시 뷰어 프래그먼트의 setImage() 메서드 호출로 이미지가 변경됩니다.
        listFragment = (ListFragment)manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment)manager.findFragmentById(R.id.viewerFragment);
        
    }
    
    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}
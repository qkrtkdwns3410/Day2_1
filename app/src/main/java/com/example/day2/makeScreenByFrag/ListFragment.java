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
	  
	  @Override
	  public void onAttach(@NonNull Context context) {
			super.onAttach(context);
			
			if (context instanceof ImageSelectionCallBack) {
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
						
				  }
			});
			
			return rootView;
	  }
	  
	  public static interface ImageSelectionCallBack {
			public void onImageSelected(int position);
	  }
}
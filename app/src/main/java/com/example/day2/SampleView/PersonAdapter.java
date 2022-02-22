package com.example.day2.SampleView;

import java.util.ArrayList;
import java.util.List;

import com.example.day2.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 *packageName    : com.example.day2.SampleView
 * fileName       : PersonAdapter
 * author         : ipeac
 * date           : 2022-02-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-22        ipeac       최초 생성
 */
/*리스트 형태로 보일 때 각각의 아이템은 뷰로 만들어지고....
 * 각각의 아이템을 위한 뷰는 뷰홀더에 담아두게 됩니다.
 * 해당 뷰홀더 역할을 하는 클래스 > PersonAdapter클래스 안에 넣음...
 *
 * */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
	  ArrayList<Person> items = new ArrayList<>();
	  
	  //onCreateViewHolder | onBindViewHolder : 뷰홀더 객체가 만들어 질때.. 사용될 때 호출됩니다.
	  @NonNull
	  @Override
	  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
			//viewType : 아이템을 위한 뷰를 여러 가지로 나누어 주고 싶은 경우 사용됨.
			// 이미지 only | 이미지 + 텍스트
			LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
			View itemView = inflater.inflate(R.layout.person_item, viewGroup, false);
			
			return new ViewHolder(itemView); //뷰홀더 객체를 생성하면서 뷰 객체를 전달... > 해당하는 뷰 홀더 객체를 반환
	  }
	  
	  //뷰 홀더가 재사용될 때 호출.
	  @Override
	  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
			Person item = items.get(position);
			viewHolder.setItem(item);
			//해당 뷰객체는 기존의 것을 그대로 사용하고 데이터만 변경합니다.
	  }
	  
	  //어댑터에서 관리하는 아이템의 개수를 반환
	  //리사이클러 뷰에서 어댑터가 관리하는 아이템의 개수를 알아야할 때 사용됨.
	  @Override
	  public int getItemCount() {
			return items.size();
	  }
	  
	  public void addItem(Person item) {
			items.add(item);
	  }
	  
	  public void setItems(ArrayList<Person> items) {
			this.items = items;
	  }
	  
	  public Person getItem(int position) {
			return items.get(position);
	  }
	  
	  public void setItem(int position, Person item) {
			items.set(position, item);
	  }
	  
	  //뷰홀더클래스의 생성자에는 뷰 객체가 전달됩니다.
	  static class ViewHolder extends RecyclerView.ViewHolder {
			TextView textView;
			TextView textView2;
			
			public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
				  super(itemView);
				  
				  //전달받은 뷰 객체의 이미지나 텍스트뷰를 변수에 할당!
				  textView = itemView.findViewById(R.id.textView);
				  textView2 = itemView.findViewById(R.id.textView2);
				  
				  itemView.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							  int position = getAdapterPosition();
							  
							  if (listener != null) {
									
							  }
						}
				  });
			}
			
			//setter에서 참조합니다. > 이 뷰홀더에 들어 있는 뷰 객체의 데이터를 다른 것으로 보이도록합니다.
			public void setItem(Person item) {
				  textView.setText(item.getName());
				  textView.setText(item.getMobile());
			}
	  }
}





























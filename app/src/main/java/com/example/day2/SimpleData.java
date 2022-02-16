package com.example.day2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *packageName    : com.example.day2
 * fileName       : SimpleDate
 * author         : letscombine
 * date           : 2022-02-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-16        letscombine       최초 생성
 */
public class SimpleData implements Parcelable {

	int number;
	String message;

	public SimpleData(int num, String msg) {
		number = num;
		message = msg;

	}

	public SimpleData(Parcel src) { //Parcel 객체를 읽습니다.
		number = src.readInt();
		message = src.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) { //Parcel 객체로 쓰기
		dest.writeInt(number);
		dest.writeString(message);
	}

	public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() { //CREATOR 상수 정의
		@Override
		public SimpleData createFromParcel(Parcel in) { //SimpleData 생성자를 호출해 Parcel 객체에서 읽기
			return new SimpleData(in);
		}

		@Override
		public SimpleData[] newArray(int size) { //
			return new SimpleData[size];
		}
	};
}


























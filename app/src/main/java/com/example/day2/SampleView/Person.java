package com.example.day2.SampleView;

/**
 *packageName    : com.example.day2.SampleView
 * fileName       : Person
 * author         : ipeac
 * date           : 2022-02-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-02-22        ipeac       최초 생성
 */
public class Person {
	  String name;
	  String mobile;
	  
	  public Person(String name, String mobileNum) {
			this.name = name;
			this.mobile = mobileNum;
	  }
	  
	  public String getName() {
			return name;
	  }
	  
	  public void setName(String name) {
			this.name = name;
	  }
	  
	  public String getMobile() {
			return mobile;
	  }
	  
	  public void setMobile(String mobile) {
			this.mobile = mobile;
	  }
}





























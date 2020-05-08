package demo.request;

import lombok.ToString;

@ToString
public class RequestData {

	  private String userYear = "0";
	  private String userMonth = "0";
	  private String userDay = "0";

	  public String getUserYear(){
	    return userYear;
	  }

	  public void setUserYear(String userYear){
	    this.userYear = userYear;
	  }

	  public String getUserMonth(){
	    return userMonth;
	  }

	  public void setNum(String userMonth){
	    this.userMonth = userMonth;
	  }

	  public String getuserDay(){
	    return userDay;
	  }

	  public void setUserDay(String userDay){
	    this.userDay = userDay;
	  }

}

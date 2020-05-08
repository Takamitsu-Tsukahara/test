package demo.domain.model;

import java.util.Date;

import lombok.ToString;


@ToString
public class ModelData {

	private Date daydata;

	public Date getDaydata() {
		return daydata;
	}

	public void setDaydata(Date daydata) {
		this.daydata = daydata;
	}

}
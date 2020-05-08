package demo.requestdata;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestUserData implements Serializable {

		private String name;

		private String address;

		private String gender;
}

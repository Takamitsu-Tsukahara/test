package demo.requestdata;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class RequestUpdateData  extends RequestUserData implements Serializable {

	@NotNull
	private Integer id;

}
